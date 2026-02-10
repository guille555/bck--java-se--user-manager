package io.dev.sprout.usrmgr.dao;

import io.dev.sprout.usrmgr.model.GroupRol;
import io.dev.sprout.usrmgr.persistence.Factory;
import io.dev.sprout.usrmgr.persistence.IPersistenceManager;
import io.dev.sprout.usrmgr.persistence.PersistenceManagerImp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author DEV sprout
 */
public class GroupRolDAOImp implements IGroupRolDAO {

  IPersistenceManager persistenceManager = null;

  public GroupRolDAOImp() {
    this.persistenceManager = new PersistenceManagerImp();
  }

  private EntityGraph<GroupRol> createNormalGraph() {
    EntityManager manager = null;
    EntityGraph<GroupRol> graph = null;
    try {
      manager = Factory.getFactory().createEntityManager();
      graph = manager.createEntityGraph(GroupRol.class);
      graph.addAttributeNodes("listMenus");
      return graph;
    } catch (Exception exc) {
      return null;
    } finally {
      if ((manager != null) && (manager.isOpen())) {
        manager.close();
      }
    }
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
    EntityGraph<GroupRol> graph = this.createNormalGraph();
    Map<String, Object> properties = new HashMap<String, Object>();
    properties.put("jakarta.persistence.fetchgraph", graph);
    Object temporal = this.persistenceManager.findByKey(entityClass, id, properties);
    GroupRol result = GroupRol.class.cast(temporal);
    return result;
  }

  @Override
  public List<GroupRol> findAll() {
    EntityManager manager = null;
    CriteriaBuilder builder = null;
    CriteriaQuery<GroupRol> query = null;
    TypedQuery<GroupRol> typedQuery = null;
    EntityGraph<GroupRol> graph = null;
    Root<GroupRol> root = null;
    List<GroupRol> list = null;
    try {
      graph = this.createNormalGraph();
      manager = Factory.getFactory().createEntityManager();
      builder = manager.getCriteriaBuilder();
      query = builder.createQuery(GroupRol.class);
      // root = query.from(GroupRol.class);
      typedQuery = manager.createQuery(query);
      typedQuery.setHint("jakarta.persistence.fetchgraph", graph);
      list = typedQuery.getResultList();
      return list;
    } catch (Exception exc) {
      return null;
    } finally {
      if ((manager != null) && (manager.isOpen())) {
        manager.close();
      }
    }
  }
}
