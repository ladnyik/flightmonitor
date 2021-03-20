import ObjectId from '../../../../../org/bson/types/ObjectId';

/**
 * This module is generated from com.flightmonitor.application.endpoint.entity.UserInfo.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file:///home/ladnyik/vaadin/flight-monitor/src/main/java/com/flightmonitor/application/endpoint/entity/UserInfo.java}
 */

export default interface UserInfo {
  accessToken: string;
  displayName: string;
  email: string;
  emailVerified: boolean;
  enabled: boolean;
  id: ObjectId;
  logIn: string;
  logOut: string;
  photoURL: string;
}
