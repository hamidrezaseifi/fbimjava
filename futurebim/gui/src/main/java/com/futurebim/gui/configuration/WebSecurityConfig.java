
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

import com.futurebim.gui.authentication.DebugModeAuthentication;
import com.futurebim.gui.authentication.FBUiAuthenticationDetails;
import com.futurebim.gui.authentication.UiAuthenticationFailureHandler;
import com.futurebim.gui.authentication.UiAuthenticationSuccessHandler;
import com.futurebim.gui.authentication.provider.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  
  public static String USERNAME_FIELD_NAME  = "username";
  public static String PASSWORD_FIELD_NAME  = "password";
  public static String COMPANYID_FIELD_NAME = "companyid";
  public static String LOGIN_URL            = "/auth/login";
  public static String INITUSER_URL         = "/activation/user";
  public static String INITCOMPANY_URL      = "/activation/company";
  public static String ROOT_URL             = "/";
  
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
      http
          .authorizeRequests()
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
          .authenticated()
          .and()
      // .addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
      ;
      
      http.exceptionHandling().accessDeniedPage("/noaccess");
      
    }
    
    http.csrf().disable();
    
    http
        .formLogin()
        .authenticationDetailsSource(authenticationDetailsSource())
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
    final AuthenticationManager authenticationManager = new ProviderManager(Arrays.asList(customAuthenticationProvider));
    return authenticationManager;
  }
  
}
