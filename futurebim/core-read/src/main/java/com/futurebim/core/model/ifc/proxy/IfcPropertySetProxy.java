package com.futurebim.core.model.ifc.proxy;

public class IfcPropertySetProxy {

  private String href;

  public String getPropertyId() {
    String pid = href;
    if (pid.startsWith("#")) {
      pid = pid.substring(1);
    }
    return pid;
  }

  public String getHref() {
    return href;
  }

  public void setHref(final String href) {
    this.href = href;
  }

}
