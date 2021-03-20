package com.flightmonitor.application.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProp {

	public static void main(String[] args) throws IOException {
		
		InputStream input = TestProp.class.getClassLoader().getResourceAsStream("airports.properties");
		Properties prop = new Properties();
		prop.load(input);
		System.out.println(prop);

	}

}
