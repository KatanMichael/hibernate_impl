package com.max.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&";
		
		// ssl = false is to get rid of mySQL ssl warnings
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("connecting to database: "+jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connections successful!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
