package viewmodel;

import java.util.Date;

import model.BloodAbo;
import model.BloodRhd;
import model.CollectedSample;
import model.Product;
import model.User;

public class ProductViewModel {

	private Product product;

	public ProductViewModel() {
	  product = new Product();
	}
	
	public ProductViewModel(Product product) {
		this.product = product;
	}

  public void copy(Product product) {
    product.copy(product);
  }

  public BloodAbo getBloodAbo() {
    return product.getBloodAbo();
  }

  public BloodRhd getBloodRhd() {
    return product.getBloodRhd();
  }

  public Long getId() {
    return product.getId();
  }

  public String getProductNumber() {
    return product.getProductNumber();
  }

  public CollectedSample getCollectedSample() {
    return product.getCollectedSample();
  }

  public String getProductType() {
    return product.getProductType();
  }

  public Date getExpiryDate() {
    return product.getExpiryDate();
  }

  public Date getLastUpdated() {
    return product.getLastUpdated();
  }

  public Date getCreatedDate() {
    return product.getCreatedDate();
  }

  public User getCreatedBy() {
    return product.getCreatedBy();
  }

  public User getLastUpdatedBy() {
    return product.getLastUpdatedBy();
  }

  public String getNotes() {
    return product.getNotes();
  }

  public Boolean getIsDeleted() {
    return product.getIsDeleted();
  }
}
