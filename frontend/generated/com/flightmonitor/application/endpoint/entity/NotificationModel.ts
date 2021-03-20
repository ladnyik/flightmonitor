// @ts-nocheck

import ObjectIdModel from '../../../../../org/bson/types/ObjectIdModel';
import Notification from './Notification';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from com.flightmonitor.application.endpoint.entity.Notification.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 */
export default class NotificationModel<T extends Notification = Notification> extends ObjectModel<T> { 
  static createEmptyValue: () => Notification;

  get email(): StringModel {
    return this[_getPropertyModel]('email', StringModel, [false]);
  }

  get id(): ObjectIdModel {
    return this[_getPropertyModel]('id', ObjectIdModel, [false]);
  }

  get sendF24Messages(): BooleanModel {
    return this[_getPropertyModel]('sendF24Messages', BooleanModel, [false]);
  }

  get sendOpenSkyMessages(): BooleanModel {
    return this[_getPropertyModel]('sendOpenSkyMessages', BooleanModel, [false]);
  }

  get sendOsF24Messages(): BooleanModel {
    return this[_getPropertyModel]('sendOsF24Messages', BooleanModel, [false]);
  }
}
