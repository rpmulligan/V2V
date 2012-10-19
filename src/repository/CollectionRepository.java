package repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.CollectedSample;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Repository
@Transactional
public class CollectionRepository {
  @PersistenceContext
  private EntityManager em;

  public void saveCollection(CollectedSample collection) {
    em.persist(collection);
    em.flush();
  }

  public CollectedSample updateCollection(CollectedSample collection, Long collectionId) {
    CollectedSample existingCollection = findCollectionById(collectionId);
    existingCollection.copy(collection);
    em.merge(existingCollection);
    em.flush();
    return existingCollection;
  }

  public CollectedSample findCollectionById(Long collectionId) {
    return em.find(CollectedSample.class, collectionId);
  }

  public void deleteAllCollections() {
    Query query = em.createQuery("DELETE FROM Collection c");
    query.executeUpdate();
  }

  public CollectedSample findCollectionByNumber(String collectionNumber) {
    TypedQuery<CollectedSample> query = em
        .createQuery(
            "SELECT c FROM Collection c WHERE c.collectionNumber = :collectionNumber and c.isDeleted= :isDeleted",
            CollectedSample.class);
    query.setParameter("isDeleted", Boolean.FALSE);
    query.setParameter("collectionNumber", collectionNumber);
    List<CollectedSample> collections = query.getResultList();
    if (CollectionUtils.isEmpty(collections)) {
      return null;
    }
    return collections.get(0);
  }

  public List<CollectedSample> getAllCollections() {
    Query query = em.createQuery(
        "SELECT c FROM Collection c WHERE c.isDeleted= :isDeleted",
        CollectedSample.class);
    query.setParameter("isDeleted", Boolean.FALSE);
    return query.getResultList();
  }

  public List<CollectedSample> getCollections(Date fromDate, Date toDate) {
    TypedQuery<CollectedSample> query = em
        .createQuery(
            "SELECT c FROM Collection c WHERE c.dateCollected >= :fromDate and c.dateCollected<= :toDate and c.isDeleted= :isDeleted",
            CollectedSample.class);
    query.setParameter("isDeleted", Boolean.FALSE);
    query.setParameter("fromDate", fromDate);
    query.setParameter("toDate", toDate);
    List<CollectedSample> collections = query.getResultList();
    if (CollectionUtils.isEmpty(collections)) {
      return new ArrayList<CollectedSample>();
    }
    return collections;
  }

  public void deleteCollection(String collectionNumber) {
    CollectedSample existingCollection = findCollectionByNumber(collectionNumber);
    existingCollection.setIsDeleted(Boolean.TRUE);
    em.merge(existingCollection);
    em.flush();
  }

