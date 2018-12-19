package org.springframework.security.authentication;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.futurebim.gui.model.futurebim.GuiUserFull;

public class FBAuthenticationToken extends UsernamePasswordAuthenticationToken {
  
  /**
   *
   */
  private static final long serialVersionUID = -7341854439748304108L;
  private final GuiUserFull user;
  
  public FBAuthenticationToken(final GuiUserFull user) {
    super(user.getUsername(), "fakepass", user.getAuthorities());
    
    this.user = user;
  }
  
  public GuiUserFull getUser() {
    return user;
  }
  
  @Override
  public Collection<GrantedAuthority> getAuthorities() {
    return user.getAuthorities();
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
