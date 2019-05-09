
package com.futurebim.gui.configuration;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.futurebim.gui.authentication.FBUiAuthenticationDetails;
import com.futurebim.gui.authentication.UiAuthenticationFailureHandler;
import com.futurebim.gui.authentication.UiAuthenticationSuccessHandler;
import com.futurebim.gui.authentication.provider.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  
  public static final String USERNAME_FIELD_NAME         = "username";
  public static final String PASSWORD_FIELD_NAME         = "password";
  public static final String COMPANYID_FIELD_NAME        = "companyid";
  public static final String LOGIN_URL                   = "/auth/login";
  public static final String INITUSER_URL                = "/activation/user";
  public static final String INITCOMPANY_URL             = "/activation/company";
  public static final String ROOT_URL                    = "/";
  public static final String COMPANYINDICATOR_COOKIE_KEY = "comp_ind";
  
  @Autowired
  private UiAuthenticationSuccessHandler uiAuthenticationSuccessHandler;
  
  @Autowired
  private UiAuthenticationFailureHandler authenticationFailureHandler;
  
  @Autowired
  private CustomAuthenticationProvider customAuthenticationProvider;
  
  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    
    http.authorizeRequests().antMatchers("/images/*").permitAll().antMatchers("/js/*").permitAll()
        .antMatchers("/css/*").permitAll().antMatchers("/angular/*").permitAll().antMatchers("/fonts/*")
        .permitAll().antMatchers(LOGIN_URL).permitAll()
        .antMatchers("/admin/**")
        .hasAnyRole("ADMIN", "COMPANY_ADMIN")
        .antMatchers("/admin/user/**", "/admin/data/**", "/admin/data/user/**")
        .hasAnyRole("ADMIN", "COMPANY_ADMIN")
        .antMatchers("/**").authenticated().and();
    
    http.exceptionHandling().accessDeniedPage("/noaccess");
    
    http.csrf().disable();
    
    http.formLogin().authenticationDetailsSource(authenticationDetailsSource()).loginPage(LOGIN_URL).permitAll()
        .defaultSuccessUrl("/").usernameParameter(USERNAME_FIELD_NAME).passwordParameter(PASSWORD_FIELD_NAME)
        .successHandler(uiAuthenticationSuccessHandler).failureHandler(authenticationFailureHandler)
        .permitAll();
    
    http.logout().logoutUrl("/logout").logoutSuccessUrl("/");
    
  }
  
  private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource() {
    
    return new AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails>() {
      
      @Override
      public WebAuthenticationDetails buildDetails(final HttpServletRequest request) {
        return new FBUiAuthenticationDetails(request);
      }
      
    };
  }
  
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return authenticationManager();
  }
  
  @Override
  @Bean
  public AuthenticationManager authenticationManager() throws Exception {
    final AuthenticationManager authenticationManager = new ProviderManager(
        Arrays.asList(customAuthenticationProvider));
    return authenticationManager;
  }
  
}
