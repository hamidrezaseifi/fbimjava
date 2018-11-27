package com.featurebim.gui.helper;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

/**
 * read message labels from message property file
 *
 * @author rezasei
 *
 */
@Component
public class MessagesHelper {

  @Autowired
  private MessageSource messageSource;

  private MessageSourceAccessor accessor;

  @PostConstruct
  private void init() {
    accessor = new MessageSourceAccessor(messageSource, Locale.GERMAN);
  }

  public String get(final String code) {
    return accessor.getMessage(code);
  }

  public String get(final String code, final Object... args) {
    return String.format(accessor.getMessage(code), args);
  }
}
