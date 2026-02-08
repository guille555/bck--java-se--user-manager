package io.dev.sprout.usrmgr.service;

import io.dev.sprout.usrmgr.dao.IMenuDAO;
import io.dev.sprout.usrmgr.dao.MenuDAOImp;
import io.dev.sprout.usrmgr.model.GroupRol;
import io.dev.sprout.usrmgr.model.Menu;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.Map;

/**
 * @author DEV sprout
 */
public class MenuServiceImp implements IMenuService {

  private IMenuDAO dao = null;

  public MenuServiceImp() {
    this.dao = new MenuDAOImp();
  }

  private GroupRol findGroupRolById(Byte id) {
    IGroupRolService service = new GroupRolServiceImp();
    GroupRol groupRol = service.findById(id);
    if (groupRol.getId() == 0) {
      throw new EmptyStackException();
    }
    return groupRol;
  }

  private Menu createNewMenu(Map<String, String> data) {
    String name = data.get("name").toUpperCase();
    Date createDate = new Date();
    Menu menu = new Menu();
    menu.setName(name);
    menu.setFlagState(true);
    menu.setFlagVisible(true);
    menu.setCreateDate(createDate);
    return menu;
  }

  private Menu updateMenu(Map<String, String> data) {
    boolean flagState = Boolean.parseBoolean(data.get("flagState"));
    boolean flagVisible = Boolean.parseBoolean(data.get("flagVisible"));
    long createDateTime = Long.parseLong(data.get("createDate"));
    Short id = Short.valueOf(data.get("id"));
    String name = data.get("name").toUpperCase();
    Date lastUpdate = new Date();
    Date createDate = new Date();
    Menu menu = new Menu();
    createDate.setTime(createDateTime);
    menu.setId(id);
    menu.setName(name);
    menu.setFlagState(flagState);
    menu.setFlagVisible(flagVisible);
    menu.setCreateDate(createDate);
    menu.setLastUpdate(lastUpdate);
    return menu;
  }

  private Menu prepareNewMenu(Map<String, String> data) {
    Byte GroupRolId = Byte.valueOf(data.get("groupRolId"));
    GroupRol groupRol = this.findGroupRolById(GroupRolId);
    Menu newMenu = this.createNewMenu(data);
    newMenu.setGroupRol(groupRol);
    return newMenu;
  }

  private Menu prepareUpdatedMenu(Map<String, String> data) {
    Byte GroupRolId = Byte.valueOf(data.get("groupRolId"));
    GroupRol groupRol = this.findGroupRolById(GroupRolId);
    Menu updatedMenu = this.updateMenu(data);
    updatedMenu.setGroupRol(groupRol);
    return updatedMenu;
  }

  @Override
  public Menu save(Map<String, String> data) {
    Menu menu = null;
    Menu result = null;
    try {
      menu = this.prepareNewMenu(data);
      result = this.dao.save(menu);
      return result;
    } catch (Exception exc) {
      result = new Menu();
      return result;
    }
  }

  @Override
  public Menu update(Map<String, String> data) {
    Short id = null;
    Menu menu = null;
    Menu result = null;
    try {
      result = new Menu();
      id = Short.valueOf(data.get("id"));
      menu = this.findById(id);
      if (menu.getId() > 0) {
        data.put("createDate", String.valueOf(menu.getCreateDate().getTime()));
        menu = this.prepareUpdatedMenu(data);
        result = this.dao.update(menu);
      }
      return result;
    } catch (Exception exc) {
      result = new Menu();
      return result;
    }
  }

  @Override
  public Menu delete(Map<String, String> data) {
    Short id = null;
    Menu menu = null;
    Menu result = null;
    try {
      result = new Menu();
      id = Short.valueOf(data.get("id"));
      menu = this.findById(id);
      if (menu.getId() > 0) {
        result = this.dao.delete(menu);
      }
      return result;
    } catch (Exception exc) {
      result = new Menu();
      return result;
    }
  }

  @Override
  public Menu findById(Short id) {
    Menu menu = null;
    try {
      menu = this.dao.findById(id);
      return menu;
    } catch (Exception exc) {
      menu = new Menu();
      return menu;
    }
  }
}
