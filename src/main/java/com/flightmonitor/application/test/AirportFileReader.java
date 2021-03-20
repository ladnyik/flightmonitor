package com.flightmonitor.application.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class AirportFileReader {

	public static void main(String[] args) {
		try {
			int line = 0;
			Properties props = new Properties();
			File f = new File("/home/ladnyik/opensky/airport-codes_csv.csv");

			//BufferedReader b = new BufferedReader(new FileReader(f));
			BufferedReader b = new BufferedReader(
					new InputStreamReader(new FileInputStream(f), "UTF-8"));

			String readLine = "";

			System.out.println("Reading file using Buffered Reader");
			boolean first = true;
			while ((readLine = b.readLine()) != null) {		
				if (first)
					first = false;
				else {
					String[] stuff = readLine.split(",");
					//System.out.println(String.format("%s %s", stuff[0],stuff[2]));
					props.put(stuff[0],stuff[2] + "("+ stuff[5] +", "+ stuff[7] +")");
				}
				line++;
			}
			props.store(new FileOutputStream("/home/ladnyik/opensky/airports.properties"), "store");

			System.out.println(props.size());
			b.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
