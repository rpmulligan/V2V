package interceptor;

import java.io.Serializable;
import java.util.Date;

import model.modificationtracker.RowModificationTracker;

import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.EmptyInterceptor;
import org.hibernate.annotations.Type;

public class ModificationInterceptor extends EmptyInterceptor {

  /**
   * Avoid compiler warning. We need a version ID for a Serializable type.
   */
  private static final long serialVersionUID = 1L;

  public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, 
          Object[] previousState, String[] propertyNames, Type[] types) {
      if (entity instanceof RowModificationTracker) {
          int indexOf = ArrayUtils.indexOf(propertyNames, "lastUpdated");
          currentState[indexOf] = new Date();
          return true;
      }
      return false;
  }

  public boolean onSave(Object entity, Serializable id, Object[] state, 
          String[] propertyNames, Type[] types) {
          if (entity instanceof RowModificationTracker) {
              int indexOf = ArrayUtils.indexOf(propertyNames, "createdDate");
              state[indexOf] = new Date();
              return true;
          }
          return false;
  }
}
