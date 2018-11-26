package com.featurebim.core.dao.exceptions;

public class StorageException extends Exception {

  private static final long serialVersionUID = 1L;

  public StorageException(final String message) {
    super(message);
  }

  public StorageException(final String message, final Exception causedby) {
    super(message, causedby);
  }
}
