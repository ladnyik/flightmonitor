// @ts-nocheck

import AreaModel from './AreaModel';
import ObservedArea from './ObservedArea';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from com.flightmonitor.application.endpoint.entity.ObservedArea.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 */
export default class ObservedAreaModel<T extends ObservedArea = ObservedArea> extends ObjectModel<T> { 
  static createEmptyValue: () => ObservedArea;

  get area(): AreaModel {
    return this[_getPropertyModel]('area', AreaModel, [false]);
  }

  get description(): StringModel {
    return this[_getPropertyModel]('description', StringModel, [false]);
  }

  get maxAltitude(): NumberModel {
    return this[_getPropertyModel]('maxAltitude', NumberModel, [false]);
  }

  get maxSpeed(): NumberModel {
    return this[_getPropertyModel]('maxSpeed', NumberModel, [false]);
  }

  get maxTrack(): NumberModel {
    return this[_getPropertyModel]('maxTrack', NumberModel, [false]);
  }

  get maxVertical(): NumberModel {
    return this[_getPropertyModel]('maxVertical', NumberModel, [false]);
  }

  get minAltitude(): NumberModel {
    return this[_getPropertyModel]('minAltitude', NumberModel, [false]);
  }

  get minSpeed(): NumberModel {
    return this[_getPropertyModel]('minSpeed', NumberModel, [false]);
  }

  get minTrack(): NumberModel {
    return this[_getPropertyModel]('minTrack', NumberModel, [false]);
  }

  get minVertical(): NumberModel {
    return this[_getPropertyModel]('minVertical', NumberModel, [false]);
  }

  get sendEmailNotification(): BooleanModel {
    return this[_getPropertyModel]('sendEmailNotification', BooleanModel, [false]);
  }

  get sendPushNotification(): BooleanModel {
    return this[_getPropertyModel]('sendPushNotification', BooleanModel, [false]);
  }
}
