package com.whh.model;

public class Menu {

	private int id;
	private String text;
	private boolean leaf;
	private int parentId;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", text=" + text + ", leaf=" + leaf
				+ ", parentId=" + parentId + "]";
	}
}
