package com.flightmonitor.application.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AircraftFileReader {

	public static void main(String[] args) {
		try {
			int line = 0;
			File f = new File("/home/ladnyik/Letöltések/aircraftDatabase-2021-02.csv");

			BufferedReader b = new BufferedReader(new FileReader(f));

			String readLine = "";

			System.out.println("Reading file using Buffered Reader");

			while ((readLine = b.readLine()) != null) {		
				if (readLine.contains("89409e"))
					System.out.println(readLine);
				line++;
			}
			System.out.println(line);
			b.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
