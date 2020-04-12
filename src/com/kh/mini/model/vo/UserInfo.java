package com.kh.mini.model.vo;

import java.io.Serializable;

public class UserInfo implements Serializable{
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private String Key;
	
	public UserInfo() {}
	
	public UserInfo(String id, String pw, String name, String email, String key) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.Key = key;
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
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}


	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", Key=" + Key + "]";
	}

	
	
	
	
	
}
