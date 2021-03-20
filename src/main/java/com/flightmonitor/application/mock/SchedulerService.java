package com.flightmonitor.application.mock;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.flightmonitor.application.jobs.F24FlightJob;
import com.flightmonitor.application.jobs.OpenSkyF24FlightJob;
import com.flightmonitor.application.jobs.OpenSkyFlightJob;

public class SchedulerService {

	private static SchedulerService INSTANCE;
	private Scheduler scheduler;

	private SchedulerService() throws SchedulerException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		scheduler = schedulerFactory.getScheduler();
	}

	public synchronized static SchedulerService getInstance() throws SchedulerException {
		if (INSTANCE == null) {
			INSTANCE = new SchedulerService();
			INSTANCE.startJobs();
			INSTANCE.startSchedule();
		}
		return INSTANCE;
	}

	public void stopSchedule() throws SchedulerException {
		if (INSTANCE == null) {
			return;
		}
		scheduler.shutdown(true);
	}

	public void startSchedule() throws SchedulerException {
		if (INSTANCE == null) {
			return;
		}
		scheduler.start();
	}

	public void startJobs() throws SchedulerException {

		JobDetail openSkyFlightJob = JobBuilder.newJob(OpenSkyFlightJob.class)
				.withIdentity("OpenSkyFlightJob", "group1").build();

		CronTrigger openSkyFlightJobTrigger = (CronTrigger) TriggerBuilder.newTrigger()
				.withIdentity("trigger1", "group1").withSchedule(CronScheduleBuilder.cronSchedule("0,30 * * * * ?"))
				.forJob("OpenSkyFlightJob", "group1").build();

		scheduler.scheduleJob(openSkyFlightJob, openSkyFlightJobTrigger);

		JobDetail F24FlightJob = JobBuilder.newJob(F24FlightJob.class).withIdentity("F24FlightJob", "group2").build();

		CronTrigger F24FightJobTrigger = (CronTrigger) TriggerBuilder.newTrigger().withIdentity("trigger2", "group2")
				.withSchedule(CronScheduleBuilder.cronSchedule("0,30 * * * * ?")).forJob("F24FlightJob", "group2")
				.build();

		scheduler.scheduleJob(F24FlightJob, F24FightJobTrigger);
		
		JobDetail OpenSkyF24FlightJob = JobBuilder.newJob(OpenSkyF24FlightJob.class).withIdentity("OpenSkyF24FlightJob", "group3").build();

		CronTrigger OpenSkyF24FightJobTrigger = (CronTrigger) TriggerBuilder.newTrigger().withIdentity("trigger3", "group3")
				.withSchedule(CronScheduleBuilder.cronSchedule("0,30 * * * * ?")).forJob("OpenSkyF24FlightJob", "group3")
				.build();

		scheduler.scheduleJob(OpenSkyF24FlightJob, OpenSkyF24FightJobTrigger);
	}
}