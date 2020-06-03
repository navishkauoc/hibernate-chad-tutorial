package com.navishka.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestUrl {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3307/web_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "webstudent";
		String pass = "webstudent";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!");
		} catch(Exception exc) {
			exc.printStackTrace();
		}

	}

}
