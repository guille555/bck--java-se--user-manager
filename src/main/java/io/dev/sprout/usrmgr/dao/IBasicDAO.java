package io.dev.sprout.usrmgr.dao;

/**
 * @author DEV sprout
 */
public interface IBasicDAO<T, K> {

  public abstract T save(T object);

  public abstract T update(T object);

  public abstract T delete(T object);

  public abstract T findById(K id);
}
