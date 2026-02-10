package io.dev.sprout.usrmgr.model;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 * @author DEV sprout
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "item_option")
public class ItemOption extends AbstractSeed implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "item_option_id")
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "route")
  private String route;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "submenu_id", referencedColumnName = "submenu_id", foreignKey = @ForeignKey(name = "fk_item_option_submenu", value = ConstraintMode.PROVIDER_DEFAULT))
  private Submenu submenu;

  public ItemOption() {
    super();
    this.id = 0L;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRoute() {
    return route;
  }

  public void setRoute(String route) {
    this.route = route;
  }

  public Submenu getSubmenu() {
    return submenu;
  }

  public void setSubmenu(Submenu submenu) {
    this.submenu = submenu;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 47 * hash + Objects.hashCode(this.id);
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
    final ItemOption other = (ItemOption) obj;
    return Objects.equals(this.id, other.id);
  }

  @Override
  public String toString() {
    return "ItemOption{}";
  }

  @Override
  public String objInfo() {
    StringBuilder builder = new StringBuilder();
    builder.append("ItemOption { ");
    builder.append(" id: ");
    builder.append(this.id);
    builder.append(" name: ");
    builder.append(this.name);
    builder.append(" route: ");
    builder.append(this.route);
    builder.append(" flagState: ");
    builder.append(this.flagState);
    builder.append(" flagVisible: ");
    builder.append(this.flagVisible);
    builder.append(" createDate: ");
    builder.append(this.createDate);
    builder.append(" lastUpdate: ");
    builder.append(this.lastUpdate);
    builder.append(" Submenu: ");
    builder.append(this.submenu.getName());
    builder.append(" (");
    builder.append(this.submenu.getId());
    builder.append(") ");
    builder.append(" Menu: ");
    builder.append(this.submenu.getMenu().getName());
    builder.append(" (");
    builder.append(this.submenu.getMenu().getId());
    builder.append(") ");
    builder.append(" GroupRol: ");
    builder.append(this.submenu.getMenu().getGroupRol().getName());
    builder.append(" (");
    builder.append(this.submenu.getMenu().getGroupRol().getId());
    builder.append(")");
    String text = builder.toString();
    return text;
  }
}
