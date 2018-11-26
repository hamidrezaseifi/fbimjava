package com.featurebim.core.model;

import com.featurebim.core.model.base.SerializableModelBase;

/**
 * The primary key class for the addresses database table.
 *
 */
public class AddressPK extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  private int ownerid;

  private String ownerType;

  public AddressPK() {
  }

  public int getOwnerid() {
    return this.ownerid;
  }

  public void setOwnerid(final int ownerid) {
    this.ownerid = ownerid;
  }

  public String getOwnerType() {
    return this.ownerType;
  }

  public void setOwnerType(final String ownerType) {
    this.ownerType = ownerType;
  }

  @Override
  public boolean equals(final Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof AddressPK)) {
      return false;
    }
    final AddressPK castOther = (AddressPK) other;
    return (this.ownerid == castOther.ownerid)
           && this.ownerType.equals(castOther.ownerType);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int hash = 17;
    hash = hash * prime + this.ownerid;
    hash = hash * prime + this.ownerType.hashCode();

    return hash;
  }
}
