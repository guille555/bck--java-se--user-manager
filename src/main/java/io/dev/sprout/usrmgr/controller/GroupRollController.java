package io.dev.sprout.usrmgr.controller;

import io.dev.sprout.usrmgr.model.GroupRol;
import io.dev.sprout.usrmgr.service.GroupRolServiceImp;
import io.dev.sprout.usrmgr.service.IGroupRolService;
import java.util.Map;

/**
 * @author DEV sprout
 */
public class GroupRollController {

  private IGroupRolService service = null;

  public GroupRollController() {
    this.service = new GroupRolServiceImp();
  }

  private boolean controlNewData(Map<String, String> data) {
    boolean controlName = (data.containsKey("name") && (data.get("name").trim().length() > 0)) ? (true) : (false);
    return controlName;
  }

  private boolean controlUpdateData(Map<String, String> data) {
    boolean control = false;
    boolean controlData = this.controlNewData(data);
    boolean controlId = (data.containsKey("id") && (Byte.parseByte(data.get("id")) > 0)) ? (true) : (false);
    boolean controlFlagState = (data.containsKey("flagState")) ? (true) : (false);
    boolean controlFlagVisible = (data.containsKey("flagVisible")) ? (true) : (false);
    control = controlData && controlId && controlFlagState && controlFlagVisible;
    return control;
  }

  private boolean controlDeleteData(Map<String, String> data) {
    boolean controlId = (data.containsKey("id") && (Byte.parseByte(data.get("id")) > 0)) ? (true) : (false);
    return controlId;
  }

  public GroupRol save(Map<String, String> data) {
    boolean control = this.controlNewData(data);
    GroupRol result = new GroupRol();
    if (control) {
      result = this.service.save(data);
    }
    return result;
  }

  public GroupRol update(Map<String, String> data) {
    boolean control = this.controlUpdateData(data);
    GroupRol result = new GroupRol();
    if (control) {
      result = this.service.update(data);
    }
    return result;
  }

  public GroupRol delete(Map<String, String> data) {
    boolean control = this.controlDeleteData(data);
    GroupRol result = new GroupRol();
    if (control) {
      result = this.service.delete(data);
    }
    return result;
  }
}
