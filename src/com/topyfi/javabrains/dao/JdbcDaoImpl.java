package com.topyfi.javabrains.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.topyfi.javabrains.model.Circle;

@Component
public class JdbcDaoImpl {
	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite://localhost:8090/database.db";

	public static void connect() {
		Connection conn = null;

		try {
			Class.forName(DRIVER).newInstance();

			conn = DriverManager
					.getConnection(DB_URL);
/*			PreparedStatement preparedSt = conn
					.prepareStatement("SELECT * FROM circle where id = ?");
			preparedSt.setInt(1, circleId);

			Circle circle = null;
			ResultSet resultSet = preparedSt.executeQuery();
			if (resultSet.next()) {
				circle = new Circle(circleId, resultSet.getString("name"));
			}
			resultSet.close();
			preparedSt.close();

			return circle;*/
			System.out.println("Stworzylem baze danych");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		try{
			conn.close();
		} catch(SQLException e){}
			
	}
}
