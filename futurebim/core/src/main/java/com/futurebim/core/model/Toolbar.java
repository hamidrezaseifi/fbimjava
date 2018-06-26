package com.futurebim.core.model;

import java.io.Serializable;

import com.futurebim.core.model.base.SerializableModelBase;
import com.futurebim.common.model.enums.EStatus;
import com.futurebim.common.model.enums.base.UnknownEnumValueException1;


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

	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getParent() {
		return this.parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public short getPos() {
		return this.pos;
	}

	public void setPos(short pos) {
		this.pos = pos;
	}

	public EStatus getStatus() {
		return this.status;
	}

	public void setStatus(Long status) throws UnknownEnumValueException1 {
		this.status = EStatus.ofId(status);
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}