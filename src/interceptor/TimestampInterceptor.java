package interceptor;

import java.io.Serializable;
import java.util.Date;

import model.TimeStamped;

import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.annotations.Type;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimestampInterceptor extends HandlerInterceptorAdapter {

  public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, 
          Object[] previousState, String[] propertyNames, Type[] types) {
      if (entity instanceof TimeStamped) {
          int indexOf = ArrayUtils.indexOf(propertyNames, "lastUpdated");
          currentState[indexOf] = new Date();
          return true;
      }
      return false;
  }

  public boolean onSave(Object entity, Serializable id, Object[] state, 
          String[] propertyNames, Type[] types) {
          if (entity instanceof TimeStamped) {
              int indexOf = ArrayUtils.indexOf(propertyNames, "createdDate");
              state[indexOf] = new Date();
              return true;
          }
          return false;
  }
}
