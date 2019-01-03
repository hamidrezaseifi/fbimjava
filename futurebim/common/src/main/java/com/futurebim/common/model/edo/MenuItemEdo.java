package com.futurebim.common.model.edo;

import java.util.ArrayList;
import java.util.List;

public class MenuItemEdo {

	private String id;
	private String label;
	private String image;
	private String url;
	private int state;
	private final List<MenuItemEdo> children = new ArrayList<>();

	public MenuItemEdo() {

	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
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
	 * @return the children
	 */
	public List<MenuItemEdo> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(final List<MenuItemEdo> children) {

		this.children.clear();
		if (children != null) {
			this.children.addAll(children);
		}
	}

	/**
	 * @param children the children to set
	 */
	public void addChild(final MenuItemEdo child) {

		this.children.add(child);
	}

}
