package io.dev.sprout.usrmgr.persistence;

import java.util.Map;
import javax.persistence.EntityManager;

/**
 * @author DEV sprout
 */
public class PersistenceManagerImp implements IPersistenceManager {

  @Override
  public Object persist(Object object) {
    EntityManager manager = null;
    try {
      manager = Factory.getFactory().createEntityManager();
      manager.getTransaction().begin();
      manager.persist(object);
      manager.getTransaction().commit();
      return object;
    } catch (Exception exc) {
      return null;
    } finally {
      if ((manager != null) && manager.isOpen()) {
        manager.close();
      }
    }
  }

  @Override
  public Object merge(Object object) {
    EntityManager manager = null;
    try {
      manager = Factory.getFactory().createEntityManager();
      manager.getTransaction().begin();
      manager.merge(object);
      manager.getTransaction().commit();
      return object;
    } catch (Exception exc) {
      return null;
    } finally {
      if ((manager != null) && manager.isOpen()) {
        manager.close();
      }
    }
  }

  @Override
  public Object remove(Object object) {
    EntityManager manager = null;
    try {
      manager = Factory.getFactory().createEntityManager();
      manager.getTransaction().begin();
      manager.remove(manager.merge(object));
      manager.getTransaction().commit();
      return object;
    } catch (Exception exc) {
      return null;
    } finally {
      if ((manager != null) && (manager.isOpen())) {
        manager.close();
      }
    }
  }

  @Override
  public Object findByKey(Class<?> entityClass, Object key, Map<String, Object> properties) {
    Object result = null;
    EntityManager manager = null;
    try {
      manager = Factory.getFactory().createEntityManager();
      result = manager.find(entityClass, key);
      return result;
    } catch (Exception exc) {
      return null;
    } finally {
      if ((manager != null) && manager.isOpen()) {
        manager.close();
      }
    }
  }
}
