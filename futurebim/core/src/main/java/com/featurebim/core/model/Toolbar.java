package com.featurebim.core.model;

import com.featurebim.common.model.enums.EStatus;
import com.featurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the toolbars database table.
 *
 */
public class Toolbar extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  private String id;

  private String image;

  private String label;

  private String parent;

  private short pos;

  private EStatus status;

  private String type;

  private String url;

  public Toolbar() {
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getImage() {
    return this.image;
  }

  public void setImage(final String image) {
    this.image = image;
  }

  public String getLabel() {
    return this.label;
  }

  public void setLabel(final String label) {
    this.label = label;
  }

  public String getParent() {
    return this.parent;
  }

  public void setParent(final String parent) {
    this.parent = parent;
  }

  public short getPos() {
    return this.pos;
  }

  public void setPos(final short pos) {
    this.pos = pos;
  }

  public EStatus getStatus() {
    return this.status;
  }

  public void setStatus(final Long status) {
    this.status = EStatus.ofId(status);
  }

  public String getType() {
    return this.type;
  }

  public void setType(final String type) {
    this.type = type;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(final String url) {
    this.url = url;
  }

}
