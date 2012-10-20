package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.user.User;

public class RequestBackingForm {

  private Request request;
  private List<String> sites;
  private List<String> productTypes;
  private List<String> statuses;
  private String dateRequestedFrom;
  private String dateRequestedTo;
  private String dateRequiredFrom;
  private String dateRequiredTo;

  public RequestBackingForm() {
    request = new Request();
  }

  public RequestBackingForm(Request request) {
    this.request = request;
  }

  public void copy(Request request) {
    request.copy(request);
  }

  public boolean equals(Object obj) {
    return request.equals(obj);
  }

  public void setRequestNumber(String requestNumber) {
    request.setRequestNumber(requestNumber);
  }

  public void setDateRequested(String dateRequested) {
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    try {
      request.setRequestedOn(dateFormat.parse(dateRequested));
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void setDateRequired(String dateRequired) {
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    try {
      request.setRequiredOn(dateFormat.parse(dateRequired));
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  public String getRequestedOn() {
    Date dateRequested = request.getRequestedOn();
    if (dateRequested == null)
      return null;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    return dateFormat.format(dateRequested);
  }

  public String getRequiredOn() {
    Date dateRequired = request.getRequiredOn();
    if (dateRequired == null)
      return null;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    return dateFormat.format(dateRequired);
  }

  public String getDateRequestedFrom() {
    return dateRequestedFrom;
  }

  public void setDateRequestedFrom(String dateRequestedFrom) {
    this.dateRequestedFrom = dateRequestedFrom;
  }

  public String getDateRequestedTo() {
    return dateRequestedTo;
  }

  public void setDateRequestedTo(String dateRequestedTo) {
    this.dateRequestedTo = dateRequestedTo;
  }

  public String getDateRequiredFrom() {
    return dateRequiredFrom;
  }

  public void setDateRequiredFrom(String dateRequiredFrom) {
    this.dateRequiredFrom = dateRequiredFrom;
  }

  public String getDateRequiredTo() {
    return dateRequiredTo;
  }

  public void setDateRequiredTo(String dateRequiredTo) {
    this.dateRequiredTo = dateRequiredTo;
  }

  public List<String> getSites() {
    return sites;
  }

  public void setSites(List<String> sites) {
    this.sites = sites;
  }

  public Request getRequest() {
    return request;
  }

  public void setRequest(Request request) {
    this.request = request;
  }

  public List<String> getProductTypes() {
    return productTypes;
  }

  public void setProductTypes(List<String> productTypes) {
    this.productTypes = productTypes;
  }

  public List<String> getStatuses() {
    return this.statuses;
  }

  public void setStatuses(List<String> statuses) {
    this.statuses = statuses;
  }

  public Long getId() {
    return request.getId();
  }

  public String getRequestNumber() {
    return request.getRequestNumber();
  }

  public Date getDateRequested() {
    return request.getRequestedOn();
  }

  public Date getDateRequired() {
    return request.getRequiredOn();
  }

  public Location getRequestSite() {
    return request.getRequestSite();
  }

  public BloodAbo getBloodAbo() {
    return request.getBloodAbo();
  }

  public BloodRhd getBloodRhd() {
    return request.getBloodRhd();
  }

  public ProductType getProductType() {
    return request.getProductType();
  }

  public Integer getQuantity() {
    return request.getQuantity();
  }

  public String getStatus() {
    return request.getStatus().name();
  }

  public List<Issue> getIssuedProducts() {
    return request.getIssuedProducts();
  }

  public Date getLastUpdated() {
    return request.getLastUpdated();
  }

  public Date getCreatedDate() {
    return request.getCreatedDate();
  }

  public User getCreatedBy() {
    return request.getCreatedBy();
  }

  public User getLastUpdatedBy() {
    return request.getLastUpdatedBy();
  }

  public String getNotes() {
    return request.getNotes();
  }

  public Boolean getIsDeleted() {
    return request.getIsDeleted();
  }

  public int hashCode() {
    return request.hashCode();
  }

  public void setId(Long id) {
    request.setId(id);
  }

  public void setRequestedOn(Date dateRequested) {
    request.setRequestedOn(dateRequested);
  }

  public void setRequiredOn(Date dateRequired) {
    request.setRequiredOn(dateRequired);
  }

  public void setRequestSite(Location requestSite) {
    request.setRequestSite(requestSite);
  }

  public void setBloodAbo(BloodAbo bloodAbo) {
    request.setBloodAbo(bloodAbo);
  }

  public void setBloodRhd(BloodRhd bloodRhd) {
    request.setBloodRhd(bloodRhd);
  }

  public void setProductType(ProductType productType) {
    request.setProductType(productType);
  }

  public void setQuantity(Integer quantity) {
    request.setQuantity(quantity);
  }

  public void setStatus(String status) {
    request.setStatus(RequestStatus.valueOf(status));
  }

  public void setIssuedProducts(List<Issue> issuedProducts) {
    request.setIssuedProducts(issuedProducts);
  }

  public void setLastUpdated(Date lastUpdated) {
    request.setLastUpdated(lastUpdated);
  }

  public void setCreatedDate(Date createdDate) {
    request.setCreatedDate(createdDate);
  }

  public void setCreatedBy(User createdBy) {
    request.setCreatedBy(createdBy);
  }

  public void setLastUpdatedBy(User lastUpdatedBy) {
    request.setLastUpdatedBy(lastUpdatedBy);
  }

  public void setNotes(String notes) {
    request.setNotes(notes);
  }

  public void setIsDeleted(Boolean isDeleted) {
    request.setIsDeleted(isDeleted);
  }

  public String toString() {
    return request.toString();
  }
}
