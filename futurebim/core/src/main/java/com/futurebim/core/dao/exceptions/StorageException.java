package com.futurebim.core.dao.exceptions;

import javax.validation.ValidationException;

public class StorageException extends ValidationException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public StorageException(final String message) {
    super(message);
  }

  public StorageException(final String message, final Exception causedby) {
    super(message, causedby);
  }
}
