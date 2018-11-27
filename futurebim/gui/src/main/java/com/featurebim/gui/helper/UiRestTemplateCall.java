package com.featurebim.gui.helper;

import java.io.IOException;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.featurebim.common.model.enums.EModule;
import com.featurebim.common.model.reponse.FBUiRestResponse;
import com.featurebim.gui.exception.UiCustomizedException;

@Component
public class UiRestTemplateCall implements IUiRestTemplateCall {

  @Autowired
  private MessagesHelper messages;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter converter;

  @Override
  public <I, O> O callRestPost(final URI uri,
                               final EModule service,
                               final I edo,
                               final Class<O> responseClass,
                               final boolean throwError) throws UiCustomizedException {

    try {
      return restTemplate.postForObject(uri, edo, responseClass);

    }
    catch (final RestClientResponseException e) {
      if (!throwError) {
        return null;
      }
      final String resp = e.getResponseBodyAsString();

      FBUiRestResponse response = null;
      try {
        response = converter.getObjectMapper().readValue(resp, FBUiRestResponse.class);
      }
      catch (final IOException e1) {

      }

      throw new UiCustomizedException(response.getErrorType(), response.getMessage(), service.getModuleName());
    }
    catch (final RestClientException e) {
      if (!throwError) {
        return null;
      }
      throw new UiCustomizedException(messages.get("error.invalidservicestatusorurl", service.getModuleName(), uri),
                                      FBUiRestResponse.stackListToString(e.getStackTrace()),
                                      EModule.GUI.getModuleName());
    }
  }

  @Override
  public <I, O> O callRestPost(final String url,
                               final EModule service,
                               final I edo,
                               final Class<O> response,
                               final boolean throwError) throws UiCustomizedException {

    return callRestPost(URI.create(url), service, edo, response, throwError);
  }

  @Override
  public <I, O> O callRestGet(final String url,
                              final EModule service,
                              final Class<O> responseClass,
                              final boolean throwError,
                              final Object... args) throws UiCustomizedException {
    try {
      return restTemplate.getForObject(url, responseClass, args);

    }
    catch (final RestClientResponseException e) {
      if (!throwError) {
        return null;
      }
      final String resp = e.getResponseBodyAsString();

      FBUiRestResponse response = null;
      try {
        response = converter.getObjectMapper().readValue(resp, FBUiRestResponse.class);
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

      throw new UiCustomizedException(messages.get("error.invalidservicestatusorurl", service.getModuleName(), propUrl),
                                      FBUiRestResponse.stackListToString(e.getStackTrace()),
                                      EModule.GUI.getModuleName());
    }
  }

  @Override
  public <I, O> O callRestGet(final URI uri,
                              final EModule service,
                              final Class<O> responseClass,
                              final boolean throwError,
                              final Object... args) throws UiCustomizedException {

    return callRestGet(uri.toString(), service, responseClass, throwError, args);
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
}
