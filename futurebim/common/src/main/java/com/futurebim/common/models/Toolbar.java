package com.futurebim.common.models;

import java.io.Serializable;


/**
 * The persistent class for the toolbars database table.
 * 
 */
public class Toolbar implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String image;

	private String label;

	private String parent;

	private short pos;

	private short status;

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

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
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