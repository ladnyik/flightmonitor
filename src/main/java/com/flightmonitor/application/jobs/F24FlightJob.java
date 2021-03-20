package com.flightmonitor.application.jobs;


import java.time.LocalTime;
import javax.mail.MessagingException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import com.flightmonitor.application.flightutil.FlightUtils;
import com.flightmonitor.application.parms.AppStore;

public class F24FlightJob implements Job {
	
    public void execute(JobExecutionContext arg0) throws JobExecutionException {    	
    	
    	System.out.println("Flight Job");
    	System.out.println(LocalTime.now());
    	
//    	if (true) {
//    		System.out.println("F24 send messages is on");
//    		try {
//				FlightUtils.sendF24FlightAlerts();
//			} catch (MessagingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//    	}
//    	else {
//    		System.out.println("F24 send messages is off");
//    	}
    }    
}