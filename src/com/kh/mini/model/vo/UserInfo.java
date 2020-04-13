package com.kh.mini.model.vo;

import java.io.Serializable;

public class UserInfo implements Serializable{
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private String key;
	private int point;
	
	public UserInfo() {}
	
	public UserInfo(String id, String pw, String name, String email, String key, int point) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.key = key;
		this.point = point;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}


	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", key=" + key + ", point=" + point +"]";
	}

	
	
	
	
	
}