  public List<CollectedSample> findAnyCollectionMatching(String collectionNumber,
      String sampleNumber, String shippingNumber, String dateCollectedFrom,
      String dateCollectedTo, List<String> centers) {

    // TODO: fix join condition
    TypedQuery<CollectedSample> query = em.createQuery(
        "SELECT c FROM Collection c, Location L WHERE "
            + " L.locationId=c.centerId AND L.isCenter=TRUE AND ("
            + "c.collectionNumber = :collectionNumber OR "
            + "c.sampleNumber = :sampleNumber OR "
            + "c.shippingNumber = :shippingNumber OR "
            + "L.name IN (:centers)) AND ("
            + "c.dateCollected BETWEEN :dateCollectedFrom AND "
            + ":dateCollectedTo" + ") AND " + "(c.isDeleted= :isDeleted)",
        CollectedSample.class);

    query.setParameter("isDeleted", Boolean.FALSE);
    String collectionNo = ((collectionNumber == null) ? "" : collectionNumber);
    query.setParameter("collectionNumber", collectionNo);
    Long sampleNo = ((sampleNumber == null) ? -1 : Long.parseLong(sampleNumber));
    query.setParameter("sampleNumber", sampleNo);
    Long shippingNo = ((shippingNumber == null) ? -1 : Long
        .parseLong(shippingNumber));
    query.setParameter("shippingNumber", shippingNo);

    query.setParameter("centers", centers);

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    try {
      Date from = (dateCollectedFrom == null || dateCollectedFrom.equals("")) ? dateFormat
          .parse("12/31/1970") : dateFormat.parse(dateCollectedFrom);
      query.setParameter("dateCollectedFrom", from);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    try {
      Date to = (dateCollectedTo == null || dateCollectedTo.equals("")) ? dateFormat
          .parse(dateFormat.format(new Date())) : dateFormat
          .parse(dateCollectedTo);
      query.setParameter("dateCollectedTo", to);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    List<CollectedSample> resultList = query.getResultList();
    return resultList;
  }

  public CollectedSample updateOrAddCollection(CollectedSample collection) {
    CollectedSample existingCollection = findCollectionByNumber(collection
        .getCollectionNumber());
    if (existingCollection == null) {
      collection.setIsDeleted(false);
      saveCollection(collection);
      return collection;
    }
    existingCollection.copy(collection);
    existingCollection.setIsDeleted(false);
    em.merge(existingCollection);
    em.flush();
    return existingCollection;
  }

  public Map<Long, Long> findNumberOfCollections(String dateCollectedFrom,
      String dateCollectedTo, String aggregationCriteria) {

    TypedQuery<Object[]> query = em.createQuery(
        "SELECT count(c), c.dateCollected FROM Collection c WHERE "
            + "c.dateCollected BETWEEN :dateCollectedFrom AND "
            + ":dateCollectedTo AND (c.isDeleted= :isDeleted) GROUP BY "
            + "dateCollected", Object[].class);

    query.setParameter("isDeleted", Boolean.FALSE);

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date from = null;
    Date to = null;
    try {
      from = (dateCollectedFrom == null || dateCollectedFrom.equals("")) ? dateFormat
          .parse("12/31/2011") : dateFormat.parse(dateCollectedFrom);
      query.setParameter("dateCollectedFrom", from);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    try {
      to = (dateCollectedTo == null || dateCollectedTo.equals("")) ? dateFormat
          .parse(dateFormat.format(new Date())) : dateFormat
          .parse(dateCollectedTo);
      query.setParameter("dateCollectedTo", to);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    DateFormat resultDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    String groupByFunc = "DAY";
    int incrementBy = Calendar.DAY_OF_YEAR;
    if (aggregationCriteria.equals("monthly")) {
      groupByFunc = "MONTH";
      incrementBy = Calendar.MONTH;
      resultDateFormat = new SimpleDateFormat("MM/01/yyyy");
    } else if (aggregationCriteria.equals("yearly")) {
      groupByFunc = "YEAR";
      incrementBy = Calendar.YEAR;
      resultDateFormat = new SimpleDateFormat("01/01/yyyy");
    }

    List<Object[]> resultList = query.getResultList();

    Map<Long, Long> m = new HashMap<Long, Long>();
    Calendar gcal = new GregorianCalendar();
    Date lowerDate = null;
    Date upperDate = null;
    try {
      lowerDate = resultDateFormat.parse(resultDateFormat.format(from));
      upperDate = resultDateFormat.parse(resultDateFormat.format(to));
    } catch (ParseException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    gcal.setTime(lowerDate);
    while (gcal.getTime().before(upperDate) || gcal.getTime().equals(upperDate)) {
      m.put(gcal.getTime().getTime(), (long) 0);
      gcal.add(incrementBy, 1);
    }

    for (Object[] result : resultList) {
      Date d = (Date) result[1];
      try {
        Date formattedDate = resultDateFormat.parse(resultDateFormat.format(d));
        Long utcTime = formattedDate.getTime();
        if (m.containsKey(utcTime)) {
          Long newVal = m.get(utcTime) + (Long) result[0];
          m.put(utcTime, newVal);
        } else {
          m.put(utcTime, (Long) result[0]);
        }
      } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return m;
  }
}
