package com.featurebim.gui.model.futurebim;

public class GuiProjectStatus {
  
  private final int status;
  private String    name;
  
  public GuiProjectStatus() {
    this.status = 0;
    this.name = "";
  }
  
  public GuiProjectStatus(final int status, final String name) {
    this.status = status;
    this.name = name;
  }

  /**
   * @return the type
   */
  public int getStatus() {
    return status;
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
