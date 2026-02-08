package io.dev.sprout.usrmgr.controller;

import io.dev.sprout.usrmgr.model.Menu;
import io.dev.sprout.usrmgr.service.IMenuService;
import io.dev.sprout.usrmgr.service.MenuServiceImp;
import java.util.Map;

/**
 * @author DEV sprout
 */
public class MenuController {

  private IMenuService service = null;

  public MenuController() {
    this.service = new MenuServiceImp();
  }

  private boolean controlNewData(Map<String, String> data) {
    boolean control = false;
    boolean controlName = (data.containsKey("name") && (data.get("name").trim().length() > 0)) ? (true) : (false);
    boolean controlGroupRolId = (data.containsKey("groupRolId") && (Short.parseShort(data.get("groupRolId")) > 0)) ? (true) : (false);
    control = controlName && controlGroupRolId;
    return control;
  }

  private boolean controlUpdateData(Map<String, String> data) {
    boolean control = false;
    boolean controlData = this.controlNewData(data);
    boolean controlId = (data.containsKey("id") && (Short.parseShort(data.get("id")) > 0)) ? (true) : (false);
    boolean controlFlagState = (data.containsKey("flagState")) ? (true) : (false);
    boolean controlFlagVisible =  (data.containsKey("flagVisible")) ? (true) : (false);
    control = controlData && controlId && controlFlagState && controlFlagVisible;
    return control;
  }

  private boolean controlDeleteData(Map<String, String> data) {
    boolean controlId = (data.containsKey("id") && (Short.parseShort(data.get("id")) > 0)) ? (true) : (false);
    return controlId;
  }

  public Menu save(Map<String, String> data) {
    boolean control = this.controlNewData(data);
    Menu menu = new Menu();
    if (control) {
      menu = this.service.save(data);
    }
    return menu;
  }

  public Menu update(Map<String, String> data) {
    boolean control = this.controlUpdateData(data);
    Menu menu = new Menu();
    if (control) {
      menu = this.service.update(data);
    }
    return menu;
  }

  public Menu delete(Map<String, String> data) {
    boolean control = this.controlDeleteData(data);
    Menu result = new Menu();
    if (control) {
      result = this.service.delete(data);
    }
    return result;
  }
}
