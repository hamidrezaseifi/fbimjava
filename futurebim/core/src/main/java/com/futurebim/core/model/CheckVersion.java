package com.futurebim.core.model;

import java.util.ArrayList;
import java.util.List;

import com.futurebim.common.model.edo.CheckVersionEdo;

/**
 * The persistent class for the companies database table.
 *
 */
public class CheckVersion {
  
  private Long id;
  
  private int version;
  
  private List<CheckVersion> checkList = new ArrayList<>();
  
  public CheckVersion() {
  }
  
  /**
   * @return the parentId
   */
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long id) {
    this.id = id == null ? 0 : id;
  }
  
  public int getVersion() {
    return this.version;
  }
  
  public void setVersion(final int version) {
    this.version = version;
  }
  
  /**
   * @return the checkList
   */
  public List<CheckVersion> getCheckList() {
    return checkList;
  }
  
  /**
   * @param checkList the checkList to set
   */
  public void setCheckList(final List<CheckVersion> checkList) {
    this.checkList = checkList;
  }
  
  public CheckVersionEdo toEdo() {
    
    final CheckVersionEdo edo = new CheckVersionEdo();
    edo.setId(id);
    edo.setVersion(version);
    edo.setCheckList(toEdoList(checkList));

    return edo;
  }

  public static CheckVersion fromEdo(final CheckVersionEdo edo) {
    
    final CheckVersion model = new CheckVersion();
    model.setId(edo.getId());
    model.setVersion(edo.getVersion());
    model.setCheckList(fromEdoList(edo.getCheckList()));

    return model;

  }

  public static List<CheckVersion> fromEdoList(final List<CheckVersionEdo> edoList) {
    final List<CheckVersion> list = new ArrayList<>();
    for (final CheckVersionEdo edo : edoList) {
      list.add(fromEdo(edo));
    }
    
    return list;
  }

  public static List<CheckVersionEdo> toEdoList(final List<CheckVersion> list) {
    final List<CheckVersionEdo> edoList = new ArrayList<>();
    for (final CheckVersion model : list) {
      edoList.add(model.toEdo());
    }
    
    return edoList;
  }
  
}
