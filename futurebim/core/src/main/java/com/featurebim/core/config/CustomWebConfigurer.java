package com.featurebim.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomWebConfigurer {
  
  private final Logger log = LoggerFactory.getLogger(CustomWebConfigurer.class);
  
  /*
   * @Override protected void configure(final HttpSecurity http) throws Exception {
   * log.debug("------------------------------------------ config web: Start"); // http.addFilterBefore(new DataDecryptionFilter(),
   * BasicAuthenticationFilter.class).authorizeRequests().antMatchers("/*").permitAll(); }
   */
  
  @Bean
  public FilterRegistrationBean<DataDecryptionFilter> someFilterRegistration() {

    final FilterRegistrationBean<DataDecryptionFilter> registration = new FilterRegistrationBean<>();
    registration.setFilter(new DataDecryptionFilter());
    registration.addUrlPatterns("/*");
    // registration.addInitParameter("paramName", "paramValue");
    registration.setName("dataDecryptionFilter");
    registration.setOrder(1);
    return registration;
  }
}
