package com.technicalthreads.jsonschema.model;

import java.util.List;

public class Request{
	private String id;
	private String name;
	private String description;
	private List<String> objective;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getObjective() {
		return objective;
	}
	public void setObjective(List<String> objective) {
		this.objective = objective;
	}
	
} 

