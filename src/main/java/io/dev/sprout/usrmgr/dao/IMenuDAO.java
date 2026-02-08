package io.dev.sprout.usrmgr.dao;

import io.dev.sprout.usrmgr.model.Menu;
import java.util.List;

/**
 * @author DEV sprout
 */
public interface IMenuDAO extends IBasicDAO<Menu, Short> {

  public abstract List<Menu> findAll();
}
