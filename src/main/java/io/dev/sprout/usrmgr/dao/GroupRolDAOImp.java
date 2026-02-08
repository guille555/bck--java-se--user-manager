package io.dev.sprout.usrmgr.dao;

import io.dev.sprout.usrmgr.model.GroupRol;
import io.dev.sprout.usrmgr.persistence.IPersistenceManager;
import io.dev.sprout.usrmgr.persistence.PersistenceManagerImp;
import java.util.List;

/**
 * @author DEV sprout
 */
public class GroupRolDAOImp implements IGroupRolDAO {

  IPersistenceManager persistenceManager = null;

  public GroupRolDAOImp() {
    this.persistenceManager = new PersistenceManagerImp();
  }

  @Override
  public GroupRol save(GroupRol object) {
    Object temporal = this.persistenceManager.persist(object);
    GroupRol result = GroupRol.class.cast(temporal);
    return result;
  }

  @Override
  public GroupRol update(GroupRol object) {
    Object temporal = this.persistenceManager.merge(object);
    GroupRol result = GroupRol.class.cast(temporal);
    return result;
  }

  @Override
  public GroupRol delete(GroupRol object) {
    Object temporal = this.persistenceManager.remove(object);
    GroupRol result = GroupRol.class.cast(temporal);
    return result;
  }

  @Override
  public GroupRol findById(Byte id) {
    Class<GroupRol> entityClass = GroupRol.class;
    Object temporal = this.persistenceManager.findByKey(entityClass, id, null);
    GroupRol result = GroupRol.class.cast(temporal);
    return result;
  }

  @Override
  public List<GroupRol> findAll() {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }
}
