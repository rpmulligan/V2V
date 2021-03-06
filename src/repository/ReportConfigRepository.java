package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.ReportConfig;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReportConfigRepository {
	@PersistenceContext
	private EntityManager em;

	public void saveReportConfig(ReportConfig reportConfig) {
		em.persist(reportConfig);
		em.flush();
	}

	public List<ReportConfig> getAllReportConfigs() {
		Query query = em.createQuery("SELECT rc FROM ReportConfig rc");
		return query.getResultList();
	}

	public ReportConfig getReportConfig(String reportType) {
		return em.find(ReportConfig.class, reportType);
	}

	public ReportConfig updateReportConfig(String reportType, String fieldNames) {
		ReportConfig existingReportConfig = em.find(ReportConfig.class,
				reportType);
		existingReportConfig.setFieldNames(fieldNames);
		em.merge(existingReportConfig);
		em.flush();
		return existingReportConfig;
	}
}
