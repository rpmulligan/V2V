package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-10-14T22:37:27.322-0400")
@StaticMetamodel(LocationType.class)
public class LocationType_ {
	public static volatile SingularAttribute<LocationType, Long> locationTypeId;
	public static volatile SingularAttribute<LocationType, String> name;
	public static volatile SingularAttribute<LocationType, String> comments;
	public static volatile SingularAttribute<LocationType, Boolean> isDeleted;
}
