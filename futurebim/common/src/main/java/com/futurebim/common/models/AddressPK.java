package com.futurebim.common.models;

import java.io.Serializable;

/**
 * The primary key class for the addresses database table.
 * 
 */
public class AddressPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private int ownerid;

	private String ownerType;

	public AddressPK() {
	}
	public int getOwnerid() {
		return this.ownerid;
	}
	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}
	public String getOwnerType() {
		return this.ownerType;
	}
	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AddressPK)) {
			return false;
		}
		AddressPK castOther = (AddressPK)other;
		return 
			(this.ownerid == castOther.ownerid)
			&& this.ownerType.equals(castOther.ownerType);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ownerid;
		hash = hash * prime + this.ownerType.hashCode();
		
		return hash;
	}
}