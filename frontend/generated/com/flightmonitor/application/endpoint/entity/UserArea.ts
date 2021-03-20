import ObservedArea from './ObservedArea';
import ObjectId from '../../../../../org/bson/types/ObjectId';

/**
 * This module is generated from com.flightmonitor.application.endpoint.entity.UserArea.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file:///home/ladnyik/vaadin/flight-monitor/src/main/java/com/flightmonitor/application/endpoint/entity/UserArea.java}
 */

export default interface UserArea {
  areas?: Array<ObservedArea>;
  deviceId: string;
  email?: string;
  id: ObjectId;
}
