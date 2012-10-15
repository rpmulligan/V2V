package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-10-14T22:37:27.320-0400")
@StaticMetamodel(Location.class)
public class Location_ {
	public static volatile SingularAttribute<Location, Long> locationId;
	public static volatile SingularAttribute<Location, String> name;
	public static volatile SingularAttribute<Location, Long> type;
	public static volatile SingularAttribute<Location, Boolean> isCenter;
	public static volatile SingularAttribute<Location, Boolean> isCollectionSite;
	public static volatile SingularAttribute<Location, Boolean> isUsageSite;
	public static volatile SingularAttribute<Location, Boolean> isMobileSite;
	public static volatile SingularAttribute<Location, Boolean> isDeleted;
	public static volatile SingularAttribute<Location, String> comments;
}
