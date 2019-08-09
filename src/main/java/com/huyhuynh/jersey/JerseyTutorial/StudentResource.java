package com.huyhuynh.jersey.JerseyTutorial;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("student")
public class StudentResource {

	@GET
	@Produces(MediaType.APPLICATION_XML) //Cầu hình dòng này trả đối tượng về xml
	public Student getXMLStudent() {
		Student st1 = new Student("Huy",10);
		return st1;
	}
}
