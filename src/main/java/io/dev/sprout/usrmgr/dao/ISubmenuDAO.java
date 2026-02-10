package io.dev.sprout.usrmgr.dao;

import io.dev.sprout.usrmgr.model.Submenu;
import java.util.List;

/**
 * @author DEV sprout
 */
public interface ISubmenuDAO extends IBasicDAO<Submenu, Integer> {

  public abstract List<Submenu> findAll();
}
