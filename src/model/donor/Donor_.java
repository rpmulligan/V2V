package model.donor;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.BloodAbo;
import model.BloodRhd;
import model.CollectedSample;
import model.Gender;
import model.User;

@Generated(value="Dali", date="2012-10-20T03:27:58.511-0400")
@StaticMetamodel(Donor.class)
public class Donor_ {
	public static volatile SingularAttribute<Donor, Long> id;
	public static volatile SingularAttribute<Donor, String> donorNumber;
	public static volatile SingularAttribute<Donor, String> firstName;
	public static volatile SingularAttribute<Donor, String> middleName;
	public static volatile SingularAttribute<Donor, String> lastName;
	public static volatile SingularAttribute<Donor, Gender> gender;
	public static volatile SingularAttribute<Donor, BloodAbo> bloodAbo;
	public static volatile SingularAttribute<Donor, BloodRhd> bloodRhd;
	public static volatile SingularAttribute<Donor, Date> birthDate;
	public static volatile SingularAttribute<Donor, String> address;
	public static volatile SingularAttribute<Donor, String> city;
	public static volatile SingularAttribute<Donor, String> state;
	public static volatile SingularAttribute<Donor, String> country;
	public static volatile SingularAttribute<Donor, String> contactNumber;
	public static volatile SingularAttribute<Donor, Date> lastUpdated;
	public static volatile SingularAttribute<Donor, Date> createdDate;
	public static volatile SingularAttribute<Donor, User> createdBy;
	public static volatile SingularAttribute<Donor, User> lastUpdatedBy;
	public static volatile SingularAttribute<Donor, String> notes;
	public static volatile SingularAttribute<Donor, Boolean> isDeleted;
	public static volatile ListAttribute<Donor, CollectedSample> collectedSamples;
}
