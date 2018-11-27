package com.featurebim.common.model.edo;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the companies database table.
 *
 */
public class CompanyStatusListEdo {

  private List<CompanyStatusItemEdo> items = new ArrayList<>();

  public List<CompanyStatusItemEdo> getItems() {
    return items;
  }

  public void setItems(final List<CompanyStatusItemEdo> items) {
    this.items = items;
  }

  public void addItems(final CompanyStatusItemEdo item) {
    this.items.add(item);
  }

}
