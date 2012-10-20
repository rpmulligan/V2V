package model.donor;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import model.BloodAbo;
import model.BloodRhd;
import model.CollectedSample;
import model.Gender;
import model.address.ContactInformation;
import model.modificationtracker.ModificationTracker;
import model.modificationtracker.RowModificationTracker;
import model.user.User;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Donor implements ModificationTracker {

  @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable=false, updatable=false, insertable=false)
	private Long id;

  @NotBlank
  @Column(unique=true, length=30, nullable=false)
  private String donorNumber;

  @NotBlank
  @Column(length=30, nullable=false)
  @Length(min=1, max=30)
	private String firstName;

  @Length(max=30)
  @Column(length=30)
  private String middleName;

  @Length(max=30)
  @Column(length=30)
	private String lastName;

  @Length(max=30)
  @Enumerated(EnumType.STRING)
	private Gender gender;

  @Length(max=30)
  @Enumerated(EnumType.STRING)
	private BloodAbo bloodAbo;

  @Length(max=30)
  @Enumerated(EnumType.STRING)
  private BloodRhd bloodRhd;

  @DateTimeFormat(pattern="mm/dd/yyyy")
  @Temporal(TemporalType.DATE)
	private Date birthDate;

  @Valid
  private ContactInformation contactInformation;
  
  @Lob
	private String notes;

  @Valid
  private RowModificationTracker modificationTracker;
  
	private Boolean isDeleted;

  @OneToMany(mappedBy="donor")
  private List<CollectedSample> collectedSamples;
  
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

  public String getNotes() {
    return notes;
  }

  public Boolean getIsDeleted() {
    return isDeleted;
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

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public void copy(Donor donor) {
    assert (donor.getId().equals(this.getId()));
    setDonorNumber(donor.getDonorNumber());
    setFirstName(donor.getFirstName());
    setMiddleName(donor.getMiddleName());
    setLastName(donor.getLastName());
    contactInformation.copy(donor.getContactInformation());
    setBirthDate(donor.getBirthDate());
    setBloodAbo(donor.getBloodAbo());
    setBloodRhd(donor.getBloodRhd());
    setNotes(donor.getNotes());
    setGender(donor.getGender());
  }

  public List<CollectedSample> getCollectedSamples() {
    return collectedSamples;
  }

  public void setCollectedSamples(List<CollectedSample> collectedSamples) {
    this.collectedSamples = collectedSamples;
  }

  public ContactInformation getContactInformation() {
    return contactInformation;
  }

  public void setContactInformation(ContactInformation contactInformation) {
    this.contactInformation = contactInformation;
  }

  public String getAddress() {
    return contactInformation.getAddress();
  }

  public String getCity() {
    return contactInformation.getCity();
  }

  public String getState() {
    return contactInformation.getState();
  }

  public String getCountry() {
    return contactInformation.getCountry();
  }

  public String getZipcode() {
    return contactInformation.getZipcode();
  }

  public void setAddress(String address) {
    contactInformation.setAddress(address);
  }

  public void setCity(String city) {
    contactInformation.setCity(city);
  }

  public void setState(String state) {
    contactInformation.setState(state);
  }

  public void setCountry(String country) {
    contactInformation.setCountry(country);
  }

  public void setZipcode(String zipcode) {
    contactInformation.setZipcode(zipcode);
  }

  public String getPhoneNumber() {
    return contactInformation.getPhoneNumber();
  }

  public int hashCode() {
    return contactInformation.hashCode();
  }

  public void setPhoneNumber(String phoneNumber) {
    contactInformation.setPhoneNumber(phoneNumber);
  }

  public Date getLastUpdated() {
    return modificationTracker.getLastUpdated();
  }

  public Date getCreatedDate() {
    return modificationTracker.getCreatedDate();
  }

  public User getCreatedBy() {
    return modificationTracker.getCreatedBy();
  }

  public User getLastUpdatedBy() {
    return modificationTracker.getLastUpdatedBy();
  }

  public void setLastUpdated(Date lastUpdated) {
    modificationTracker.setLastUpdated(lastUpdated);
  }

  public void setCreatedDate(Date createdDate) {
    modificationTracker.setCreatedDate(createdDate);
  }

  public void setCreatedBy(User createdBy) {
    modificationTracker.setCreatedBy(createdBy);
  }

  public void setLastUpdatedBy(User lastUpdatedBy) {
    modificationTracker.setLastUpdatedBy(lastUpdatedBy);
  }
}
