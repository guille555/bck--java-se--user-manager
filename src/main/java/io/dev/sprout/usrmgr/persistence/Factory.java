package io.dev.sprout.usrmgr.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author DEV sprout
 */
public class Factory {

  private static EntityManagerFactory factory = null; 

  private Factory() {}

  public static EntityManagerFactory getFactory() {
    if (Factory.factory == null) {
      Factory.factory = Persistence.createEntityManagerFactory("ManagerPU");
    }
    return Factory.factory;
  }

  public static void closeFactory() {
    if ((Factory.factory != null) && Factory.factory.isOpen()) {
      Factory.factory.close();
      Factory.factory = null;
    }
  }
}
