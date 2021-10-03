package com.demo.mvc.model;

import java.util.List;

public class Category {
	// form:hidden - hidden value
	Integer id;
	
	String code;
	
	// form:input - textbox
	String name;

	// form:textarea - textarea
	String desc;

	public boolean isNew() {
		return (this.id == null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", code="+code+", name=" + name + ", Description=" + desc + "]" + isNew();
	}

}
