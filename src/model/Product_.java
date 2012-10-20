package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-10-19T15:18:59.159-0400")
@StaticMetamodel(Product.class)
public class Product_ {
	public static volatile SingularAttribute<Product, Long> id;
	public static volatile SingularAttribute<Product, String> productNumber;
	public static volatile SingularAttribute<Product, CollectedSample> collectedSample;
	public static volatile SingularAttribute<Product, ProductType> productType;
	public static volatile SingularAttribute<Product, Date> expiryDate;
	public static volatile SingularAttribute<Product, Date> lastUpdated;
	public static volatile SingularAttribute<Product, Date> createdDate;
	public static volatile SingularAttribute<Product, User> createdBy;
	public static volatile SingularAttribute<Product, User> lastUpdatedBy;
	public static volatile SingularAttribute<Product, String> notes;
	public static volatile SingularAttribute<Product, Boolean> isDeleted;
}
