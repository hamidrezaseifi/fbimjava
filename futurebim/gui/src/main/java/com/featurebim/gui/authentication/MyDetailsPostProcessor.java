package com.featurebim.gui.authentication;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class MyDetailsPostProcessor implements BeanPostProcessor {

  private String[] formVarNames;
  
  public void setFormVarNames(final String formVarNames) {
    this.formVarNames = formVarNames.split(",");
  }
  
  public static class Details extends WebAuthenticationDetails {
    
    private final Map<String, String> map;
    
    public Details(final HttpServletRequest request, final String[] parameters) {
      super(request);
      
      this.map = new HashMap<>();
      for (final String parameter : parameters) {
        this.map.put(parameter.trim(), request.getParameter(parameter.trim()));
      }
    }
    
    public String get(final String name) {
      return map.get(name);
    }
  }
  
  @Override
  public Object postProcessAfterInitialization(final Object bean, final String name) {
    if (bean instanceof UsernamePasswordAuthenticationFilter) {
      ((UsernamePasswordAuthenticationFilter) bean).setAuthenticationDetailsSource(
          new AuthenticationDetailsSource() {
            
            @Override
            public Object buildDetails(final Object context) {
              
              if (formVarNames == null) {
                throw new RuntimeException(
                    "AuthFormDetailsPostProcessor bean requires a formVarNames property, specifying a comma-delimited list of form vars to provide in the details object.");
              }
              
              return new Details((HttpServletRequest) context, formVarNames);
            }
          });
    }
    return bean;
  }
  
  @Override
  public Object postProcessBeforeInitialization(final Object bean, final String name) {
    return bean;
  }

}
