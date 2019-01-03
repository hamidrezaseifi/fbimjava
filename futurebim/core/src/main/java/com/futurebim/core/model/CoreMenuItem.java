package com.futurebim.core.model;

import java.util.ArrayList;
import java.util.List;

import com.futurebim.common.model.edo.MenuItemEdo;

public class CoreMenuItem {

  private String                   id;
  private String                   label;
  private String                   image;
  private String                   url;
  private int                      state;
  private final List<CoreMenuItem> children = new ArrayList<>();

  public CoreMenuItem() {

  }
  
  public String getId() {
    return id;
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

  public boolean hasImage() {
    return image != null && image.length() > 1;
  }

  public String getCssClass(final String cssClass) {
    return image + " " + cssClass;
  }
  
  /**
   * @return the children
   */
  public List<CoreMenuItem> getChildren() {
    return children;
  }

  /**
   * @param children the children to set
   */
  public void setChildren(final List<CoreMenuItem> children) {
    
    this.children.clear();
    if (children != null) {
      this.children.addAll(children);
    }
  }

  public MenuItemEdo toEdo() {
    final MenuItemEdo edo = new MenuItemEdo();

    edo.setId(id);
    edo.setImage(image);
    edo.setLabel(label);
    edo.setState(state);
    edo.setUrl(url);
    edo.setChildren(toEdoList(children));
    
    return edo;
  }

  public static CoreMenuItem fromEdo(final MenuItemEdo edo) {
    final CoreMenuItem model = new CoreMenuItem();

    model.setId(edo.getId());
    model.setImage(edo.getImage());
    model.setLabel(edo.getLabel());
    model.setState(edo.getState());
    model.setUrl(edo.getUrl());
    model.setChildren(fromEdoList(edo.getChildren()));

    return model;
  }

  public static List<MenuItemEdo> toEdoList(final List<CoreMenuItem> list) {

    final List<MenuItemEdo> edoList = new ArrayList<>();
    for (final CoreMenuItem p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }

  public static List<CoreMenuItem> fromEdoList(final List<MenuItemEdo> edoList) {

    final List<CoreMenuItem> list = new ArrayList<>();
    for (final MenuItemEdo edo : edoList) {
      list.add(CoreMenuItem.fromEdo(edo));
    }
    return list;
  }
}
