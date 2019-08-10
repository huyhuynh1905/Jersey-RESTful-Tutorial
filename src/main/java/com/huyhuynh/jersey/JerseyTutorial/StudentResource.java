package com.huyhuynh.jersey.JerseyTutorial;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@Path("student")
public class StudentResource {

	//Trả về 1 đối tượng dưới dạng xml
	@GET
	@Path("/objectxml")
	@Produces(MediaType.APPLICATION_XML) //Cầu hình dòng này trả đối tượng về xml
	public Student getXMLStudent() {
		Student st1 = new Student(1,"Huy",10);
		return st1;
	}
	
	//Trả vể đối tượng dạng list với xml
	@GET
	@Path("/listobjectxml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Student> getListXMLStudent(){
		Student st1 = new Student(1,"Huy",10);
		Student st2 = new Student(2,"Hao",9);
		Student st3 = new Student(3,"Bảo",8);
		List<Student> students = Arrays.asList(st1,st2,st3);
		return students;
	}
	
	//Sử dụng mock repository(class StudentRepository) để khởi tạo trước list
	StudentRepository repo = new StudentRepository();
	@GET
	@Path("/repolistxml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Student> getListXMLStudentRepo(){
		System.out.println("getCall");
		return repo.getList();
	}
	
	//Thêm một đối tượng vào list
	@POST
	@Path("/addobjbyxml")
	public Student addStudentXml(Student st) {
		repo.setStudent(st);
		System.out.println("thêm thành công");
		return st;
	}
	//find student by id
	
	@GET
	@Path("/findbyid/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Student findStudent(@PathParam("id") int id) {
		System.out.println("find");
		return repo.findByID(id);
	}
	
	//Trả về đối tượng json và xml
	@GET
	@Path("/repogetlist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getListStudentRepo(){
		System.out.println("getCall");
		return repo.getList();
	}
	
	//update bằng put
	@PUT
	@Path("/updatestudent")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Student updateStu(Student student) {
		if(repo.findByID(student.getId())==null) {
			repo.setStudent(student);
		} else {
			repo.updateStudent(student);
		}
		return student;
	}
	
}
