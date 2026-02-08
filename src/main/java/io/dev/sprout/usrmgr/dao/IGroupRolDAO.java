package io.dev.sprout.usrmgr.dao;

import io.dev.sprout.usrmgr.model.GroupRol;
import java.util.List;

/**
 * @author DEV sprout
 */
public interface IGroupRolDAO extends IBasicDAO<GroupRol, Byte> {

  public abstract List<GroupRol> findAll();
}
