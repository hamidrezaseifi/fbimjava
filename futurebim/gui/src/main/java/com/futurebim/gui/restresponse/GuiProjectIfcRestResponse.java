package com.futurebim.gui.restresponse;

import org.springframework.http.HttpStatus;

import com.futurebim.common.model.reponse.FutureBimUiRestResponse;
import com.futurebim.gui.model.futurebim.ifc.GuiProjectIfc;

public class GuiProjectIfcRestResponse extends FutureBimUiRestResponse {

  private GuiProjectIfc projectIfc;

  public GuiProjectIfcRestResponse() {
    super();
  }

  private GuiProjectIfcRestResponse(final GuiProjectIfc projectIfc) {
    super();
    this.projectIfc = projectIfc;
  }

  public static GuiProjectIfcRestResponse createError(final HttpStatus status, final Exception ex) {
    return (GuiProjectIfcRestResponse) new FutureBimUiRestResponse(status, ex.getClass().getName(), ex.getMessage());
  }

  public static GuiProjectIfcRestResponse createData(final GuiProjectIfc projectIfc) {
    return new GuiProjectIfcRestResponse(projectIfc);
  }

  public GuiProjectIfc getProjectIfc() {
    return projectIfc;
  }

  public void setProjectIfc(final GuiProjectIfc projectIfc) {
    this.projectIfc = projectIfc;
  }

}
