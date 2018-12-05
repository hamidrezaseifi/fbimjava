package com.featurebim.common.exceptions;

import javax.validation.ValidationException;

public class FBCustomizedException extends ValidationException {
  
  private static final long serialVersionUID = 1L;
  private final String      detailes;
  private final String      moduleName;
  
  public FBCustomizedException(final String message, final String detailes, final String moduleName) {
    super(message);
    this.detailes = detailes;
    this.moduleName = moduleName;
  }
  
  public String getDetailes() {
    return detailes;
  }
  
  public String getModuleName() {
    return moduleName;
  }
  
}
