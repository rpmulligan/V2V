package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.LocationType;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LocationTypeRepository {
	@PersistenceContext
	private EntityManager em;

	public void saveLocationType(LocationType locationType) {
		em.persist(locationType);
		em.flush();
	}

	public void deleteAllLocationTypes() {
		Query query = em.createQuery("DELETE FROM LocationType lt");
		query.executeUpdate();
	}

	public List<LocationType> getAllLocationTypes() {
		Query query = em
				.createQuery("SELECT l FROM LocationType l where l.isDeleted= :isDeleted");
		query.setParameter("isDeleted", Boolean.FALSE);
		return query.getResultList();
	}

	public LocationType getLocationType(Long selectedLocationTypeId) {
		try {
			TypedQuery<LocationType> query = em
					.createQuery(
							"SELECT l FROM LocationType l where l.locationTypeId=:locationTypeId and l.isDeleted= :isDeleted",
							LocationType.class);
			query.setParameter("locationTypeId", selectedLocationTypeId);
			query.setParameter("isDeleted", Boolean.FALSE);
			return query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}

	public LocationType updateLocationType(Long locationTypeId,
			LocationType locationType) {
		LocationType existingLocation = em.find(LocationType.class,
				locationTypeId);
		existingLocation.copy(locationType);
		em.merge(existingLocation);
		em.flush();
		return existingLocation;
	}

	public void deleteLocationType(Long locationTypeId) {
		LocationType existingLocation = em.find(LocationType.class,
				locationTypeId);
		existingLocation.setIsDeleted(Boolean.TRUE);
		em.merge(existingLocation);
		em.flush();
	}
}
