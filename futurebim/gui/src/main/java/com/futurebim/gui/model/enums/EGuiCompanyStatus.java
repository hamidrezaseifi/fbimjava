package com.futurebim.gui.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EGuiCompanyStatus {
  UNKNOWN(0),
  ACTIVE(1),
  DEACTIVE(2),
  DELETED(3),
  NOT_INITIALIZED(4);

  int id;

  private EGuiCompanyStatus(final int id) {
    this.id = id;
  }

  @JsonCreator
  public static EGuiCompanyStatus fromId(final int id) {
    for (final EGuiCompanyStatus at : values()) {
      if (at.getId() == id) {
        return at;
      }
    }

    return EGuiCompanyStatus.UNKNOWN;
  }

  public int getId() {
    return id;
  }

}
