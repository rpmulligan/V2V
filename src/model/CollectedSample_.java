package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-10-19T02:41:16.167-0400")
@StaticMetamodel(CollectedSample.class)
public class CollectedSample_ {
	public static volatile SingularAttribute<CollectedSample, String> collectionNumber;
	public static volatile SingularAttribute<CollectedSample, DonorType> donorType;
	public static volatile SingularAttribute<CollectedSample, Boolean> isDeleted;
	public static volatile SingularAttribute<CollectedSample, Donor> donor;
	public static volatile SingularAttribute<CollectedSample, Long> id;
	public static volatile ListAttribute<CollectedSample, TestResult> testResults;
	public static volatile SingularAttribute<CollectedSample, Location> site;
	public static volatile SingularAttribute<CollectedSample, Location> center;
	public static volatile SingularAttribute<CollectedSample, Date> lastUpdated;
	public static volatile SingularAttribute<CollectedSample, Date> createdDate;
	public static volatile SingularAttribute<CollectedSample, User> createdBy;
	public static volatile SingularAttribute<CollectedSample, User> lastUpdatedBy;
	public static volatile SingularAttribute<CollectedSample, String> notes;
	public static volatile SingularAttribute<CollectedSample, Date> collectedOn;
	public static volatile SingularAttribute<CollectedSample, String> sampleNumber;
	public static volatile SingularAttribute<CollectedSample, String> shippingNumber;
	public static volatile ListAttribute<CollectedSample, Product> products;
}
