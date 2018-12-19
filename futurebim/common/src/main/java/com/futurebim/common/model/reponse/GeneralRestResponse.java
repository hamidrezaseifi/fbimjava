package com.futurebim.common.model.reponse;

import org.springframework.http.HttpStatus;

public class GeneralRestResponse extends FBUiRestResponse {

  private Object data = null;

  public GeneralRestResponse() {
    super();
  }

  private GeneralRestResponse(final Object data) {
    super();
    this.data = data;
  }

  public static GeneralRestResponse createError(final HttpStatus status, final Exception ex) {
    return (GeneralRestResponse) new FBUiRestResponse(status, ex.getClass().getName(), ex.getMessage());
  }

  public static GeneralRestResponse createData(final Object data) {
    return new GeneralRestResponse(data);
  }

  public Object getData() {
    return data;
  }

  public void setdata(final Object projects) {
    this.data = projects;
  }

}
