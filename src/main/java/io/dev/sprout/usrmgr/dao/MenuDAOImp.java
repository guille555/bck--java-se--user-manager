package io.dev.sprout.usrmgr.dao;

import io.dev.sprout.usrmgr.model.Menu;
import io.dev.sprout.usrmgr.persistence.IPersistenceManager;
import io.dev.sprout.usrmgr.persistence.PersistenceManagerImp;
import java.util.List;

/**
 * @author DEV sprout
 */
public class MenuDAOImp implements IMenuDAO {

  private IPersistenceManager persistenceManager = null;

  public MenuDAOImp() {
    this.persistenceManager = new PersistenceManagerImp();
  }

  @Override
  public Menu save(Menu object) {
    Object temporal = this.persistenceManager.persist(object);
    Menu menu = Menu.class.cast(temporal);
    return menu;
  }

  @Override
  public Menu update(Menu object) {
    Object temporal = this.persistenceManager.merge(object);
    Menu menu = Menu.class.cast(temporal);
    return menu;
  }

  @Override
  public Menu delete(Menu object) {
    Object temporal = this.persistenceManager.remove(object);
    Menu menu = Menu.class.cast(temporal);
    return menu;
  }

  @Override
  public Menu findById(Short id) {
    Class<Menu> entityClass = Menu.class;
    Object temporal = this.persistenceManager.findByKey(entityClass, id, null);
    Menu menu = Menu.class.cast(temporal);
    return menu;
  }

  @Override
  public List<Menu> findAll() {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }
}
