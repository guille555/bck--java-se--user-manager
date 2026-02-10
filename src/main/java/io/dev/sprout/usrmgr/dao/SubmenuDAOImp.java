package io.dev.sprout.usrmgr.dao;

import io.dev.sprout.usrmgr.model.Submenu;
import io.dev.sprout.usrmgr.persistence.IPersistenceManager;
import io.dev.sprout.usrmgr.persistence.PersistenceManagerImp;
import java.util.List;

/**
 * @author DEV sprout
 */
public class SubmenuDAOImp implements ISubmenuDAO {

  IPersistenceManager persistenceManager = null;

  public SubmenuDAOImp() {
    this.persistenceManager = new PersistenceManagerImp();
  }

  @Override
  public Submenu save(Submenu object) {
    Object temporal = this.persistenceManager.persist(object);
    Submenu result = Submenu.class.cast(temporal);
    return result;
  }

  @Override
  public Submenu update(Submenu object) {
    Object temporal = this.persistenceManager.merge(object);
    Submenu result = Submenu.class.cast(temporal);
    return result;
  }

  @Override
  public Submenu delete(Submenu object) {
    Object temporal = this.persistenceManager.remove(object);
    Submenu result = Submenu.class.cast(temporal);
    return result;
  }

  @Override
  public Submenu findById(Integer id) {
    return null;
  }

  @Override
  public List<Submenu> findAll() {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }
}
