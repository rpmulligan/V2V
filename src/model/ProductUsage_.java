package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-10-14T22:37:27.324-0400")
@StaticMetamodel(ProductUsage.class)
public class ProductUsage_ {
	public static volatile SingularAttribute<ProductUsage, Long> usageId;
	public static volatile SingularAttribute<ProductUsage, String> productNumber;
	public static volatile SingularAttribute<ProductUsage, Date> dateUsed;
	public static volatile SingularAttribute<ProductUsage, String> hospital;
	public static volatile SingularAttribute<ProductUsage, String> ward;
	public static volatile SingularAttribute<ProductUsage, String> useIndication;
	public static volatile SingularAttribute<ProductUsage, String> comments;
	public static volatile SingularAttribute<ProductUsage, Boolean> isDeleted;
}
