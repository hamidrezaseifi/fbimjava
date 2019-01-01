package com.futurebim.gui.helper;

public class TaskChangeCheckData {

  private Long id;
  private int  version;

  public TaskChangeCheckData() {
    
  }

  public TaskChangeCheckData(final Long id, final int version) {
    super();
    this.id = id;
    this.version = version;
  }

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }
  
  /**
   * @param id the id to set
   */
  public void setId(final Long id) {
    this.id = id;
  }
  
  /**
   * @return the name
   */
  public int getVersion() {
    return version;
  }
  
  /**
   * @param name the name to set
   */
  public void setName(final int version) {
    this.version = version;
  }

}
