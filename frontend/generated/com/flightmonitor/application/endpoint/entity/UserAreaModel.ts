// @ts-nocheck

import ObservedAreaModel from './ObservedAreaModel';
import ObjectIdModel from '../../../../../org/bson/types/ObjectIdModel';
import UserArea from './UserArea';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from com.flightmonitor.application.endpoint.entity.UserArea.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 */
export default class UserAreaModel<T extends UserArea = UserArea> extends ObjectModel<T> { 
  static createEmptyValue: () => UserArea;

  get areas(): ArrayModel<ModelType<ObservedAreaModel>, ObservedAreaModel> {
    return this[_getPropertyModel]('areas', ArrayModel, [true, ObservedAreaModel, [false]]);
  }

  get deviceId(): StringModel {
    return this[_getPropertyModel]('deviceId', StringModel, [false]);
  }

  get email(): StringModel {
    return this[_getPropertyModel]('email', StringModel, [true]);
  }

  get id(): ObjectIdModel {
    return this[_getPropertyModel]('id', ObjectIdModel, [false]);
  }
}
