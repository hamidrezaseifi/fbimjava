package com.featurebim.core.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataDecryptionFilter implements Filter {
  
  private final Logger log = LoggerFactory.getLogger(DataDecryptionFilter.class);
  
  public DataDecryptionFilter() {
    log.info("------------------------------------------ DataDecryptionFilter: Start");
  }
  
  @Override
  public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
      throws IOException, ServletException {
    
    final HttpServletRequest req = (HttpServletRequest) request;
    final String method = req.getMethod();
    final String contentType = req.getContentType();
    final int len = req.getContentLength();
    
    log.info("----- DataDecryptionFilter: " + req.getRequestURI() + ", " + method + ", " + contentType);
    
    chain.doFilter(request, response);
  }
  
  @Override
  public void init(final FilterConfig filterConfig) throws ServletException {
    log.info("------------------------------------------ DataDecryptionFilter: init");
  }
  
  @Override
  public void destroy() {
    log.info("------------------------------------------ DataDecryptionFilter: destroy");
  }
  
}
