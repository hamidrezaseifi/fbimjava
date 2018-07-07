package com.futurebim.common.model.reponse;

import org.springframework.http.HttpStatus;

public class FutureBimUiRestResponse {

  private final HttpStatus status;
  private final String     errorType;
  private final String     message;
  private final Object     data;

  public static String NoError = "NoError";

  private FutureBimUiRestResponse(final HttpStatus status, final String errorType, final String message) {
    this.status = status;
    this.errorType = errorType;
    this.message = message;
    this.data = "";
  }

  private FutureBimUiRestResponse(final Object data) {
    this.status = HttpStatus.OK;
    this.errorType = NoError;
    this.message = "";
    this.data = data;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public String getErrorType() {
    return errorType;
  }

  public String getMessage() {
    return message;
  }

  public Object getData() {
    return data;
  }

  public static FutureBimUiRestResponse createDataResponse(final Object data) {
    return new FutureBimUiRestResponse(data);
  }

  public static FutureBimUiRestResponse createError(final HttpStatus status, final Exception ex) {
    return new FutureBimUiRestResponse(status, ex.getClass().getName(), ex.getMessage());
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
