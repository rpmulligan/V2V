package repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.ProductUsage;
import model.Request;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Repository
@Transactional
public class UsageRepository {
  @PersistenceContext
  private EntityManager em;

  public void saveUsage(ProductUsage productUsage) {
    em.persist(productUsage);
    em.flush();
  }

  public ProductUsage findProductUsage(String productNumber) {
    ProductUsage productUsage = null;
    if (productNumber != null && productNumber.length() > 0) {
      String queryString = "SELECT p FROM ProductUsage p WHERE p.productNumber = :productNumber and p.isDeleted= :isDeleted";
      TypedQuery<ProductUsage> query = em.createQuery(queryString,
          ProductUsage.class);
      query.setParameter("isDeleted", Boolean.FALSE);
      List<ProductUsage> productUsages = query.setParameter("productNumber",
          productNumber).getResultList();
      if (productUsages != null && productUsages.size() > 0) {
        productUsage = productUsages.get(0);
      }
    }
    return productUsage;
  }

  public ProductUsage updateUsage(ProductUsage productUsage) {
    ProductUsage existingProductUsage = findProductUsage(productUsage
        .getProductNumber());
    existingProductUsage.copy(productUsage);
    em.merge(existingProductUsage);
    em.flush();
    return existingProductUsage;
  }

  public void deleteAllUsages() {
    Query query = em.createQuery("DELETE FROM ProductUsage u");
    query.executeUpdate();
  }

  public List<ProductUsage> findAnyUsageMatching(String productNumber,
      String dateUsedFrom, String dateUsedTo, List<String> useIndications) {

    TypedQuery<ProductUsage> query = em.createQuery(
        "SELECT u FROM ProductUsage u WHERE "
            + "(u.productNumber = :productNumber OR "
            + "u.useIndication IN (:useIndications)) AND "
            + "(u.dateUsed BETWEEN :dateUsedFrom AND " + ":dateUsedTo) AND "
            + "(u.isDeleted= :isDeleted)", ProductUsage.class);

    query.setParameter("isDeleted", Boolean.FALSE);

    query.setParameter("productNumber", productNumber == null ? ""
        : productNumber);
    query.setParameter("useIndications", useIndications);

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    try {
      Date from = (dateUsedFrom == null || dateUsedFrom.equals("")) ? dateFormat
          .parse("12/31/1970") : dateFormat.parse(dateUsedFrom);
      query.setParameter("dateUsedFrom", from);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    try {
      Date to = (dateUsedTo == null || dateUsedTo.equals("")) ? dateFormat
          .parse(dateFormat.format(new Date())) : dateFormat.parse(dateUsedTo);
      query.setParameter("dateUsedTo", to);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    List<ProductUsage> resultList = query.getResultList();
    return resultList;
  }

  public ProductUsage findUsageByProductNumber(String productNumber) {
    TypedQuery<ProductUsage> query = em
        .createQuery(
            "SELECT u FROM ProductUsage u WHERE u.productNumber = :productNumber and u.isDeleted= :isDeleted",
            ProductUsage.class);
    query.setParameter("isDeleted", Boolean.FALSE);
    query.setParameter("productNumber", productNumber);
    List<ProductUsage> usage = query.getResultList();
    if (CollectionUtils.isEmpty(usage)) {
      return null;
    }
    return usage.get(0);
  }

  public ProductUsage updateOrAddUsage(ProductUsage usage) {
    ProductUsage existingUsage = findUsageByProductNumber(usage
        .getProductNumber());
    if (existingUsage == null) {
      usage.setIsDeleted(false);
      saveUsage(usage);
      return usage;
    }
    existingUsage.copy(usage);
    existingUsage.setIsDeleted(false);
    em.merge(existingUsage);
    em.flush();
    return existingUsage;
  }

  public void deleteUsage(String productNumber) {
    ProductUsage existingUsage = findUsageByProductNumber(productNumber);
    existingUsage.setIsDeleted(Boolean.TRUE);
    em.merge(existingUsage);
    em.flush();
  }
}
