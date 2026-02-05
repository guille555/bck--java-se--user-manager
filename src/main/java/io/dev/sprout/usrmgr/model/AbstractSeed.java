package io.dev.sprout.usrmgr.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DEV sprout
 */
@MappedSuperclass
public abstract class AbstractSeed {

  @Column(name = "flag_state")
  protected boolean flagState;
  @Column(name = "flag_visible")
  protected boolean flagVisible;
  @Column(name = "create_date")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date createDate;
  @Column(name = "last_update")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastUpdate;

  public AbstractSeed() {
    this.flagState = false;
    this.flagVisible = false;
  }

  public boolean isFlagState() {
    return flagState;
  }

  public void setFlagState(boolean flagState) {
    this.flagState = flagState;
  }

  public boolean isFlagVisible() {
    return flagVisible;
  }

  public void setFlagVisible(boolean flagVisible) {
    this.flagVisible = flagVisible;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public abstract String objInfo();
}
