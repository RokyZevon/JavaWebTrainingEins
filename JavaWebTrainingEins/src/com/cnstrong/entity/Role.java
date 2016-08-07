package com.cnstrong.entity;

import java.io.Serializable;

public class Role implements Serializable{
	private int id;
	private String rolename;
	private String desc1;
	private String checked;
	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public Role()
	{
		super();
	}
	
	public Role(int id, String role, String desc1,String checked) {
		super();
		this.id = id;
		this.rolename = role;
		this.desc1 = desc1;
		this.checked = checked;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getDesc1() {
		return desc1;
	}
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}
	
}
