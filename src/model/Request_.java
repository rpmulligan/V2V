package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-10-19T02:01:28.349-0400")
@StaticMetamodel(Request.class)
public class Request_ {
	public static volatile SingularAttribute<Request, String> requestNumber;
	public static volatile SingularAttribute<Request, ProductType> productType;
	public static volatile SingularAttribute<Request, Integer> quantity;
	public static volatile SingularAttribute<Request, RequestStatus> status;
	public static volatile SingularAttribute<Request, Long> id;
	public static volatile SingularAttribute<Request, Location> requestSite;
	public static volatile SingularAttribute<Request, BloodAbo> bloodAbo;
	public static volatile SingularAttribute<Request, BloodRhd> bloodRhd;
	public static volatile SingularAttribute<Request, Date> lastUpdated;
	public static volatile SingularAttribute<Request, Date> createdDate;
	public static volatile SingularAttribute<Request, User> createdBy;
	public static volatile SingularAttribute<Request, User> lastUpdatedBy;
	public static volatile SingularAttribute<Request, String> notes;
	public static volatile SingularAttribute<Request, Boolean> isDeleted;
	public static volatile ListAttribute<Request, Issue> issuedProducts;
	public static volatile SingularAttribute<Request, Date> requestedOn;
	public static volatile SingularAttribute<Request, Date> requiredOn;
}
