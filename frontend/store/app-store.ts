import { RouterLocation } from '@vaadin/router';
import { makeAutoObservable } from 'mobx';

export class AppStore {
	
  applicationName = 'Flight Monitor';

  // The location, relative to the base path, e.g. "hello" when viewing "/hello"
  location = '';

  currentViewTitle = '';

  loggedIn = false;

  email = '';

  serviceWorkerRegistration:any;

  messagingToken:any;

  deviceId:any;  

  constructor() {
    makeAutoObservable(this);
  }

  setLocation(location: RouterLocation) {
    if (location.route) {
      this.location = location.route.path;
    } else if (location.pathname.startsWith(location.baseUrl)) {
      this.location = location.pathname.substr(location.baseUrl.length);
    } else {
      this.location = location.pathname;
    }
    this.currentViewTitle = (location?.route as any)?.title || '';
  }
}
export const appStore = new AppStore();
