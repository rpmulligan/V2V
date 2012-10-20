package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.user.User;

@Entity
public class Issue {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Request request;

	@ManyToOne
	private Product product;

  @Temporal(TemporalType.TIMESTAMP)
	private Date issuedOn;

  private Integer quantityIssued;
  
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


	public Issue() {
	}

	public void copy(Issue issue) {
	}

  public Long getId() {
    return id;
  }

  public Request getRequest() {
    return request;
  }

  public Product getProduct() {
    return product;
  }

  public Date getIssuedOn() {
    return issuedOn;
  }

  public Integer getQuantityIssued() {
    return quantityIssued;
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

  public void setRequest(Request request) {
    this.request = request;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public void setIssuedOn(Date issuedOn) {
    this.issuedOn = issuedOn;
  }

  public void setQuantityIssued(Integer quantityIssued) {
    this.quantityIssued = quantityIssued;
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
