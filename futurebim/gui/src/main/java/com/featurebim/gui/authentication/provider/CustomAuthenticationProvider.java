package com.featurebim.gui.authentication.provider;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.FBAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.featurebim.gui.bl.IUserHandler;
import com.featurebim.gui.configuration.UiConfiguration.CoreAccessConfig;
import com.featurebim.gui.model.futurebim.GuiUser;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  CoreAccessConfig coreAccessConfig;

  @Autowired
  private IUserHandler userHandler;

  @PostConstruct
  private void init() {

  }

  @Override
  public Authentication authenticate(final Authentication authentication) throws AuthenticationException {

    final String username = authentication.getName();
    final String password = authentication.getCredentials().toString();

    final GuiUser authUser = userHandler.authenticateUser(username, password);

    if (authUser != null) {

      // final List<GrantedAuthority> grantedAuths = AuthorityUtils.commaSeparatedStringToAuthorityList(login.getRole());

      return new FBAuthenticationToken(authUser);
    }

    return null;

  }

  @Override
  public boolean supports(final Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
