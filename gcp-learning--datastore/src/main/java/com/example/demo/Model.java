package com.example.demo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
public class Model {
	
	private String id;
	private String description;
	private Date creationDate;
	private String username;
	private String email;
	private String queryType;
	private List<Map<String,Object>> lastsavedState;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	public List<Map<String, Object>> getLastsavedState() {
		return lastsavedState;
	}
	public void setLastsavedState(List<Map<String, Object>> lastsavedState) {
		this.lastsavedState = lastsavedState;
	}
	
	

}
