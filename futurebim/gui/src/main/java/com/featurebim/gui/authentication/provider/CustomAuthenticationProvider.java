package com.featurebim.gui.authentication.provider;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import com.featurebim.common.model.edo.UserEdo;
import com.featurebim.common.model.edo.UserLoginEdo;
import com.featurebim.common.model.enums.EModule;
import com.featurebim.gui.configuration.UiConfiguration.CoreAccessConfig;
import com.featurebim.gui.helper.IUiRestTemplateCall;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  CoreAccessConfig coreAccessConfig;

  @Autowired
  private IUiRestTemplateCall restTemplateCall;

  @PostConstruct
  private void init() {

  }

  @Override
  public Authentication authenticate(final Authentication authentication) throws AuthenticationException {

    final String name = authentication.getName();
    final String password = authentication.getCredentials().toString();

    final UserLoginEdo loginEdo = new UserLoginEdo(name, password);

    try {
      final UserEdo userEdo = restTemplateCall.callRestPost(coreAccessConfig.getUserAuthenticate(),
                                                            EModule.CORE,
                                                            loginEdo,
                                                            UserEdo.class,
                                                            true);

      if (userEdo != null) {

        // final List<GrantedAuthority> grantedAuths = AuthorityUtils.commaSeparatedStringToAuthorityList(login.getRole());
        final List<GrantedAuthority> grantedAuths = AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN");

        return new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
      }
      else {
        return null;
      }
    }
    catch (final Exception e) {
      return null;
    }
  }

  @Override
  public boolean supports(final Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
