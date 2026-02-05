package io.dev.sprout.usrmgr.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author DEV sprout
 */
public class PersistenceManagerImp implements IPersistenceManager {

  @Override
  public Object persist(Object object) {
    EntityManager manager = null;
    EntityManagerFactory factory = null;
    try {
      factory = Factory.getFactory();
      manager = factory.createEntityManager();
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
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public Object remove(Object object) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public Object findByKey(Class entityClass, Object key) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }
}
