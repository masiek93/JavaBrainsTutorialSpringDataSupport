package com.topyfi.javabrains.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.topyfi.javabrains.model.Circle;

@Component
public class JdbcDaoImpl {
/*	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/javabase";

	static String username = "java";
	static String password = "password";*/

	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	public Circle getCircle(int circleId) {
		Connection conn = null;

		try {
			

			conn = dataSource.getConnection();

			System.out.println("Connected to database on port 3306");

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
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}

		}

	}
	
	public int getCircleCount(){
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		jdbcTemplate.setDataSource(getDataSource());
		jdbcTemplate.queryForObject(sql, Integer);
		
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
