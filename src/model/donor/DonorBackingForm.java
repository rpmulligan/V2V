package model.donor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import model.BloodAbo;
import model.BloodRhd;
import model.Gender;
import model.User;
import viewmodel.donor.DonorViewModel;

public class DonorBackingForm {

  @NotNull
  @Valid
  private Donor donor;
  private List<String> bloodTypes;

  public DonorBackingForm() {
    donor = new Donor();
  }

  public DonorBackingForm(Donor donor) {
    this.donor = donor;
  }

//  public void setBirthDate(String birthdDate) {
//    DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
//    try {
//      this.setBirthDate(formatter.parse(birthdDate));
//    } catch (ParseException e) {
//      e.printStackTrace();
//    }
//  }

  public void setBirthDate(Date birthDate) {
    donor.setBirthDate(birthDate);
  }

  public List<String> getBloodTypes() {
    return (bloodTypes == null) ? Arrays.asList(new String[0]) : bloodTypes;
  }

  public void setBloodTypes(List<String> bloodTypes) {
    this.bloodTypes = bloodTypes;
  }

  public DonorViewModel getDonorViewModel() {
    return new DonorViewModel(donor);
  }

  public Donor getDonor() {
    return donor;
  }

  public boolean equals(Object obj) {
    return donor.equals(obj);
  }

  public Long getId() {
    return donor.getId();
  }

  public String getDonorNumber() {
    return donor.getDonorNumber();
  }

  public String getFirstName() {
    return donor.getFirstName();
  }

  public String getMiddleName() {
    return donor.getMiddleName();
  }

  public String getLastName() {
    return donor.getLastName();
  }

  public Gender getGender() {
    return donor.getGender();
  }

  public BloodRhd getBloodAbo() {
    return donor.getBloodRhd();
  }

  public BloodRhd getBloodRhd() {
    return donor.getBloodRhd();
  }

  public Date getBirthDate() {
    return donor.getBirthDate();
  }

  public String getAddress() {
    return donor.getAddress();
  }

  public String getCity() {
    return donor.getCity();
  }

  public String getState() {
    return donor.getState();
  }

  public String getCountry() {
    return donor.getCountry();
  }

  public String getContactNumber() {
    return donor.getContactNumber();
  }

  public Date getLastUpdated() {
    return donor.getLastUpdated();
  }

  public Date getCreatedDate() {
    return donor.getCreatedDate();
  }

  public String getNotes() {
    return donor.getNotes();
  }

  public Boolean getIsDeleted() {
    return donor.getIsDeleted();
  }

  public User getCreatedBy() {
    return donor.getCreatedBy();
  }

  public User getLastUpdatedBy() {
    return donor.getLastUpdatedBy();
  }

  public int hashCode() {
    return donor.hashCode();
  }

  public void setId(Long id) {
    donor.setId(id);
  }

  public void setDonorNumber(String donorNumber) {
    donor.setDonorNumber(donorNumber);
  }

  public void setFirstName(String firstName) {
    donor.setFirstName(firstName);
  }

  public void setMiddleName(String middleName) {
    donor.setMiddleName(middleName);
  }

  public void setLastName(String lastName) {
    donor.setLastName(lastName);
  }

  public void setGender(String gender) {
    donor.setGender(Gender.valueOf(gender));
  }

  public void setGender(Gender gender) {
    donor.setGender(gender);
  }

  public void setBloodAbo(BloodAbo bloodAbo) {
    donor.setBloodAbo(bloodAbo);
  }

  public void setBloodRhd(BloodRhd bloodRhd) {
    donor.setBloodRhd(bloodRhd);
  }

  public void setAddress(String address) {
    donor.setAddress(address);
  }

  public void setCity(String city) {
    donor.setCity(city);
  }

  public void setState(String state) {
    donor.setState(state);
  }

  public void setCountry(String country) {
    donor.setCountry(country);
  }

  public void setContactNumber(String contactNumber) {
    donor.setContactNumber(contactNumber);
  }

  public void setLastUpdated(Date lastUpdated) {
    donor.setLastUpdated(lastUpdated);
  }

  public void setCreatedDate(Date createdDate) {
    donor.setCreatedDate(createdDate);
  }

  public void setNotes(String notes) {
    donor.setNotes(notes);
  }

  public void setIsDeleted(Boolean isDeleted) {
    donor.setIsDeleted(isDeleted);
  }

  public void setCreatedBy(User createdBy) {
    donor.setCreatedBy(createdBy);
  }

  public void setLastUpdatedBy(User lastUpdatedBy) {
    donor.setLastUpdatedBy(lastUpdatedBy);
  }

  public String toString() {
    return donor.toString();
  }
}
