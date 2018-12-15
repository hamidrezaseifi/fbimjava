package com.featurebim.gui.model.futurebim;

public class GuiProjectType {

  private final int type;
  private String    name;

  public GuiProjectType() {
    this.type = 0;
    this.name = "";
  }

  public GuiProjectType(final int type, final String name) {
    this.type = type;
    this.name = name;
  }
  
  /**
   * @return the type
   */
  public int getType() {
    return type;
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(final String name) {
    this.name = name;
  }
  
}
