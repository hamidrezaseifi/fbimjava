package org.springframework.security.authentication;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.featurebim.gui.model.futurebim.GuiUser;

public class FBAuthenticationToken extends UsernamePasswordAuthenticationToken {

  /**
   *
   */
  private static final long serialVersionUID = -7341854439748304108L;
  private final GuiUser     user;

  public FBAuthenticationToken(final GuiUser user) {
    super(user.getUsername(), user.getHashPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN"));

    this.user = user;
  }

  public GuiUser getUser() {
    return user;
  }

  @Override
  public Collection<GrantedAuthority> getAuthorities() {
    return AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN");
  }

  @Override
  public Object getPrincipal() {
    return user.getUsername();
  }

  @Override
  public Object getCredentials() {
    return null;
  }
}
