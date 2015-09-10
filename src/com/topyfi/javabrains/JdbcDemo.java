package com.topyfi.javabrains;

import com.topyfi.javabrains.dao.JdbcDaoImpl;
import com.topyfi.javabrains.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		Circle circle = new JdbcDaoImpl().getCircle(1);
		System.out.println(circle.getName());

	}

}
