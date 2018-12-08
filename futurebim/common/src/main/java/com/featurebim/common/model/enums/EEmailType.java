package com.featurebim.common.model.enums;

public enum EEmailType {
	Private("emailtype-private"), Business("emailtype-business");

	private String label;

	EEmailType(final String label) {
		this.label = label;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(final String label) {
		this.label = label;
	}

}
