// @ts-nocheck

import ObjectId from './ObjectId';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from org.bson.types.ObjectId.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 */
export default class ObjectIdModel<T extends ObjectId = ObjectId> extends ObjectModel<T> { 
  static createEmptyValue: () => ObjectId;

  get counter(): NumberModel {
    return this[_getPropertyModel]('counter', NumberModel, [false]);
  }

  get machineIdentifier(): NumberModel {
    return this[_getPropertyModel]('machineIdentifier', NumberModel, [false]);
  }

  get processIdentifier(): NumberModel {
    return this[_getPropertyModel]('processIdentifier', NumberModel, [false]);
  }

  get timestamp(): NumberModel {
    return this[_getPropertyModel]('timestamp', NumberModel, [false]);
  }
}
