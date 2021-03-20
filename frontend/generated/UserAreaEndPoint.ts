/**
 * This module is generated from UserAreaEndPoint.java
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file:///home/ladnyik/vaadin/flight-monitor/src/main/java/com/flightmonitor/application/endpoint/UserAreaEndPoint.java}
 * @module UserAreaEndPoint
 */

// @ts-ignore
import client from './connect-client.default';
import UserArea from './com/flightmonitor/application/endpoint/entity/UserArea';

function _getUserArea(
  deviceId: string,
  email: string
): Promise<UserArea> {
  return client.call('UserAreaEndPoint', 'getUserArea', {deviceId, email});
}
export {_getUserArea as getUserArea};

function _setUserArea(
  userAreas: UserArea
): Promise<void> {
  return client.call('UserAreaEndPoint', 'setUserArea', {userAreas});
}
export {_setUserArea as setUserArea};
