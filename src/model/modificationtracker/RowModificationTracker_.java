package model.modificationtracker;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.user.User;

@Generated(value="Dali", date="2012-10-20T16:04:58.014-0400")
@StaticMetamodel(RowModificationTracker.class)
public class RowModificationTracker_ {
	public static volatile SingularAttribute<RowModificationTracker, Date> lastUpdated;
	public static volatile SingularAttribute<RowModificationTracker, Date> createdDate;
	public static volatile SingularAttribute<RowModificationTracker, User> createdBy;
	public static volatile SingularAttribute<RowModificationTracker, User> lastUpdatedBy;
}
