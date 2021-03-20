// @ts-nocheck

import ObjectIdModel from '../../../../../org/bson/types/ObjectIdModel';
import UserInfo from './UserInfo';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from com.flightmonitor.application.endpoint.entity.UserInfo.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 */
export default class UserInfoModel<T extends UserInfo = UserInfo> extends ObjectModel<T> { 
  static createEmptyValue: () => UserInfo;

  get accessToken(): StringModel {
    return this[_getPropertyModel]('accessToken', StringModel, [false]);
  }

  get displayName(): StringModel {
    return this[_getPropertyModel]('displayName', StringModel, [false]);
  }

  get email(): StringModel {
    return this[_getPropertyModel]('email', StringModel, [false]);
  }

  get emailVerified(): BooleanModel {
    return this[_getPropertyModel]('emailVerified', BooleanModel, [false]);
  }

  get enabled(): BooleanModel {
    return this[_getPropertyModel]('enabled', BooleanModel, [false]);
  }

  get id(): ObjectIdModel {
    return this[_getPropertyModel]('id', ObjectIdModel, [false]);
  }

  get logIn(): StringModel {
    return this[_getPropertyModel]('logIn', StringModel, [false]);
  }

  get logOut(): StringModel {
    return this[_getPropertyModel]('logOut', StringModel, [false]);
  }

  get photoURL(): StringModel {
    return this[_getPropertyModel]('photoURL', StringModel, [false]);
  }
}
