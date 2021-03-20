/**
 * This module is generated from NotificationEndPoint.java
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file:///home/ladnyik/vaadin/flight-monitor/src/main/java/com/flightmonitor/application/endpoint/NotificationEndPoint.java}
 * @module NotificationEndPoint
 */

// @ts-ignore
import client from './connect-client.default';
import Notification from './com/flightmonitor/application/endpoint/entity/Notification';

function _getNotifications(
  email: string
): Promise<Notification> {
  return client.call('NotificationEndPoint', 'getNotifications', {email});
}
export {_getNotifications as getNotifications};

function _setNotifications(
  notification: Notification
): Promise<void> {
  return client.call('NotificationEndPoint', 'setNotifications', {notification});
}
export {_setNotifications as setNotifications};
