package com.futurebim.core.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.futurebim.common.model.edo.SystemMenuItemEdo;
import com.futurebim.common.rest.json.FBLocalDateTimeDeserializer;
import com.futurebim.common.rest.json.FBLocalDateTimeSerializer;

public class SystemMenuItem {
  
  public static final String ROOTMENU_ID = "menu.root";
  
  private String                     id;
  private String                     parebtid;
  private String                     label;
  private String                     image;
  private String                     url;
  private int                        state;
  private int                        sort;
  private final List<SystemMenuItem> children = new ArrayList<>();
  
  @JsonSerialize(using = FBLocalDateTimeSerializer.class)
  @JsonDeserialize(using = FBLocalDateTimeDeserializer.class)
  private LocalDateTime created;
  
  @JsonSerialize(using = FBLocalDateTimeSerializer.class)
  @JsonDeserialize(using = FBLocalDateTimeDeserializer.class)
  private LocalDateTime updated;
  
  private int version;

  public SystemMenuItem() {
    
  }

  public String getId() {
    return id;
  }
  
  /**
   * @return the parebtid
   */
  public String getParebtid() {
    return parebtid;
  }
  
  /**
   * @param parebtid the parebtid to set
   */
  public void setParebtid(final String parebtid) {
    this.parebtid = parebtid;
  }
  
  public void setId(final String id) {
    this.id = id;
  }
  
  public String getLabel() {
    return label;
  }
  
  public void setLabel(final String label) {
    this.label = label;
  }
  
  public String getImage() {
    return image;
  }
  
  public void setImage(final String image) {
    this.image = image;
  }
  
  public String getUrl() {
    return url;
  }
  
  public void setUrl(final String url) {
    this.url = url;
  }
  
  public int getState() {
    return state;
  }

  public void setState(final int state) {
    this.state = state;
  }
  
  /**
   * @return the sort
   */
  public int getSort() {
    return sort;
  }
  
  /**
   * @param sort the sort to set
   */
  public void setSort(final int sort) {
    this.sort = sort;
  }
  
  public boolean hasImage() {
    return image != null && image.length() > 1;
  }
  
  public String getCssClass(final String cssClass) {
    return image + " " + cssClass;
  }

  /**
   * @return the children
   */
  public List<SystemMenuItem> getChildren() {
    return children;
  }
  
  /**
   * @param children the children to set
   */
  public void setChildren(final List<SystemMenuItem> children) {

    this.children.clear();
    if (children != null) {
      this.children.addAll(children);
    }
  }
  
  /**
   * @return the created
   */
  public LocalDateTime getCreated() {
    return created;
  }
  
  /**
   * @param created the created to set
   */
  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }
  
  /**
   * @return the updated
   */
  public LocalDateTime getUpdated() {
    return updated;
  }
  
  /**
   * @param updated the updated to set
   */
  public void setUpdated(final LocalDateTime updated) {
    this.updated = updated;
  }
  
  /**
   * @return the version
   */
  public int getVersion() {
    return version;
  }
  
  /**
   * @param version the version to set
   */
  public void setVersion(final int version) {
    this.version = version;
  }
  
  public SystemMenuItemEdo toEdo() {
    final SystemMenuItemEdo edo = new SystemMenuItemEdo();
    
    edo.setId(id);
    edo.setImage(image);
    edo.setLabel(label);
    edo.setState(state);
    edo.setUrl(url);
    edo.setChildren(toEdoList(children));
    edo.setCreated(created);
    edo.setUpdated(updated);
    edo.setVersion(version);
    edo.setParebtid(parebtid);

    return edo;
  }
  
  public static SystemMenuItem fromEdo(final SystemMenuItemEdo edo) {
    final SystemMenuItem model = new SystemMenuItem();
    
    model.setId(edo.getId());
    model.setImage(edo.getImage());
    model.setLabel(edo.getLabel());
    model.setState(edo.getState());
    model.setUrl(edo.getUrl());
    model.setChildren(fromEdoList(edo.getChildren()));
    model.setCreated(edo.getCreated());
    model.setUpdated(edo.getUpdated());
    model.setVersion(edo.getVersion());
    model.setParebtid(edo.getParebtid());

    return model;
  }
  
  public static List<SystemMenuItemEdo> toEdoList(final List<SystemMenuItem> list) {
    
    final List<SystemMenuItemEdo> edoList = new ArrayList<>();
    for (final SystemMenuItem p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }
  
  public static List<SystemMenuItem> fromEdoList(final List<SystemMenuItemEdo> edoList) {
    
    final List<SystemMenuItem> list = new ArrayList<>();
    for (final SystemMenuItemEdo edo : edoList) {
      list.add(SystemMenuItem.fromEdo(edo));
    }
    return list;
  }
}
