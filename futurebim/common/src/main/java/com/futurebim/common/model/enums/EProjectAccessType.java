package com.futurebim.common.model.enums;

public enum EProjectAccessType {
	NONE(0), ADMIN(1), READWRITE(2), READ(3);

	private int dbValue;

	EProjectAccessType(final int dbval) {
		this.dbValue = dbval;
	}

	/**
	 * @return the dbValue
	 */
	public int getDbValue() {
		return dbValue;
	}

}
