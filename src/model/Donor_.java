package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-10-14T22:37:28.446-0400")
@StaticMetamodel(Donor.class)
public class Donor_ {
	public static volatile SingularAttribute<Donor, Long> donorId;
	public static volatile SingularAttribute<Donor, String> donorNumber;
	public static volatile SingularAttribute<Donor, String> firstName;
	public static volatile SingularAttribute<Donor, String> lastName;
	public static volatile SingularAttribute<Donor, String> gender;
	public static volatile SingularAttribute<Donor, String> bloodType;
	public static volatile SingularAttribute<Donor, Date> birthDate;
	public static volatile SingularAttribute<Donor, Integer> age;
	public static volatile SingularAttribute<Donor, String> address;
	public static volatile SingularAttribute<Donor, String> comments;
	public static volatile SingularAttribute<Donor, Boolean> isDeleted;
}
