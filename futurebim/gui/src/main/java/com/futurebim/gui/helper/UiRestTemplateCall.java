package com.futurebim.gui.helper;

import java.io.IOException;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.futurebim.common.model.enums.EModule;
import com.futurebim.common.model.reponse.FBRestResponse;
import com.futurebim.gui.exception.UiCustomizedException;

@Component
public class UiRestTemplateCall implements IUiRestTemplateCall {
  
  @Autowired
  private MessagesHelper messages;
  
  @Autowired
  private RestTemplate restTemplate;
  
  @Autowired
  private MappingJackson2XmlHttpMessageConverter converter;
  
  @Override
  public <I, O> O callRestPost(final URI uri, final EModule service, final I edo, final Class<O> responseClass, final boolean throwError) throws UiCustomizedException {
    
    try {

      if (responseClass.equals(Void.class)) {
        restTemplate.postForObject(uri, edo, responseClass);
        return null;
      }
      else {
        return restTemplate.postForObject(uri, edo, responseClass);
      }
      
    }
    catch (final RestClientResponseException e) {
      if (!throwError) {
        return null;
      }
      final String resp = e.getResponseBodyAsString();
      
      FBRestResponse response = null;
      try {
        response = converter.getObjectMapper().readValue(resp, FBRestResponse.class);
      }
      catch (final IOException e1) {
        
      }
      
      throw new UiCustomizedException(response.getErrorType(), response.getMessage(), service.getModuleName());
    }
    catch (final RestClientException e) {
      if (!throwError) {
        return null;
      }
      throw new UiCustomizedException(messages.get("error.invalidservicestatusorurl", service.getModuleName(), uri), FBRestResponse.stackListToString(e.getStackTrace()), EModule.GUI.getModuleName());
    }
  }
  
  @Override
  public <I, O> O callRestPost(final String url, final EModule service, final I edo, final Class<O> response, final boolean throwError) throws UiCustomizedException {
    
    if (response.equals(Void.class)) {
      callRestPost(URI.create(url), service, edo, response, throwError);
      return null;
    }
    else {
      return callRestPost(URI.create(url), service, edo, response, throwError);
    }
  }
  
  @Override
  public <O> O callRestGet(final String url, final EModule service, final Class<O> responseClass, final boolean throwError, final Object... args) throws UiCustomizedException {
    try {

      if (responseClass.equals(Void.class)) {
        restTemplate.getForObject(url, responseClass, args);
        return null;
      }
      else {
        return restTemplate.getForObject(url, responseClass, args);
      }
      
    }
    catch (final RestClientResponseException e) {
      if (!throwError) {
        return null;
      }
      final String resp = e.getResponseBodyAsString();
      
      FBRestResponse response = null;
      try {
        response = converter.getObjectMapper().readValue(resp, FBRestResponse.class);
      }
      catch (final IOException e1) {
        
      }
      
      throw new UiCustomizedException(response.getErrorType(), response.getMessage(), service.getModuleName());
    }
    catch (final RestClientException e) {
      if (!throwError) {
        return null;
      }
      String propUrl = url;
      if (exceptionHasUrl(e)) {
        propUrl = retreiveUrlFromError(e, url);
      }
      
      throw new UiCustomizedException(messages.get("error.invalidservicestatusorurl", service.getModuleName(), propUrl), FBRestResponse.stackListToString(e.getStackTrace()), EModule.GUI.getModuleName());
    }
  }
  
  @Override
  public <O> O callRestGet(final URI uri, final EModule service, final Class<O> responseClass, final boolean throwError, final Object... args) throws UiCustomizedException {
    
    if (responseClass.equals(Void.class)) {
      callRestGet(uri.toString(), service, responseClass, throwError, args);
      return null;
    }
    else {
      return callRestGet(uri.toString(), service, responseClass, throwError, args);
    }

  }
  
  private boolean exceptionHasUrl(final RestClientException e) {
    return e.getMessage().trim().startsWith("I/O error") && e.getMessage().contains("\"http:");
  }
  
  private String retreiveUrlFromError(final RestClientException e, final String defaultUrl) {
    String propUrl = defaultUrl;
    try {
      final int idx = e.getMessage().indexOf("\"http:");
      propUrl = e.getMessage().substring(idx, e.getMessage().indexOf("\"", idx + 5) + 1);
    }
    catch (final Exception ex) {
      
    }
    return propUrl;
  }
  
  @Override
  public <O> O callRestGet(final String url, final EModule service, final ParameterizedTypeReference<O> responseType, final boolean throwError, final Object... args) throws UiCustomizedException {
    try {
      
      final ResponseEntity<O> response = restTemplate.exchange(url, HttpMethod.GET, null, responseType, args);
      return response.getBody();
      
    }
    catch (final RestClientResponseException e) {
      if (!throwError) {
        return null;
      }
      final String resp = e.getResponseBodyAsString();
      
      FBRestResponse response = null;
      try {
        response = converter.getObjectMapper().readValue(resp, FBRestResponse.class);
      }
      catch (final IOException e1) {
        
      }
      
      throw new UiCustomizedException(response.getErrorType(), response.getMessage(), service.getModuleName());
    }
    catch (final RestClientException e) {
      if (!throwError) {
        return null;
      }
      String propUrl = url;
      if (exceptionHasUrl(e)) {
        propUrl = retreiveUrlFromError(e, url);
      }
      
      throw new UiCustomizedException(messages.get("error.invalidservicestatusorurl", service.getModuleName(), propUrl), FBRestResponse.stackListToString(e.getStackTrace()), EModule.GUI.getModuleName());
    }
  }
  
  @Override
  public <I, O> O callRestPost(final String url, final EModule service, final I edo, final ParameterizedTypeReference<O> responseType, final boolean throwError) throws UiCustomizedException {
    try {
      
      final HttpEntity<I>     request  = new HttpEntity<>(edo);
      final ResponseEntity<O> response = restTemplate.exchange(url, HttpMethod.POST, request, responseType);
      return response.getBody();
      
    }
    catch (final RestClientResponseException e) {
      if (!throwError) {
        return null;
      }
      final String resp = e.getResponseBodyAsString();
      
      FBRestResponse response = null;
      try {
        response = converter.getObjectMapper().readValue(resp, FBRestResponse.class);
      }
      catch (final IOException e1) {
        
      }
      
      throw new UiCustomizedException(response.getErrorType(), response.getMessage(), service.getModuleName());
    }
    catch (final RestClientException e) {
      if (!throwError) {
        return null;
      }
      String propUrl = url;
      if (exceptionHasUrl(e)) {
        propUrl = retreiveUrlFromError(e, url);
      }
      
      throw new UiCustomizedException(messages.get("error.invalidservicestatusorurl", service.getModuleName(), propUrl), FBRestResponse.stackListToString(e.getStackTrace()), EModule.GUI.getModuleName());
    }
  }
  
  @Override
  public <I, O> O callRestPost(final URI url, final EModule service, final I edo, final ParameterizedTypeReference<O> responseType, final boolean throwError) throws UiCustomizedException {
    return callRestPost(url, service, edo, responseType, throwError);
  }
}
