package com.huyhuynh.jersey.JerseyTutorial;

import java.util.Arrays;
import java.util.List;

public class StudentRepository {

	List<Student> list;

	public StudentRepository() {
		Student st1 = new Student(1,"Huy",10);
		Student st2 = new Student(2,"Hao",9);
		Student st3 = new Student(3,"Bảo",8);
		list = Arrays.asList(st1,st2,st3);
	}

	public List<Student> getList() {
		return list;
	}

	public void setStudent(Student st) {
		this.list.add(st);
	}
	
	//find with id
	public Student findByID(int id) {
		for(Student s : list) {
			if(s.getId()==id) {
				return s;
			}
		}
		return null;
	}
	
}
