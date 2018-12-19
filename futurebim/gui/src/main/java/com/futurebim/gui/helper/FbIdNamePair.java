package com.futurebim.gui.helper;

public class FbIdNamePair {
  
  private int    id;
  private String name;
  
  public FbIdNamePair() {

  }
  
  public FbIdNamePair(final int id, final String name) {
    super();
    this.id = id;
    this.name = name;
  }
  
  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(final int id) {
    this.id = id;
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
