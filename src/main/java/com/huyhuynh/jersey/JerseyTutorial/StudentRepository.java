package com.huyhuynh.jersey.JerseyTutorial;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.crypto.provider.RSACipher;

public class StudentRepository {

	
	Connection conn = null;

	public StudentRepository() {
		
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*list = new ArrayList<Student>();
		Student st1 = new Student(1,"Huy",10);
		Student st2 = new Student(2,"Hao",9);
		Student st3 = new Student(3,"Bảo",8);
		list.add(st1);
		list.add(st2);
		list.add(st3);*/
		
	}

	public List<Student> getList() {
		List<Student> list = new ArrayList<Student>();
		String query = "select * from jersey";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2).trim());
				student.setPoint(rs.getInt(3));
				list.add(student);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public void setStudent(Student st) {
		String query = "insert into jersey values (?,?,?)";
		try {
			PreparedStatement pr = conn.prepareStatement(query);
			pr.setInt(1, st.getId());
			pr.setString(2, st.getName());
			pr.setInt(3, st.getPoint());
			pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//find with id
	public Student findByID(int id) {
		String query = "select * from jersey where id="+id;
		Student student = new Student();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2).trim());
				student.setPoint(rs.getInt(3));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
	
}
