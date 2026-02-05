package io.dev.sprout.usrmgr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author DEV sprout
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "group_rol")
public class GroupRol extends AbstractSeed implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "group_rol_id")
  private Byte id;
  @Column(name = "name")
  private String name;
  @OneToMany(mappedBy = "groupRol", fetch = FetchType.LAZY)
  private List<Menu> listMenus;
  @OneToMany(mappedBy = "groupRol", fetch = FetchType.LAZY)
  private List<UserAccount> listUsersAccounts;

  public GroupRol() {
    super();
    this.id = 0;
    this.listMenus = new ArrayList<Menu>();
    this.listUsersAccounts = new ArrayList<UserAccount>();
  }

  public Byte getId() {
    return id;
  }

  public void setId(Byte id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Menu> getListMenus() {
    return listMenus;
  }

  public void setListMenus(List<Menu> listMenus) {
    this.listMenus = listMenus;
  }

  public List<UserAccount> getListUsersAccounts() {
    return listUsersAccounts;
  }

  public void setListUsersAccounts(List<UserAccount> listUsersAccounts) {
    this.listUsersAccounts = listUsersAccounts;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 53 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final GroupRol other = (GroupRol) obj;
    return Objects.equals(this.id, other.id);
  }

  @Override
  public String toString() {
    return "GroupRol{}";
  }

  @Override
  public String objInfo() {
    String text = "GroupRol {}";
    return text;
  }
}
