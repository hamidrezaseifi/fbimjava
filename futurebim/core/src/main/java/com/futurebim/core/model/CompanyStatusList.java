package com.futurebim.core.model;

import java.util.ArrayList;
import java.util.List;

import com.futurebim.common.model.edo.CompanyStatusItemEdo;
import com.futurebim.common.model.edo.CompanyStatusListEdo;

/**
 * The persistent class for the companies database table.
 *
 */
public class CompanyStatusList {

  private List<CompanyStatusItem> items = new ArrayList<>();

  public List<CompanyStatusItem> getItems() {
    return items;
  }

  public void setItems(final List<CompanyStatusItem> items) {
    this.items = items;
  }

  public void addItems(final CompanyStatusItem item) {
    this.items.add(item);
  }

  public CompanyStatusListEdo toEdo() {
    final CompanyStatusListEdo edoList = new CompanyStatusListEdo();
    for (final CompanyStatusItem item : items) {
      edoList.addItems(item.toEdo());
    }

    return edoList;
  }

  public static CompanyStatusList fromEdo(final CompanyStatusListEdo edoList) {

    final CompanyStatusList list = new CompanyStatusList();
    for (final CompanyStatusItemEdo edo : edoList.getItems()) {
      list.addItems(CompanyStatusItem.fromEdo(edo));
    }

    return list;

  }
}
