package com.featurebim.common.model.enums;

import com.featurebim.common.model.enums.base.IValueList;

public enum EStatus implements IValueList {
	  Unknown(0L, "status.unknown"),
	  Active(1L, "status.active"),
	  Deactive(2L, "status.deactive"),
	  Deleted(3L, "status.deleted");

	  private final Long   dbId;
	  private final String sourceSystemName;

	  EStatus(final Long dbId, final String sourceSystemName) {
	    this.dbId = dbId;
	    this.sourceSystemName = sourceSystemName;
	  }

	  /**
	   * @return the dbId
	   */
	  @Override
	  public Long getDbId() {
	    return dbId;
	  }

	  /**
	   * @return the sourceSystemName
	   */
	  @Override
	  public String getValueName() {
	    return this.sourceSystemName;
	  }
	  
	  public static EStatus ofId(final Long statusId) {
  		if (Active.dbId.equals(statusId)) {
  		  return EStatus.Active;
  		}
  		else if (Deactive.dbId.equals(statusId)) {
  		      return EStatus.Deactive;
  		    }
  		else if (Deleted.dbId.equals(statusId)) {
  		      return EStatus.Deleted;
  		    }
  		//throw new UnknownEnumValueException(String.format("The status id %d is not defined for enum EStatus.", statusId));
  		return EStatus.Unknown;
	  }

}
