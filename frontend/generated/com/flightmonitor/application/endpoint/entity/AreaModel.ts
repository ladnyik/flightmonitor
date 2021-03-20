// @ts-nocheck

import Area from './Area';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from com.flightmonitor.application.endpoint.entity.Area.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 */
export default class AreaModel<T extends Area = Area> extends ObjectModel<T> { 
  static createEmptyValue: () => Area;

  get bottomLatitude(): NumberModel {
    return this[_getPropertyModel]('bottomLatitude', NumberModel, [false]);
  }

  get bottomLongitude(): NumberModel {
    return this[_getPropertyModel]('bottomLongitude', NumberModel, [false]);
  }

  get topLatitude(): NumberModel {
    return this[_getPropertyModel]('topLatitude', NumberModel, [false]);
  }

  get topLongitude(): NumberModel {
    return this[_getPropertyModel]('topLongitude', NumberModel, [false]);
  }
}
