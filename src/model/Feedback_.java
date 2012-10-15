package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-10-14T22:37:27.307-0400")
@StaticMetamodel(Feedback.class)
public class Feedback_ {
	public static volatile SingularAttribute<Feedback, Long> feedbackId;
	public static volatile SingularAttribute<Feedback, String> comment;
	public static volatile SingularAttribute<Feedback, Date> datetime;
}
