package model.user;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.modificationtracker.RowModificationTracker;

@Generated(value="Dali", date="2012-10-20T15:54:30.880-0400")
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
	public static volatile SingularAttribute<User, Boolean> isAdmin;
	public static volatile SingularAttribute<User, Boolean> isDeleted;
	public static volatile SingularAttribute<User, String> notes;
	public static volatile SingularAttribute<User, RowModificationTracker> modificationTracker;
	public static volatile SingularAttribute<User, Date> lastLogin;
}
