package io.dev.sprout.usrmgr.persistence;

/**
 * @author DEV sprout
 */
public interface IPersistenceManager {

  public abstract Object persist(Object object);

  public abstract Object merge(Object object);

  public abstract Object remove(Object object);

  public abstract Object findByKey(Class entityClass, Object key);
}
