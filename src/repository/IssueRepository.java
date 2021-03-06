package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Issue;
import model.Request;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Repository
@Transactional
public class IssueRepository {
	@PersistenceContext
	private EntityManager em;

	public void saveIssue(Issue issue) {
    em.persist(issue);
    em.flush();
//    Issue existingIssue = findByIssueNumber(issue.getIssueId());
//    if (existingIssue == null) {
//    } else {
//        em.merge(existingIssue);
//        em.flush();
//    }
	}

	private Issue findByIssueNumber(Long issueId) {
    TypedQuery<Issue> query = em
        .createQuery(
            "SELECT i FROM Issue i WHERE i.issueId = :issueId and i.isDeleted= :isDeleted",
            Issue.class);
    query.setParameter("isDeleted", Boolean.FALSE);
    query.setParameter("issueId", issueId);
    List<Issue> issues = query.getResultList();
    if (CollectionUtils.isEmpty(issues)) {
      return null;
    }
    return issues.get(0);
  }

  public Issue updateIssue(Issue issue, String existingIssueId) {
		Issue existingIssue = em.find(Issue.class, existingIssueId);
		existingIssue.copy(issue);
		em.merge(existingIssue);
		em.flush();
		return existingIssue;
	}

	// public Request findRequest(String requestNumber) {
	// Request request = null;
	// if (requestNumber != null && requestNumber.length() > 0) {
	// String queryString =
	// "SELECT p FROM Request p WHERE p.requestNumber = :requestNumber and p.isDeleted= :isDeleted";
	// TypedQuery<Request> query = em.createQuery(
	// queryString, Request.class);
	// query.setParameter("isDeleted", Boolean.FALSE);
	// List<Request> requests = query.setParameter("requestNumber",
	// requestNumber).getResultList();
	// if (requests != null && requests.size() > 0) {
	// request = requests.get(0);
	// }
	// }
	// return request;
	// }
	//
	// public Request findRequest(Long requestId) {
	// Request request = null;
	// if (requestId != null) {
	// String queryString =
	// "SELECT p FROM Request p WHERE p.requestId = :requestId and p.isDeleted= :isDeleted";
	// TypedQuery<Request> query = em.createQuery(
	// queryString, Request.class);
	// query.setParameter("isDeleted", Boolean.FALSE);
	// List<Request> requests = query.setParameter("requestId",
	// requestId).getResultList();
	// if (requests != null && requests.size() > 0) {
	// request = requests.get(0);
	// }
	// }
	// return request;
	// }

	public ArrayList<Issue> getAllIssues() {
		String queryString = "SELECT i FROM Issue i where i.isDeleted = :isDeleted order by i.dateIssued desc";
		TypedQuery<Issue> query = em.createQuery(queryString, Issue.class);
		query.setParameter("isDeleted", Boolean.FALSE);
		return new ArrayList<Issue>(query.getResultList());
	}

	public void deleteAllIssues() {
		Query query = em.createQuery("DELETE FROM Issue i");
		query.executeUpdate();
	}

	// public List<Request> getRequests(Date fromDateRequested, Date
	// toDateRequested) {
	// TypedQuery<Request> query = em.createQuery(
	// "SELECT p FROM Request p WHERE  p.dateRequested >= :fromDate and p.dateRequested<= :toDate and p.isDeleted = :isDeleted",
	// Request.class);
	// query.setParameter("fromDate", fromDateRequested);
	// query.setParameter("toDate", toDateRequested);
	// query.setParameter("isDeleted", Boolean.FALSE);
	// List<Request> requests = query.getResultList();
	// if (CollectionUtils.isEmpty(requests)) {
	// return new ArrayList<Request>();
	// }
	// return requests;
	// }

	// public void delete(String existingRequestNumber) {
	// Request existingRequest = findRequest(existingRequestNumber);
	// existingRequest.setIsDeleted(Boolean.TRUE);
	// em.merge(existingRequest);
	// em.flush();
	// }
}
