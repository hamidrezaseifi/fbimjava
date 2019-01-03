package com.futurebim.gui.model.ui;

import java.util.ArrayList;
import java.util.List;

import com.futurebim.common.model.edo.MenuItemEdo;

public class GuiMenuItem {
  
  private String                  id;
  private String                  label;
  private String                  image;
  private String                  url;
  private boolean                 state;
  private boolean                 active;
  private final List<GuiMenuItem> children = new ArrayList<>();
  
  public GuiMenuItem() {
    
  }
  
  public GuiMenuItem(final String id, final String label, final String image, final String url) {
    this.id = id;
    this.label = label;
    this.image = image;
    this.url = url;
    this.state = true;
  }
  
  public GuiMenuItem(final String id, final String label, final String image, final String url, final boolean active) {
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
  public List<GuiMenuItem> getChildren() {
    return children;
  }
  
  /**
   * @param children the children to set
   */
  public void setChildren(final List<GuiMenuItem> children) {

    this.children.clear();
    if (children != null) {
      this.children.addAll(children);
    }
  }
  
  @Override
  public GuiMenuItem clone() {
    final GuiMenuItem menu = new GuiMenuItem(id, label, image, url, active);
    menu.setState(state);
    
    return menu;
  }
  
  public MenuItemEdo toEdo() {
    final MenuItemEdo edo = new MenuItemEdo();
    
    edo.setId(id);
    edo.setImage(image);
    edo.setLabel(label);
    edo.setState(state ? 1 : 0);
    edo.setUrl(url);
    edo.setChildren(toEdoList(children));

    return edo;
  }
  
  public static GuiMenuItem fromEdo(final MenuItemEdo edo) {
    final GuiMenuItem model = new GuiMenuItem();
    
    model.setId(edo.getId());
    model.setImage(edo.getImage());
    model.setLabel(edo.getLabel());
    model.setState(edo.getState() == 1);
    model.setUrl(edo.getUrl());
    model.setChildren(fromEdoList(edo.getChildren()));
    
    return model;
  }
  
  public static List<MenuItemEdo> toEdoList(final List<GuiMenuItem> list) {
    
    final List<MenuItemEdo> edoList = new ArrayList<>();
    for (final GuiMenuItem p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }
  
  public static List<GuiMenuItem> fromEdoList(final List<MenuItemEdo> edoList) {
    
    final List<GuiMenuItem> list = new ArrayList<>();
    for (final MenuItemEdo edo : edoList) {
      list.add(GuiMenuItem.fromEdo(edo));
    }
    return list;
  }

}
