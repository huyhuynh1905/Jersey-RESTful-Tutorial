package com.huyhuynh.jersey.JerseyTutorial;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@Path("student")
public class StudentResource {

	@GET
	@Path("/objectxml")
	@Produces(MediaType.APPLICATION_XML) //Cầu hình dòng này trả đối tượng về xml
	public Student getXMLStudent() {
		Student st1 = new Student("Huy",10);
		return st1;
	}
	
	@GET
	@Path("/listobjectxml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Student> getListXMLStudent(){
		Student st1 = new Student("Huy",10);
		Student st2 = new Student("Hao",9);
		Student st3 = new Student("Bảo",8);
		List<Student> students = Arrays.asList(st1,st2,st3);
		return students;
	}
}
