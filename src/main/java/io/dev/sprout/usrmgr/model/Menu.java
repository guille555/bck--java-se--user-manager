package io.dev.sprout.usrmgr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author DEV sprout
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "menu")
public class Menu extends AbstractSeed implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "menu_id")
  private Short id;
  @Column(name = "name")
  private String name;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "group_rol_id", referencedColumnName = "group_rol_id", foreignKey = @ForeignKey(name = "fk_menu_group_rol", value = ConstraintMode.PROVIDER_DEFAULT))
  private GroupRol groupRol;
  @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
  private List<Submenu> listSubmenus;

  public Menu() {
    super();
    this.id = 0;
    this.listSubmenus = new ArrayList<Submenu>();
  }

  public Short getId() {
    return id;
  }

  public void setId(Short id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GroupRol getGroupRol() {
    return groupRol;
  }

  public void setGroupRol(GroupRol groupRol) {
    this.groupRol = groupRol;
  }

  public List<Submenu> getListSubmenus() {
    return listSubmenus;
  }

  public void setListSubmenus(List<Submenu> listSubmenus) {
    this.listSubmenus = listSubmenus;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 89 * hash + Objects.hashCode(this.id);
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
    final Menu other = (Menu) obj;
    return Objects.equals(this.id, other.id);
  }

  @Override
  public String toString() {
    return "Menu{}";
  }

  @Override
  public String objInfo() {
    String text = "Menu {}";
    return text;
  }
}
