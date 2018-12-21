package com.futurebim.common.exception;

import javax.validation.ValidationException;

public class FbCustomeException extends ValidationException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public FbCustomeException(final String message) {
    super(message);
  }

  public FbCustomeException(final String message, final Exception causedby) {
    super(message, causedby);
  }
}
