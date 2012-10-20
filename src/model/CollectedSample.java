package model;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import model.donor.Donor;
import model.modificationtracker.RowModificationTracker;
import model.user.User;

@Entity
public class CollectedSample {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable=false)
  private Long id;

  @Column(unique=true, length=30, nullable=false)
  private String collectionNumber;

  @ManyToOne(optional=false)
  private Donor donor;

  @OneToMany(mappedBy="collectedSample")
  private List<TestResult> testResults;

  @ManyToOne
  private Location center;

  @ManyToOne
  private Location site;

  @Temporal(TemporalType.TIMESTAMP)
  private Date collectedOn;

  @Enumerated(EnumType.STRING)
  private DonorType donorType;

  @Column(length=50)
  private String sampleNumber;

  @Column(length=50)
  private String shippingNumber;

  @OneToMany(mappedBy="collectedSample")
  private List<Product> products;

  @Valid
  private RowModificationTracker modificationTracker;
  
  @Lob
  private String notes;

  private Boolean isDeleted;

  public CollectedSample() {
  }

  public Long getId() {
    return id;
  }

  public String getCollectionNumber() {
    return collectionNumber;
  }

  public Donor getDonor() {
    return donor;
  }

  public List<TestResult> getTestResults() {
    return testResults;
  }

  public Location getCenter() {
    return center;
  }

  public Location getSite() {
    return site;
  }

  public Date getCollectedOn() {
    return collectedOn;
  }

  public DonorType getDonorType() {
    return donorType;
  }

  public String getSampleNumber() {
    return sampleNumber;
  }

  public String getShippingNumber() {
    return shippingNumber;
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

  public void setCollectionNumber(String collectionNumber) {
    this.collectionNumber = collectionNumber;
  }

  public void setDonor(Donor donor) {
    this.donor = donor;
  }

  public void setTestResults(List<TestResult> testResults) {
    this.testResults = testResults;
  }

  public void setCenter(Location center) {
    this.center = center;
  }

  public void setSite(Location site) {
    this.site = site;
  }

  public void setCollectedOn(Date collectedOn) {
    this.collectedOn = collectedOn;
  }

  public void setDonorType(DonorType donorType) {
    this.donorType = donorType;
  }

  public void setSampleNumber(String sampleNumber) {
    this.sampleNumber = sampleNumber;
  }

  public void setShippingNumber(String shippingNumber) {
    this.shippingNumber = shippingNumber;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public void copy(CollectedSample collection) {
    // TODO Auto-generated method stub
    
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
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

  public int hashCode() {
    return modificationTracker.hashCode();
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