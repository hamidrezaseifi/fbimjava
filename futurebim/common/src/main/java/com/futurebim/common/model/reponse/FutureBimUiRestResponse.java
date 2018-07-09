package com.futurebim.common.model.reponse;

import org.springframework.http.HttpStatus;

public class FutureBimUiRestResponse {

  private final HttpStatus status;
  private final String     errorType;
  private final String     message;

  public static String NoError = "NoError";

  protected FutureBimUiRestResponse() {
    this.status = HttpStatus.OK;
    this.errorType = NoError;
    this.message = "";

  }

  protected FutureBimUiRestResponse(final HttpStatus status, final String errorType, final String message) {
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
