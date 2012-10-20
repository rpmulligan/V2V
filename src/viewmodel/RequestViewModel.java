package viewmodel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.BloodAbo;
import model.BloodRhd;
import model.Issue;
import model.Location;
import model.ProductType;
import model.Request;
import model.user.User;

public class RequestViewModel {
	private Request request;
	private List<Location> sites;

	public RequestViewModel(Request request, List<Location> sites) {
		this.request = request;
		this.sites = sites;
	}

	public RequestViewModel(Request request) {
	  this.request = request;
  }

	public String getRequestNumber() {
		return request.getRequestNumber();
	}

	public String getRequestedOn() {
		Date dateRequested = request.getRequestedOn();
		if (dateRequested != null) {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			return formatter.format(dateRequested);
		}
		return "";
	}

	public String getDateRequired() {
		Date dateRequired = request.getRequiredOn();
		if (dateRequired != null) {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			return formatter.format(dateRequired);
		}
		return "";
	}

	private String getStringValue(Long value) {
		return value == null ? "" : value.toString();
	}

  public List<Location> getSites() {
    return sites;
  }

  public void setSites(List<Location> sites) {
    this.sites = sites;
  }

  public void copy(Request request) {
    request.copy(request);
  }

  public boolean equals(Object obj) {
    return request.equals(obj);
  }

  public Long getId() {
    return request.getId();
  }

  public Date getRequiredOn() {
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
}
