package io.dev.sprout.usrmgr.service;

import java.util.Map;

/**
 * @author DEV sprout
 */
public interface IBasicService<T, K> {

  public abstract T save(Map<String, String> data);

  public abstract T update(Map<String, String> data);

  public abstract T delete(Map<String, String> data);

  public abstract T findById(K id);
}
