package com.featurebim.core.model;

import com.featurebim.common.model.edo.CompanyStatusItemEdo;

/**
 * The persistent class for the companies database table.
 *
 */
public class CompanyStatusItem {

  private int id;

  private String titleid;

  public CompanyStatusItem() {
  }

  public CompanyStatusItem(final int id, final String titleid) {
    this.id = id;
    this.titleid = titleid;
  }

  public int getId() {
    return this.id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public String getTitleid() {
    return titleid;
  }

  public void setTitleid(final String titleid) {
    this.titleid = titleid;
  }

  public CompanyStatusItemEdo toEdo() {
    return new CompanyStatusItemEdo(this.id, this.titleid);
  }

  public static CompanyStatusItem fromEdo(final CompanyStatusItemEdo edo) {
    return new CompanyStatusItem(edo.getId(), edo.getTitleid());
  }
}
