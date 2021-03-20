import ObjectId from '../../../../../org/bson/types/ObjectId';

/**
 * This module is generated from com.flightmonitor.application.endpoint.entity.Notification.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file:///home/ladnyik/vaadin/flight-monitor/src/main/java/com/flightmonitor/application/endpoint/entity/Notification.java}
 */

export default interface Notification {
  email: string;
  id: ObjectId;
  sendF24Messages: boolean;
  sendOpenSkyMessages: boolean;
  sendOsF24Messages: boolean;
}
