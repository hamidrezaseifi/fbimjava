package com.featurebim.gui.model.ui.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EUiUserRole {
  
  NOROLE(1, "No Role", ""),
  USER(5, "Benutzer", "ROLE_USER"),
  VIEW(10, "Zuschauer", "ROLE_VIEW"),
  GUEST(15, "Gast", ""),
  ADMIN(25, "Administrator", "ROLE_ADMIN");
  
  private final int    id;
  private final String name;
  private final String authority;
  
  private EUiUserRole(final int id, final String name, final String authority) {
    this.id = id;
    this.name = name;
    this.authority = authority;
  }
  
  public int getId() {
    return id;
  }
  
  public String getName() {
    return name;
  }
  
  public String getAuthority() {
    return authority;
  }
  
  @JsonCreator
  public static EUiUserRole ofValue(final String value) {
    if (value == null) {
      return NOROLE;
    }
    for (final EUiUserRole role : values()) {
      if (role.name().equals(value)) {
        return role;
      }
    }
    return NOROLE;
  }
  
  public static EUiUserRole ofId(final int id) {
    if (id < 1) {
      return NOROLE;
    }
    for (final EUiUserRole role : values()) {
      if (role.getId() == id) {
        return role;
      }
    }
    return NOROLE;
  }
  
}
