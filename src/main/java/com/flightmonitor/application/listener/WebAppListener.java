package com.flightmonitor.application.listener;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import com.flightmonitor.application.mock.SchedulerService;
import com.flightmonitor.application.parms.AppStore;

import de.flapdoodle.embed.mongo.Command;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.Defaults;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.config.Storage;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.config.RuntimeConfig;
import de.flapdoodle.embed.process.runtime.Network;

@Component
@Configuration
@PropertySource("classpath:application.properties")
public class WebAppListener implements ServletContextListener {

	@Value("${mongo.db.location}")
	private String mongodblocation;

	@Value("${mongo.db.port}")
	private int mongodbPort;

	private static MongodExecutable mongodExecutable = null;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("My Vaadin web app is starting.");
		if (mongodExecutable != null) {
			System.out.println("bazdmeg mar megint");
			return;
		}
		try {
			SchedulerService.getInstance();
			System.out.println("local fm location" + mongodblocation);
			System.out.println("local fm port" + mongodbPort);
			ServletContext sc = sce.getServletContext();
			if (sc.getInitParameter("mongo.db.flightmonitor.location") != null)
				mongodblocation = sc.getInitParameter("mongo.db.flightmonitor.location");
			else
				System.out.println("fm it was location null init parameter");
//			if ( mongodblocation == null) {
//				System.out.println(" fm it was null");
//				mongodblocation = "/home/ladnyik/.mongodb/fmdb";
//			}
//				
			if (sc.getInitParameter("mongo.db.flightmonitor.port") != null)
				mongodbPort = Integer.parseInt(sc.getInitParameter("mongo.db.flightmonitor.port"));
			else
				System.out.println("fm it was port null init parameter");

//			if ( mongodbPort == 0) {
//				System.out.println(" fm port it was null");
//				mongodbPort = 27019;
//			}

			System.out.println("fm final location " + mongodblocation);
			System.out.println("fm final port " + mongodbPort);
//			Logger logger =  LoggerFactory.getLogger(getClass().getName());
//			System.out.println(" logger.isDebugEnabled() " + logger.isDebugEnabled());
//			RuntimeConfig runtimeConfig = Defaults.runtimeConfigFor(Command.MongoD, logger).build();
//			MongodStarter starter = MongodStarter.getInstance(runtimeConfig);
			MongodStarter starter = MongodStarter.getDefaultInstance();


			try {
				int port = mongodbPort;
				AppStore.setMongoPort(port);
				Storage storage = new Storage(mongodblocation, null, 0);
				MongodConfig mongodConfig = MongodConfig.builder().version(Version.Main.PRODUCTION)
						.net(new Net(port, Network.localhostIsIPv6())).replication(storage).build();
				mongodExecutable = starter.prepare(mongodConfig);
				MongodProcess mongod = mongodExecutable.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("My Vaadin web app is shutting down.");
		try {
			SchedulerService.getInstance().stopSchedule();
			if (mongodExecutable != null)
				mongodExecutable.stop();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}