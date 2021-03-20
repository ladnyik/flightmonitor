package com.flightmonitor.application.test;

public class TestSring {

	public static void main(String[] args) {
		
		String replaced = "https:\\/\\/cdn.jetphotos.com\\/200\\/5\\/62398_1583819236_tb.jpg?v=0" ;
		System.out.println(replaced);
		System.out.println(replaced.replaceAll("\\\\", ""));

	}

}
