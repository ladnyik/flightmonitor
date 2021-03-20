/**
 * This module is generated from UserLoginEndPoint.java
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file:///home/ladnyik/vaadin/flight-monitor/src/main/java/com/flightmonitor/application/endpoint/UserLoginEndPoint.java}
 * @module UserLoginEndPoint
 */

// @ts-ignore
import client from './connect-client.default';
import UserInfo from './com/flightmonitor/application/endpoint/entity/UserInfo';

function _userLogin(
  userInfo: UserInfo
): Promise<boolean> {
  return client.call('UserLoginEndPoint', 'userLogin', {userInfo});
}
export {_userLogin as userLogin};

function _userLogout(
  email: string
): Promise<void> {
  return client.call('UserLoginEndPoint', 'userLogout', {email});
}
export {_userLogout as userLogout};
