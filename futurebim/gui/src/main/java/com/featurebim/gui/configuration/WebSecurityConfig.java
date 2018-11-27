
package com.featurebim.gui.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.featurebim.gui.authentication.DebugModeAuthentication;
import com.featurebim.gui.authentication.UiAuthenticationFailureHandler;
import com.featurebim.gui.authentication.UiAuthenticationSuccessHandler;
import com.featurebim.gui.authentication.provider.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  public static String USERNAME_FIELD_NAME = "username";
  public static String PASSWORD_FIELD_NAME = "password";
  public static String LOGIN_URL           = "/auth/login";

  @Autowired
  private UiAuthenticationSuccessHandler uiAuthenticationSuccessHandler;

  @Autowired
  private UiAuthenticationFailureHandler authenticationFailureHandler;

  @Autowired
  private CustomAuthenticationProvider customAuthenticationProvider;

  @Autowired
  private DebugModeAuthentication debugModeAuthentication;

  @Override
  protected void configure(final HttpSecurity http) throws Exception {

    if (debugModeAuthentication.isDebugLoginEnabled()) {
      http.authorizeRequests().antMatchers("/**").permitAll();

    }
    else {
      http.authorizeRequests()
          .antMatchers("/images/*")
          .permitAll()
          .antMatchers("/js/*")
          .permitAll()
          .antMatchers("/css/*")
          .permitAll()
          .antMatchers("/angular/*")
          .permitAll()
          .antMatchers("/fonts/*")
          .permitAll()
          .antMatchers(LOGIN_URL)
          .permitAll()
          .antMatchers("/mdm/common/admin/health")
          .permitAll()
          .antMatchers("/customers/data/save")
          .hasAnyRole("ADMIN", "DATASTEWARD")
          .antMatchers("/customers/*")
          .hasAnyRole("ADMIN", "VIEW", "USER", "DATASTEWARD")
          .antMatchers("/user/*")
          .hasAnyRole("ADMIN", "VIEW", "USER", "DATASTEWARD")
          .antMatchers("/ds/*")
          .hasAnyRole("ADMIN", "DATASTEWARD")
          .antMatchers("/settings/*")
          .hasAnyRole("ADMIN")
          .antMatchers("/admin/*")
          .hasAnyRole("ADMIN")
          .antMatchers("/**")
          .authenticated();

      http.exceptionHandling().accessDeniedPage("/noaccess");

    }

    http.csrf().disable();

    http
        .formLogin()
        .loginPage(LOGIN_URL)
        .permitAll()
        .defaultSuccessUrl("/")
        .usernameParameter(USERNAME_FIELD_NAME)
        .passwordParameter(PASSWORD_FIELD_NAME)
        .successHandler(uiAuthenticationSuccessHandler)
        .failureHandler(authenticationFailureHandler)
        .permitAll();

    http
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/");

  }

  @Override
  @Bean
  public AuthenticationManager authenticationManager() throws Exception {
    final AuthenticationManager authenticationManager = new ProviderManager(Arrays.asList(customAuthenticationProvider));
    return authenticationManager;
  }

}
