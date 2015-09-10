package com.topyfi.javabrains.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.topyfi.javabrains.model.Circle;

public class JdbcDaoImpl {

	public Circle getCircle(int circleId) {
		Connection conn = null;

		try {
			String driver = "org.apache.tomcat.jdbc.pool"; // i dont know which
															// driver should i
															// use

			Class.forName(driver).newInstance();

			conn = DriverManager
					.getConnection("jdbc:tomcat://localhost:8090//db");
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
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		finally{
			try{
				conn.close();
			} catch(SQLException e){}
			
			
		}
		
	}
}
