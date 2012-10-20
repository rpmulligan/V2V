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

import model.user.User;

@Entity
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String requestNumber;

  @Temporal(TemporalType.TIMESTAMP)
	private Date requestedOn;

  @Temporal(TemporalType.TIMESTAMP)
	private Date requiredOn;

  @ManyToOne
	private Location requestSite;

  @Enumerated(EnumType.STRING)
  private BloodAbo bloodAbo;

  @Enumerated(EnumType.STRING)
  private BloodRhd bloodRhd;

  @Enumerated(EnumType.STRING)
	private ProductType productType;

	private Integer quantity;

  @Enumerated(EnumType.STRING)
  private RequestStatus status;

  @OneToMany(mappedBy = "request")
  List<Issue> issuedProducts;
  
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdated;

  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;

  @ManyToOne
  private User createdBy;

  @ManyToOne
  private User lastUpdatedBy;

  @Lob
  private String notes;

  private Boolean isDeleted;

	public Request() {
	}

	public void copy(Request request) {
	}

  public Long getId() {
    return id;
  }

  public String getRequestNumber() {
    return requestNumber;
  }

  public Date getRequestedOn() {
    return requestedOn;
  }

  public Date getRequiredOn() {
    return requiredOn;
  }

  public Location getRequestSite() {
    return requestSite;
  }

  public BloodAbo getBloodAbo() {
    return bloodAbo;
  }

  public BloodRhd getBloodRhd() {
    return bloodRhd;
  }

  public ProductType getProductType() {
    return productType;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public RequestStatus getStatus() {
    return status;
  }

  public List<Issue> getIssuedProducts() {
    return issuedProducts;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public User getCreatedBy() {
    return createdBy;
  }

  public User getLastUpdatedBy() {
    return lastUpdatedBy;
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

  public void setRequestNumber(String requestNumber) {
    this.requestNumber = requestNumber;
  }

  public void setRequestedOn(Date dateRequested) {
    this.requestedOn = dateRequested;
  }

  public void setRequiredOn(Date dateRequired) {
    this.requiredOn = dateRequired;
  }

  public void setRequestSite(Location requestSite) {
    this.requestSite = requestSite;
  }

  public void setBloodAbo(BloodAbo bloodAbo) {
    this.bloodAbo = bloodAbo;
  }

  public void setBloodRhd(BloodRhd bloodRhd) {
    this.bloodRhd = bloodRhd;
  }

  public void setProductType(ProductType productType) {
    this.productType = productType;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public void setStatus(RequestStatus status) {
    this.status = status;
  }

  public void setIssuedProducts(List<Issue> issuedProducts) {
    this.issuedProducts = issuedProducts;
  }

  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public void setCreatedBy(User createdBy) {
    this.createdBy = createdBy;
  }

  public void setLastUpdatedBy(User lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }
}
