package io.dev.sprout.usrmgr.service;

import io.dev.sprout.usrmgr.dao.GroupRolDAOImp;
import io.dev.sprout.usrmgr.dao.IGroupRolDAO;
import io.dev.sprout.usrmgr.model.GroupRol;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author DEV sprout
 */
public class GroupRolServiceImp implements IGroupRolService {

  IGroupRolDAO dao = null;

  public GroupRolServiceImp() {
    this.dao = new GroupRolDAOImp();
  }

  private GroupRol createNewGroupRol(Map<String, String> data) {
    Date date = new Date();
    String name = data.get("name").toUpperCase();
    GroupRol groupRol = new GroupRol();
    groupRol.setName(name);
    groupRol.setFlagState(true);
    groupRol.setFlagVisible(true);
    groupRol.setCreateDate(date);
    return groupRol;
  }

  private GroupRol updateGroupRol(Map<String, String> data) {
    boolean flagState = Boolean.parseBoolean(data.get("flagState"));
    boolean flagVisible = Boolean.parseBoolean(data.get("flagVisible"));
    Byte id = Byte.valueOf(data.get("id"));
    String name = data.get("name").toUpperCase();
    Date createDate = new Date();
    Date lastUpdate = new Date();
    GroupRol groupRol = new GroupRol();
    createDate.setTime(Long.parseLong(data.get("createDate")));
    groupRol.setId(id);
    groupRol.setName(name);
    groupRol.setFlagState(flagState);
    groupRol.setFlagVisible(flagVisible);
    groupRol.setCreateDate(createDate);
    groupRol.setLastUpdate(lastUpdate);
    return groupRol;
  }

  @Override
  public GroupRol save(Map<String, String> data) {
    GroupRol newGroupRol = null;
    GroupRol result = null;
    try {
      newGroupRol = this.createNewGroupRol(data);
      result = this.dao.save(newGroupRol);
      return result;
    } catch (Exception exc) {
      result = new GroupRol();
      return result;
    }
  }

  @Override
  public GroupRol update(Map<String, String> data) {
    Byte id = null;
    GroupRol result = null;
    GroupRol groupRol = null;
    try {
      id = Byte.valueOf(data.get("id"));
      groupRol = this.findById(id);
      if (groupRol.getId() > 0) {
        data.put("createDate", String.valueOf(groupRol.getCreateDate().getTime()));
        groupRol = this.updateGroupRol(data);
        result = this.dao.update(groupRol);
      }
      return result;
    } catch (Exception exc) {
      result = new GroupRol();
      return result;
    }
  }

  @Override
  public GroupRol delete(Map<String, String> data) {
    Byte id = null;
    GroupRol groupRol = null;
    GroupRol result = null;
    try {
      result = new GroupRol();
      id = Byte.valueOf(data.get("id"));
      groupRol = this.findById(id);
      if (groupRol.getId() > 0) {
        result = this.dao.delete(groupRol);
      }
      return result;
    } catch (Exception exc) {
      result = new GroupRol();
      return result;
    }
  }

  @Override
  public GroupRol findById(Byte id) {
    GroupRol result = null;
    try {
      result = this.dao.findById(id);
      return result;
    } catch (Exception exc) {
      result = new GroupRol();
      return result;
    }
  }

  @Override
  public List<GroupRol> findAll() {
    List<GroupRol> list = null;
    try {
      list = this.dao.findAll();
      if (list == null) {
        return new ArrayList<GroupRol>();
      }
      return list;
    } catch (Exception exc) {
      list = new ArrayList<GroupRol>();
      return list;
    }
  }
}
