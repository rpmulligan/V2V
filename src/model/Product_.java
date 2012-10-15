package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-10-14T22:37:27.323-0400")
@StaticMetamodel(Product.class)
public class Product_ {
	public static volatile SingularAttribute<Product, Long> productId;
	public static volatile SingularAttribute<Product, String> productNumber;
	public static volatile SingularAttribute<Product, String> collectionNumber;
	public static volatile SingularAttribute<Product, Date> dateCollected;
	public static volatile SingularAttribute<Product, String> type;
	public static volatile SingularAttribute<Product, String> abo;
	public static volatile SingularAttribute<Product, String> rhd;
	public static volatile SingularAttribute<Product, Boolean> isIssued;
	public static volatile SingularAttribute<Product, Boolean> isDeleted;
	public static volatile SingularAttribute<Product, String> comments;
}
