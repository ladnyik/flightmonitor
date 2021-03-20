/**
 * This module is generated from FmUtilities.java
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file:///home/ladnyik/vaadin/flight-monitor/src/main/java/com/flightmonitor/application/endpoint/FmUtilities.java}
 * @module FmUtilities
 */

// @ts-ignore
import client from './connect-client.default';

function _getMongoPort(): Promise<number> {
  return client.call('FmUtilities', 'getMongoPort');
}
export {_getMongoPort as getMongoPort};
