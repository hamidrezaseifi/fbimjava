package com.futurebim.gui.helper;

public class FbIPair<I, V> {
  
  private I id;
  private V value;
  
  public FbIPair() {
    
  }
  
  public FbIPair(final I id, final V value) {
    super();
    this.id = id;
    this.value = value;
  }
  
  /**
   * @return the id
   */
  public I getId() {
    return id;
  }
  
  /**
   * @param id the id to set
   */
  public void setId(final I id) {
    this.id = id;
  }
  
  /**
   * @return the name
   */
  public V getValue() {
    return value;
  }
  
  /**
   * @param name the name to set
   */
  public void setValue(final V value) {
    this.value = value;
  }
  
}
