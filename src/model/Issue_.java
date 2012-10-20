package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-10-19T15:18:59.150-0400")
@StaticMetamodel(Issue.class)
public class Issue_ {
	public static volatile SingularAttribute<Issue, Long> id;
	public static volatile SingularAttribute<Issue, Request> request;
	public static volatile SingularAttribute<Issue, Product> product;
	public static volatile SingularAttribute<Issue, Date> issuedOn;
	public static volatile SingularAttribute<Issue, Integer> quantityIssued;
	public static volatile SingularAttribute<Issue, Date> lastUpdated;
	public static volatile SingularAttribute<Issue, Date> createdDate;
	public static volatile SingularAttribute<Issue, User> createdBy;
	public static volatile SingularAttribute<Issue, User> lastUpdatedBy;
	public static volatile SingularAttribute<Issue, String> notes;
	public static volatile SingularAttribute<Issue, Boolean> isDeleted;
}
