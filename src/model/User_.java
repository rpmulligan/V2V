package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-10-14T23:23:43.868-0400")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Long> userId;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> type;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, String> contactNumber;
	public static volatile SingularAttribute<User, String> emailId;
	public static volatile SingularAttribute<User, String> comments;
	public static volatile SingularAttribute<User, Boolean> isDeleted;
}
