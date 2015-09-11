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
		
		Circle circle = dao.getCircle(1);
		System.out.println(circle.getName());
		System.out.println(dao.getCircleCount());

	}

}
