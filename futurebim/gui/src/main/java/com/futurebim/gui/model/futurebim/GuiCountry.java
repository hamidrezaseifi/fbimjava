package com.futurebim.gui.model.futurebim;

public class GuiCountry {

  private String code;
  private String name;

  public GuiCountry() {
    this.code = "";
    this.name = "";
  }

  public GuiCountry(final String code, final String name) {
    this.code = code;
    this.name = name;
  }

  /**
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * @param code the code to set
   */
  public void setCode(final String code) {
    this.code = code;
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
