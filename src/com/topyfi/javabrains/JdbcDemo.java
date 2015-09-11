package com.topyfi.javabrains;


import java.sql.Connection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.topyfi.javabrains.dao.JdbcDaoImpl;
import com.topyfi.javabrains.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		
		//System.out.println(dao.getCircleName(1));
		//dao.insertCircleNamed(new Circle(5,"Fifth Circle"));
		System.out.println(dao.getCircleById(5).getName());
		System.out.println(dao.getAllCircles().size());
		//dao.createTriangleTable();
	}

}
