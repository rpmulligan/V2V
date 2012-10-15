package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-10-14T22:37:27.319-0400")
@StaticMetamodel(Issue.class)
public class Issue_ {
	public static volatile SingularAttribute<Issue, Long> issueId;
	public static volatile SingularAttribute<Issue, String> productNumber;
	public static volatile SingularAttribute<Issue, Date> dateIssued;
	public static volatile SingularAttribute<Issue, Long> siteId;
	public static volatile SingularAttribute<Issue, String> comments;
	public static volatile SingularAttribute<Issue, Boolean> isDeleted;
}
