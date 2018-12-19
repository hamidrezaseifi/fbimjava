package com.futurebim.common.model.edo;

/**
 * The persistent class for the companies database table.
 *
 */
public class CompanyStatusItemEdo {

  private int id;

  private String titleid;

  public CompanyStatusItemEdo() {
  }

  public CompanyStatusItemEdo(final int id, final String titleid) {
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

}
