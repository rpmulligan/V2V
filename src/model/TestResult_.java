package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-10-14T21:53:30.443-0400")
@StaticMetamodel(TestResult.class)
public class TestResult_ {
	public static volatile SingularAttribute<TestResult, Long> testResultId;
	public static volatile SingularAttribute<TestResult, String> collectionNumber;
	public static volatile SingularAttribute<TestResult, Date> dateCollected;
	public static volatile SingularAttribute<TestResult, Date> dateTested;
	public static volatile SingularAttribute<TestResult, String> hiv;
	public static volatile SingularAttribute<TestResult, String> hbv;
	public static volatile SingularAttribute<TestResult, String> hcv;
	public static volatile SingularAttribute<TestResult, String> syphilis;
	public static volatile SingularAttribute<TestResult, String> abo;
	public static volatile SingularAttribute<TestResult, String> rhd;
	public static volatile SingularAttribute<TestResult, String> comments;
	public static volatile SingularAttribute<TestResult, Boolean> isDeleted;
}
