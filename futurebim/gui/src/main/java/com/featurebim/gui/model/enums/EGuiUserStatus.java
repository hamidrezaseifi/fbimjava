package com.featurebim.gui.model.enums;

public enum EGuiUserStatus {
  UNKNOWN(0),
  ACTIVE(1),
  DEACTIVE(2),
  DELETED(3),
  NOT_INITIALIZED(4);

  int id;

  private EGuiUserStatus(final int id) {
    this.id = id;
  }

  public static EGuiUserStatus fromId(final int id) {
    for (final EGuiUserStatus at : values()) {
      if (at.getId() == id) {
        return at;
      }
    }

    return EGuiUserStatus.UNKNOWN;
  }

  public int getId() {
    return id;
  }

}
