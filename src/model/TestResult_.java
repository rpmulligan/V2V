package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-10-19T15:18:59.179-0400")
@StaticMetamodel(TestResult.class)
public class TestResult_ {
	public static volatile SingularAttribute<TestResult, Long> id;
	public static volatile SingularAttribute<TestResult, CollectedSample> collectedSample;
	public static volatile SingularAttribute<TestResult, Date> testedOn;
	public static volatile SingularAttribute<TestResult, String> name;
	public static volatile SingularAttribute<TestResult, String> result;
	public static volatile SingularAttribute<TestResult, Date> lastUpdated;
	public static volatile SingularAttribute<TestResult, Date> createdDate;
	public static volatile SingularAttribute<TestResult, User> createdBy;
	public static volatile SingularAttribute<TestResult, User> lastUpdatedBy;
	public static volatile SingularAttribute<TestResult, String> notes;
	public static volatile SingularAttribute<TestResult, Boolean> isDeleted;
}
