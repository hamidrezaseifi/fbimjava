package com.featurebim.gui.model.ui.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EUiUserRole {

  NOROLE(1L, "No Role", ""),
  USER(5L, "Benutzer", "ROLE_USER"),
  VIEW(10L, "Zuschauer", "ROLE_VIEW"),
  GUEST(15L, "Gast", ""),
  ADMIN(25L, "Administrator", "ROLE_ADMIN");

  private final Long   id;
  private final String name;
  private final String authority;

  private EUiUserRole(final Long id, final String name, final String authority) {
    this.id = id;
    this.name = name;
    this.authority = authority;
  }

  public Long getId() {
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
