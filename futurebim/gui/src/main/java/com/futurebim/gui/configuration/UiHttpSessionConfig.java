package com.futurebim.gui.configuration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UiHttpSessionConfig {

  @Value("${server.session.timeout}")
  private int sessionTimeOut;

  @Bean // bean for http session listener
  public HttpSessionListener httpSessionListener() {
    return new HttpSessionListener() {

      @Override
      public void sessionCreated(final HttpSessionEvent event) {
        event.getSession().setMaxInactiveInterval(sessionTimeOut);
      }

      @Override
      public void sessionDestroyed(final HttpSessionEvent se) {

      }
    };
  }

}
