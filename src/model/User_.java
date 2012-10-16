package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-10-15T23:16:55.707-0400")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> middleName;
	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, String> emailId;
	public static volatile SingularAttribute<User, Boolean> isStaff;
	public static volatile SingularAttribute<User, Boolean> isActive;
	public static volatile SingularAttribute<User, Date> lastUpdated;
	public static volatile SingularAttribute<User, Date> createdDate;
	public static volatile SingularAttribute<User, String> comments;
	public static volatile SingularAttribute<User, Boolean> isDeleted;
	public static volatile SingularAttribute<User, Boolean> isAdmin;
	public static volatile SingularAttribute<User, Date> lastLogin;
}
