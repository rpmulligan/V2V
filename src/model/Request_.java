package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-10-14T22:37:27.366-0400")
@StaticMetamodel(Request.class)
public class Request_ {
	public static volatile SingularAttribute<Request, Long> requestId;
	public static volatile SingularAttribute<Request, String> requestNumber;
	public static volatile SingularAttribute<Request, Date> dateRequested;
	public static volatile SingularAttribute<Request, Date> dateRequired;
	public static volatile SingularAttribute<Request, Long> siteId;
	public static volatile SingularAttribute<Request, String> productType;
	public static volatile SingularAttribute<Request, String> abo;
	public static volatile SingularAttribute<Request, String> rhd;
	public static volatile SingularAttribute<Request, Integer> quantity;
	public static volatile SingularAttribute<Request, String> status;
	public static volatile SingularAttribute<Request, String> comments;
	public static volatile SingularAttribute<Request, Boolean> isDeleted;
}
