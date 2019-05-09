package com.futurebim.gui.model.ui;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.futurebim.common.model.edo.SystemMenuItemEdo;
import com.futurebim.common.rest.json.FBLocalDateTimeDeserializer;
import com.futurebim.common.rest.json.FBLocalDateTimeSerializer;

public class GuiSystemMenuItem implements Comparable<GuiSystemMenuItem> {
  
  private String                        id;
  private String                        parent;
  private String                        label;
  private String                        image;
  private String                        url;
  private boolean                       state;
  private int                           sort;
  private boolean                       active;
  private final List<GuiSystemMenuItem> children = new ArrayList<>();
  
  @JsonSerialize(using = FBLocalDateTimeSerializer.class)
  @JsonDeserialize(using = FBLocalDateTimeDeserializer.class)
  private LocalDateTime created;

  @JsonSerialize(using = FBLocalDateTimeSerializer.class)
  @JsonDeserialize(using = FBLocalDateTimeDeserializer.class)
  private LocalDateTime updated;

  private int version;
  
  public GuiSystemMenuItem() {
    
  }
  
  public GuiSystemMenuItem(final String id, final String label, final String image, final String url) {
    this.id = id;
    this.label = label;
    this.image = image;
    this.url = url;
    this.state = true;
  }
  
  public GuiSystemMenuItem(final String id, final String label, final String image, final String url, final boolean active) {
    this.id = id;
    this.label = label;
    this.image = image;
    this.url = url;
    this.active = active;
    this.state = true;
  }
  
  public String getId() {
    return id;
  }
  
  public void setId(final String id) {
    this.id = id;
  }

  /**
   * @return the parebtid
   */
  public String getParent() {
    return parent;
  }
  
  public boolean hasParent() {
    return StringUtils.isNoneBlank(parent);
  }
  
  public boolean isRoot() {
    return StringUtils.isBlank(parent);
  }

  /**
   * @param parebtid the parebtid to set
   */
  public void setParebtid(final String parebtid) {
    this.parent = parebtid;
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
  
  public boolean getState() {
    return state;
  }
  
  public boolean isEnabled() {
    return state;
  }
  
  public void setState(final boolean state) {
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
  
  public boolean isActive() {
    return active;
  }
  
  public void setActive(final boolean active) {
    this.active = active;
  }
  
  /**
   * @return the children
   */
  public List<GuiSystemMenuItem> getChildren() {
    return children;
  }
  
  /**
   * @param children the children to set
   */
  public void setChildren(final List<GuiSystemMenuItem> children) {

    this.children.clear();
    if (children != null) {
      this.children.addAll(children);
    }
  }
  
  @Override
  public GuiSystemMenuItem clone() {
    final GuiSystemMenuItem menu = new GuiSystemMenuItem(id, label, image, url, active);
    menu.setState(state);
    
    return menu;
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
  
  public boolean isCurrentMenu(final String url) {
    if (getUrl().toLowerCase().equals(url.toLowerCase())) {
      return true;
    }

    for (final GuiSystemMenuItem lmenu : getChildren()) {
      if (lmenu.getUrl().toLowerCase().equals(url.toLowerCase())) {
        return true;
      }
    }

    return false;
  }
  
  public SystemMenuItemEdo toEdo() {
    final SystemMenuItemEdo edo = new SystemMenuItemEdo();
    
    edo.setId(id);
    edo.setImage(image);
    edo.setLabel(label);
    edo.setState(state ? 1 : 0);
    edo.setUrl(url);
    edo.setChildren(toEdoList(children));
    edo.setCreated(created);
    edo.setUpdated(updated);
    edo.setVersion(version);
    edo.setParebtid(parent);

    return edo;
  }
  
  public static GuiSystemMenuItem fromEdo(final SystemMenuItemEdo edo) {
    final GuiSystemMenuItem model = new GuiSystemMenuItem();
    
    model.setId(edo.getId());
    model.setImage(edo.getImage());
    model.setLabel(edo.getLabel());
    model.setState(edo.getState() == 1);
    model.setUrl(edo.getUrl());
    model.setChildren(fromEdoList(edo.getChildren()));
    model.setCreated(edo.getCreated());
    model.setUpdated(edo.getUpdated());
    model.setVersion(edo.getVersion());
    model.setParebtid(edo.getParebtid());
    
    return model;
  }
  
  public static List<SystemMenuItemEdo> toEdoList(final List<GuiSystemMenuItem> list) {
    
    final List<SystemMenuItemEdo> edoList = new ArrayList<>();
    for (final GuiSystemMenuItem p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }
  
  public static List<GuiSystemMenuItem> fromEdoList(final List<SystemMenuItemEdo> edoList) {
    
    final List<GuiSystemMenuItem> list = new ArrayList<>();
    for (final SystemMenuItemEdo edo : edoList) {
      list.add(GuiSystemMenuItem.fromEdo(edo));
    }
    return list;
  }

  @Override
  public int compareTo(final GuiSystemMenuItem o) {
    
    return this.sort > o.sort ? 1 : this.sort < o.sort ? -1 : 0;
  }

}
