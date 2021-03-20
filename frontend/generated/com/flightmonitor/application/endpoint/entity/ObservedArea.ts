import Area from './Area';

/**
 * This module is generated from com.flightmonitor.application.endpoint.entity.ObservedArea.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file:///home/ladnyik/vaadin/flight-monitor/src/main/java/com/flightmonitor/application/endpoint/entity/ObservedArea.java}
 */

export default interface ObservedArea {
  area: Area;
  description: string;
  maxAltitude: number;
  maxSpeed: number;
  maxTrack: number;
  maxVertical: number;
  minAltitude: number;
  minSpeed: number;
  minTrack: number;
  minVertical: number;
  sendEmailNotification: boolean;
}
