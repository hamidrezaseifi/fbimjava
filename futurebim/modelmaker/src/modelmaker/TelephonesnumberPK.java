package modelmaker;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the telephonesnumbers database table.
 * 
 */
@Embeddable
public class TelephonesnumberPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int ownerid;

	@Column(name="owner_type")
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