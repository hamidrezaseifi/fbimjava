package com.futurebim.common.model.enums;

public enum ETaskStatus {
	IDLE(0), ACTIVE(1), FINISH(2), DEACTIVE(3);

	private int dbValue;

	ETaskStatus(final int dbval) {
		this.dbValue = dbval;
	}

	/**
	 * @return the dbValue
	 */
	public int getDbValue() {
		return dbValue;
	}

	public static ETaskStatus fromDbValue(final int val) {
		for (final ETaskStatus status : values()) {
			if (status.getDbValue() == val) {
				return status;
			}
		}

		return ETaskStatus.IDLE;
	}
}
