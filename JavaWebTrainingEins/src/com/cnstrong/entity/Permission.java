package com.cnstrong.entity;

import java.io.Serializable;

public class Permission implements Serializable{
	private int id;
	private String permission;
	private String url;
	private String desc1;
	private String checked;
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public Permission()
	{
		super();
	}
	public Permission(int id, String permission, String url, String desc1,String checked) {
		super();
		this.id = id;
		this.permission = permission;
		this.url = url;
		this.desc1 = desc1;
		this.checked = checked;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDesc1() {
		return desc1;
	}
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}
	
}
