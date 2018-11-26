package com.featurebim.core.model;

import java.io.Serializable;

import com.featurebim.core.model.base.SerializableModelBase;

/**
 * The primary key class for the telephonesnumbers database table.
 * 
 */
public class TelephonesnumberPK extends SerializableModelBase {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int ownerid;

	private String ownerType;

	public TelephonesnumberPK() {
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
		if (!(other instanceof TelephonesnumberPK)) {
			return false;
		}
		TelephonesnumberPK castOther = (TelephonesnumberPK)other;
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