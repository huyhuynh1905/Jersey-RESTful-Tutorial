package com.huyhuynh.jersey.JerseyTutorial;

import javax.xml.bind.annotation.XmlRootElement;

//Để định dạng kiểu trả về cho Class này
@XmlRootElement
public class Student {
	
	private int id;
	private String name;
	private int point;
	
	
	public Student() {
		super();
		this.id = 0;
		this.name = "";
		this.point = 0;
	}
	public Student(int id, String name, int point) {
		super();
		this.id = id;
		this.name = name;
		this.point = point;
	}
	
	
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
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	

}
