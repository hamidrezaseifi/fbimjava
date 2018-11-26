package com.featurebim.common.model.reponse;

import org.springframework.http.HttpStatus;

public class FeatureBimUiRestResponse {

  private final HttpStatus status;
  private final String     errorType;
  private final String     message;

  public static String NoError = "NoError";

  public FeatureBimUiRestResponse() {
    this.status = HttpStatus.OK;
    this.errorType = NoError;
    this.message = "";

  }

  public FeatureBimUiRestResponse(final HttpStatus status, final String errorType, final String message) {
    this.status = status;
    this.errorType = errorType;
    this.message = message;

  }

  public HttpStatus getStatus() {
    return status;
  }

  public String getErrorType() {
    return errorType;
  }

  public boolean hasError() {
    return !errorType.equals(NoError);
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "ApiErrorResponse{" +
           "status="
           + status
           +
           ", code="
           + errorType
           +
           ", message="
           + message
           +
           '}';
  }
}
