package com.ado.model;

import javax.persistence.EntityManager;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;
import javax.persistence.Table; 

@Entity
@Table(name = "entity")
public class Home {
	
	@Id
	private int id;
	
	private String name;
	private String info;
	private String pic;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
		
	}

}
