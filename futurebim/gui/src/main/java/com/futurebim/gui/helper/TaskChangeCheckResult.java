package com.futurebim.gui.helper;

public class TaskChangeCheckResult {

  private Long    id;
  private boolean changed;

  public TaskChangeCheckResult() {
    
  }

  public TaskChangeCheckResult(final Long id, final boolean changed) {
    super();
    this.id = id;
    this.changed = changed;
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
  public boolean getChanged() {
    return changed;
  }
  
  /**
   * @param name the name to set
   */
  public void setName(final boolean changed) {
    this.changed = changed;
  }

}
