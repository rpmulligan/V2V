package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Donor {

  @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable=false)
	private Long id;

  @Column(unique=true, length=30, nullable=false)
	private String donorNumber;

  @Column(length=30, nullable=false)
	private String firstName;
  @Column(length=30)
  private String middleName;
  @Column(length=30)
	private String lastName;

  @Enumerated(EnumType.STRING)
	private Gender gender;
  
  @Enumerated(EnumType.STRING)
	private BloodAbo bloodAbo;

  @Enumerated(EnumType.STRING)
  private BloodRhd bloodRhd;

  @Temporal(TemporalType.DATE)
	private Date birthDate;

  @Column(length=255)
	private String address;
  @Column(length=50)
	private String city;
  @Column(length=50)
  private String state;
  @Column(length=50)
  private String country;

  @Column(length=50)
  private String contactNumber;

  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdated;

  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;

  @Lob
	private String notes;

	private Boolean isDeleted;

  @ManyToOne
  private User createdBy;

  @ManyToOne
  private User lastUpdatedBy;

	public Donor() {
	}

  public Long getId() {
    return id;
  }

  public String getDonorNumber() {
    return donorNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public Gender getGender() {
    return gender;
  }

  public BloodAbo getBloodAbo() {
    return bloodAbo;
  }

  public BloodRhd getBloodRhd() {
    return bloodRhd;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public String getAddress() {
    return address;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getCountry() {
    return country;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public String getNotes() {
    return notes;
  }

  public Boolean getIsDeleted() {
    return isDeleted;
  }

  public User getCreatedBy() {
    return createdBy;
  }

  public User getLastUpdatedBy() {
    return lastUpdatedBy;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setDonorNumber(String donorNumber) {
    this.donorNumber = donorNumber;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public void setBloodAbo(BloodAbo bloodAbo) {
    this.bloodAbo = bloodAbo;
  }

  public void setBloodRhd(BloodRhd bloodRhd) {
    this.bloodRhd = bloodRhd;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public void setCreatedBy(User createdBy) {
    this.createdBy = createdBy;
  }

  public void setLastUpdatedBy(User lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
  }

  public void copy(Donor donor) {
    assert (donor.getId().equals(this.getId()));
    setDonorNumber(donor.getDonorNumber());
    setFirstName(donor.getFirstName());
    setMiddleName(donor.getMiddleName());
    setLastName(donor.getLastName());
    setAddress(donor.getAddress());
    setBirthDate(donor.getBirthDate());
    setCity(donor.getCity());
    setState(donor.getState());
    setCountry(donor.getCountry());
    setBloodAbo(donor.getBloodAbo());
    setBloodRhd(donor.getBloodRhd());
    setContactNumber(donor.getContactNumber());
    setNotes(donor.getNotes());
    setGender(donor.getGender());
  }

}
