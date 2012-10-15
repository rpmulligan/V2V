package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.Years;

@Entity
@Table(name="Donor")
public class Donor {

  @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long donorId;

  @Column(unique=true, length=30)
	private String donorNumber;

  @Column(length=30)
	private String firstName;

  @Column(length=30)
	private String lastName;

  @Column(length=30)
	private String gender;

  
	private String bloodType;
	private Date birthDate;
	private Integer age;
	private String address;
	private String comments;

	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean isDeleted;

	public Donor() {
	}

	public Donor(String donorNumber, String firstName, String lastName,
			String gender, String bloodType, Date birthDate, Integer age,
			String address, Boolean isDeleted, String comments) {
		this.donorNumber = donorNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.bloodType = bloodType;
		this.birthDate = birthDate;
		this.age = age;
		this.address = address;
		this.isDeleted = isDeleted;
		this.comments = comments;
	}

	public void copy(Donor otherDonor) {
		this.donorNumber = otherDonor.donorNumber;
		this.firstName = otherDonor.firstName;
		this.lastName = otherDonor.lastName;
		this.gender = otherDonor.gender;
		this.bloodType = otherDonor.bloodType;
		this.birthDate = otherDonor.birthDate;
		this.age = otherDonor.age;
		this.address = otherDonor.address;
		this.comments = otherDonor.comments;
		this.isDeleted = otherDonor.isDeleted;
	}

	public String getAddress() {
		return address;
	}

	public Integer getAge() {
		if (birthDate != null) {
			DateMidnight birthDate = new DateMidnight(getBirthDate());
			DateTime now = new DateTime();
			return Years.yearsBetween(birthDate, now).getYears();
		}
		return null;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getBloodType() {
		return bloodType;
	}

	public String getComments() {
		return comments;
	}

	@Column
	public Long getDonorId() {
		return donorId;
	}

	@Column
	public String getDonorNumber() {
		return donorNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getGender() {
		return gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setDonorId(Long donorId) {
		this.donorId = donorId;
	}

	public void setDonorNumber(String donorNumber) {
		this.donorNumber = donorNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

  public Boolean getIsDeleted() {
    return this.isDeleted;
  }

  public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
