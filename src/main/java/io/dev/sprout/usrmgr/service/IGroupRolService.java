package io.dev.sprout.usrmgr.service;

import io.dev.sprout.usrmgr.model.GroupRol;
import java.util.List;

/**
 * @author DEV sprout
 */
public interface IGroupRolService extends IBasicService<GroupRol, Byte> {

  public abstract List<GroupRol> findAll();
}
