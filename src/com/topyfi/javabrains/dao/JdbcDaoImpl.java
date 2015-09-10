package com.topyfi.javabrains.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.topyfi.javabrains.model.Circle;

@Component
public class JdbcDaoImpl {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/javabase";
	
	static String username = "java";
	static String password = "password";

	public static void connect() {
		Connection conn = null;

		try {
			Class.forName(DRIVER).newInstance();

			conn = DriverManager
					.getConnection(DB_URL, username, password);
			
			PreparedStatement preparedSt = conn
					.prepareStatement("SELECT * FROM circle where id = ?");
			preparedSt.setInt(1, circleId);

			Circle circle = null;
			ResultSet resultSet = preparedSt.executeQuery();
			if (resultSet.next()) {
				circle = new Circle(circleId, resultSet.getString("name"));
			}
			resultSet.close();
			preparedSt.close();

			return circle;
			
			/*String temp = "First Circle";
			PreparedStatement prepStmt = conn
					.prepareStatement("INSERT INTO circle VALUES (?, ?);");
			prepStmt.setInt(1, 1);
			prepStmt.setString(2, temp);
			prepStmt.execute();
			prepStmt.close();
			*/
			System.out.println("Connected to database on port 3306");
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		try{
			conn.close();
		} catch(SQLException e){}
			
	}
}
