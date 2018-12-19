package com.futurebim.gui.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EGuiProjectStatus {
  UNKNOWN(0),
  ACTIVE(1),
  DEACTIVE(4),
  DELETED(8),
  NOT_INITIALIZED(12);
  
  int id;
  
  private EGuiProjectStatus(final int id) {
    this.id = id;
  }
  
  @JsonCreator
  public static EGuiProjectStatus fromId(final int id) {
    for (final EGuiProjectStatus at : values()) {
      if (at.getId() == id) {
        return at;
      }
    }
    
    return EGuiProjectStatus.UNKNOWN;
  }
  
  public int getId() {
    return id;
  }
  
}
