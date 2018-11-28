package com.featurebim.gui.model.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.featurebim.gui.model.futurebim.GuiUser;
import com.featurebim.gui.model.ui.enums.EUiUserRole;

@JsonIgnoreProperties(value = { "authorities" })
public class UiUser {

  private GuiUser                 user;
  private final List<EUiUserRole> roles;

  public UiUser() {
    this.roles = new ArrayList<>();
  }

  public UiUser(final GuiUser user,
                final EUiUserRole[] roles) {

    this.user = user;
    this.roles = Arrays.asList(roles);
  }

  public UiUser(final GuiUser user,
                final List<EUiUserRole> roles) {

    this.user = user;

    this.roles = new ArrayList<>();
    this.roles.addAll(roles);
  }

  public String getUsername() {
    return user.getUsername();
  }

  public boolean equal(final String username) {

    return this.getUsername().equals(username);
  }

  public String getFirstname() {
    return user.getFirstname();
  }

  public String getLastname() {
    return user.getLastname();
  }

  public String getGermanFullName() {
    return getLastname() + ", " + getFirstname();
  }

  public List<EUiUserRole> getRoles() {
    return roles;
  }

  public boolean allowEdit() {
    return roles.contains(EUiUserRole.ADMIN) || roles.contains(EUiUserRole.DATA_STEWARD);
  }

  public boolean isAdmin() {
    return roles.contains(EUiUserRole.ADMIN);
  }

  public boolean isDatasteward() {
    return roles.contains(EUiUserRole.DATA_STEWARD);
  }

  public String getRoleNames() {
    String name = "";
    for (final EUiUserRole role : this.roles) {
      name += (name.isEmpty() ? "" : ", ") + role.toString().toUpperCase();
    }
    return name;
  }

  private String getRolesAuthoritiesNames() {
    String name = "";
    for (final EUiUserRole role : this.roles) {
      name += (name.isEmpty() ? "" : ", ") + role.getAuthority().toUpperCase();
    }
    return name;
  }

  public void setRoles(final List<EUiUserRole> roles) {
    this.roles.clear();
    this.roles.addAll(roles);
  }

  public long getUserId() {
    return user.getId();
  }

  public List<GrantedAuthority> getAuthorities() {
    final List<GrantedAuthority> list = AuthorityUtils.commaSeparatedStringToAuthorityList(getRolesAuthoritiesNames());
    return list;
  }
}
