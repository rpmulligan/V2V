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
import model.address.ContactInformation;
import model.modificationtracker.RowModificationTracker;

@Generated(value="Dali", date="2012-10-20T15:47:46.674-0400")
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
	public static volatile SingularAttribute<Donor, String> notes;
	public static volatile SingularAttribute<Donor, Boolean> isDeleted;
	public static volatile ListAttribute<Donor, CollectedSample> collectedSamples;
	public static volatile SingularAttribute<Donor, ContactInformation> contactInformation;
	public static volatile SingularAttribute<Donor, RowModificationTracker> modificationTracker;
}
