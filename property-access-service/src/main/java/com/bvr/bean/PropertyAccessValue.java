package com.bvr.bean;

public class PropertyAccessValue {

	public PropertyAccessValue() {
		// TODO Auto-generated constructor stub
	}
	
	private String name;
	private String description;
	
	
	public PropertyAccessValue(String name, String descrip) {
		super();
		this.name = name;
		this.description = descrip;
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


	@Override
	public String toString() {
		return "PropertyAccessValue [name=" + name + ", description=" + description + "]";
	}
	
	

}
