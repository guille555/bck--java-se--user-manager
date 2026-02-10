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

/**
 * @author DEV sprout
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "submenu")
public class Submenu extends AbstractSeed implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "submenu_id")
  private Integer id;
  @Column(name = "name")
  private String name;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "menu_id", referencedColumnName = "menu_id", foreignKey = @ForeignKey(name = "fk_submenu_menu", value = ConstraintMode.PROVIDER_DEFAULT))
  private Menu menu;
  @OneToMany(mappedBy = "submenu", fetch = FetchType.LAZY)
  private List<ItemOption> listItemsOptions;

  public Submenu() {
    super();
    this.id = 0;
    this.listItemsOptions = new ArrayList<ItemOption>();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  public List<ItemOption> getListItemsOptions() {
    return listItemsOptions;
  }

  public void setListItemsOptions(List<ItemOption> listItemsOptions) {
    this.listItemsOptions = listItemsOptions;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 43 * hash + Objects.hashCode(this.id);
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
    final Submenu other = (Submenu) obj;
    return Objects.equals(this.id, other.id);
  }

  @Override
  public String toString() {
    return "Submenu{}";
  }

  @Override
  public String objInfo() {
    StringBuilder builder = new StringBuilder();
    builder.append("Submenu {");
    builder.append(" id: ");
    builder.append(this.id);
    builder.append(" name: ");
    builder.append(this.name);
    builder.append(" flagSate: ");
    builder.append(this.flagState);
    builder.append(" flagVisible: ");
    builder.append(this.flagVisible);
    builder.append(" createDate: ");
    builder.append(this.createDate);
    builder.append(" lastUpdate: ");
    builder.append(this.lastUpdate);
    builder.append(" menu: ");
    builder.append(this.menu.getName());
    builder.append("(");
    builder.append(this.menu.getId());
    builder.append(")");
    builder.append(" groupRol: ");
    builder.append(this.menu.getGroupRol().getName());
    builder.append("(");
    builder.append(this.menu.getGroupRol().getId());
    builder.append(") }");
    String text = builder.toString();
    return text;
  }
}
