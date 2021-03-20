package com.flightmonitor.application.jobs;

import java.io.IOException;
import java.time.LocalTime;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.flightmonitor.application.flightutil.FlightUtils;
import com.flightmonitor.application.parms.AppStore;

public class OpenSkyFlightJob implements Job {
	
    public void execute(JobExecutionContext arg0) throws JobExecutionException {    	
    	System.out.println("Flight Job");
    	System.out.println(LocalTime.now());
    	if (false) {
    		System.out.println("OpenSky send messages is on");
    		try {
				FlightUtils.sendOpenSkyFlightAlerts();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else {
    		System.out.println("OpenSky send messages is off");
    	}
    }    
}