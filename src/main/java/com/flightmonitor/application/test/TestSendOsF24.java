package com.flightmonitor.application.test;

import java.io.IOException;

import javax.mail.MessagingException;

import com.flightmonitor.application.flightutil.FlightUtils;

public class TestSendOsF24 {

	public static void main(String[] args) throws MessagingException, IOException {
		
		FlightUtils.sendOpenSkyF24FlightAlerts();

	}
}
