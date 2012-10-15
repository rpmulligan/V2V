package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-10-14T22:37:27.249-0400")
@StaticMetamodel(Collection.class)
public class Collection_ {
	public static volatile SingularAttribute<Collection, Long> collectionId;
	public static volatile SingularAttribute<Collection, String> collectionNumber;
	public static volatile SingularAttribute<Collection, Long> centerId;
	public static volatile SingularAttribute<Collection, Long> siteId;
	public static volatile SingularAttribute<Collection, Date> dateCollected;
	public static volatile SingularAttribute<Collection, Long> sampleNumber;
	public static volatile SingularAttribute<Collection, Long> shippingNumber;
	public static volatile SingularAttribute<Collection, String> donorNumber;
	public static volatile SingularAttribute<Collection, String> donorType;
	public static volatile SingularAttribute<Collection, String> abo;
	public static volatile SingularAttribute<Collection, String> rhd;
	public static volatile SingularAttribute<Collection, String> comments;
	public static volatile SingularAttribute<Collection, Boolean> isDeleted;
}
