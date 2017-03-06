package com.dcmomis.common;

public class TreeNodeBean {
	private String id;
	private String text;
	private boolean expanded;
	private boolean leaf;
	private TreeNodeBean children;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public TreeNodeBean getChildren() {
		return children;
	}
	public void setChildren(TreeNodeBean children) {
		this.children = children;
	}
	
}
