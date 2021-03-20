/**
 * This module is generated from AppStoreUtil.java
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file:///home/ladnyik/vaadin/flight-monitor/src/main/java/com/flightmonitor/application/parms/AppStoreUtil.java}
 * @module AppStoreUtil
 */

// @ts-ignore
import client from './connect-client.default';

function _getMongoPort(): Promise<number> {
  return client.call('AppStoreUtil', 'getMongoPort');
}
export {_getMongoPort as getMongoPort};
