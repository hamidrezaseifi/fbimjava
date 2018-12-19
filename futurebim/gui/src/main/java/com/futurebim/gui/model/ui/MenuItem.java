package com.futurebim.gui.model.ui;

public class MenuItem {

  private String  id;
  private String  label;
  private String  image;
  private String  url;
  private boolean state;
  private boolean active;

  public MenuItem() {

  }

  public MenuItem(final String id, final String label, final String image, final String url) {
    this.id = id;
    this.label = label;
    this.image = image;
    this.url = url;
    this.state = true;
  }

  public MenuItem(final String id, final String label, final String image, final String url, final boolean active) {
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

  public boolean hasImage()
  {
    return image != null && image.length() > 1;
  }

  public String getCssClass(final String cssClass)
  {
    return image + " " + cssClass;
  }


  public boolean isActive() {
    return active;
  }


  public void setActive(final boolean active) {
    this.active = active;
  }

  @Override
  public MenuItem clone()
  {
    final MenuItem menu = new MenuItem(id, label, image, url, active);
    menu.setState(state);

    return menu;
  }
}
