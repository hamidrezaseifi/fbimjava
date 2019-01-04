package com.futurebim.common.model.edo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.futurebim.common.rest.json.FBLocalDateTimeDeserializer;
import com.futurebim.common.rest.json.FBLocalDateTimeSerializer;

public class SystemMenuItemEdo {

	private String id;
	private String parebtid;
	private String label;
	private String image;
	private String url;
	private int state;
	private int sort;
	private final List<SystemMenuItemEdo> children = new ArrayList<>();

	@JsonSerialize(using = FBLocalDateTimeSerializer.class)
	@JsonDeserialize(using = FBLocalDateTimeDeserializer.class)
	private LocalDateTime created;

	@JsonSerialize(using = FBLocalDateTimeSerializer.class)
	@JsonDeserialize(using = FBLocalDateTimeDeserializer.class)
	private LocalDateTime updated;

	private int version;

	public SystemMenuItemEdo() {

	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * @return the parebtid
	 */
	public String getParebtid() {
		return parebtid;
	}

	/**
	 * @param parebtid the parebtid to set
	 */
	public void setParebtid(final String parebtid) {
		this.parebtid = parebtid;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(final String label) {
		this.label = label;
	}

	public String getImage() {
		return image;
	}

	public void setImage(final String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(final String url) {
		this.url = url;
	}

	public int getState() {
		return state;
	}

	public void setState(final int state) {
		this.state = state;
	}

	/**
	 * @return the sort
	 */
	public int getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(final int sort) {
		this.sort = sort;
	}

	/**
	 * @return the children
	 */
	public List<SystemMenuItemEdo> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(final List<SystemMenuItemEdo> children) {

		this.children.clear();
		if (children != null) {
			this.children.addAll(children);
		}
	}

	/**
	 * @param children the children to set
	 */
	public void addChild(final SystemMenuItemEdo child) {

		this.children.add(child);
	}

	/**
	 * @return the created
	 */
	public LocalDateTime getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(final LocalDateTime created) {
		this.created = created;
	}

	/**
	 * @return the updated
	 */
	public LocalDateTime getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(final LocalDateTime updated) {
		this.updated = updated;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(final int version) {
		this.version = version;
	}

}
