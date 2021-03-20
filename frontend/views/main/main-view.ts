import { CSSModule } from '@vaadin/flow-frontend/css-utils';
import '@vaadin/vaadin-app-layout';
import { AppLayoutElement } from '@vaadin/vaadin-app-layout';
import '@vaadin/vaadin-app-layout/vaadin-drawer-toggle';
import '@vaadin/vaadin-avatar/vaadin-avatar';
import '@vaadin/vaadin-tabs';
import '@vaadin/vaadin-tabs/vaadin-tab';
import { customElement, html, query } from 'lit-element';
import { router } from '../../index';
import { ViewRoute, views } from '../../routes';
import { appStore } from '../../store/app-store';
import { Layout } from '../view';
import styles from './main-view.css';
import { Router } from '@vaadin/router';
import firebase from 'firebase';
import * as UserLogin from '../../generated/UserLoginEndPoint';
import * as UserDeviceEndPoint from '../../generated/UserDeviceEndPoint';
import { showNotification } from '@vaadin/flow-frontend/a-notification';
import UserDevice from '../../generated/com/flightmonitor/application/endpoint/entity/UserDevice';


@customElement('main-view')
export class MainView extends Layout {
	
  @query('#applayout')
  private applayout: any;

  @query('#viewTitle')
  private viewTitle: any;

  @query('#drawertoggle')
  private drawertoggle: any;

  @query('#tabs')
  private tabs: any;

  @query('#userAvatar')
  private userAvatar: any;


  static get styles() {
    return [CSSModule('lumo-typography'), CSSModule('lumo-color'), CSSModule('app-layout'), styles];
  }

  render() {
    return html`
      <vaadin-app-layout id="applayout" primary-section="drawer" >
        <header slot="navbar" theme="dark">
          	<vaadin-drawer-toggle id="drawertoggle"></vaadin-drawer-toggle>
          	<h1 id="viewTitle">${appStore.currentViewTitle}</h1>
          <vaadin-avatar id="userAvatar" img="images/logo.png" @click="${this.avatarClick}"></vaadin-avatar>
        </header>

        <div slot="drawer">
          <div id="logo">
            <img src="images/logo.png" alt="${appStore.applicationName} logo" />
            <span>${appStore.applicationName}</span>
          </div>
          <hr />
          <vaadin-tabs id="tabs" orientation="vertical" theme="minimal" .selected=${this.getSelectedViewRoute()}>
            ${this.getMenuRoutes().map(
              (viewRoute) => html`
                <vaadin-tab>
                  <a href="${router.urlForPath(viewRoute.path)}" tabindex="-1">${viewRoute.title}</a>
                </vaadin-tab>
              `
            )}
          </vaadin-tabs>
        </div>
        <slot></slot>
      </vaadin-app-layout>
    `;
  }
	constructor() {
  		super();	       		
	}

  avatarClick() {
	
	if (appStore.loggedIn == true){
		firebase.auth().signOut();	
	}		
	else{
	    var provider = new firebase.auth.GoogleAuthProvider();
		provider.addScope('https://www.googleapis.com/auth/cloud-platform');
		provider.addScope('https://www.googleapis.com/auth/firebase.messaging');
	    firebase.auth().signInWithPopup(provider);
	}
  }

	firstUpdated(){
		this.applayout.drawerOpened = false;
		this.viewTitle.hidden = true;
		this.drawertoggle.disabled = true;  
		this.tabs.hidden = true;
		firebase.auth().onAuthStateChanged(			
			(user) => this.UserLoginOut(user)
		);

		console.log('notification ', Notification.permission);
		Notification.requestPermission(function(status) {
   			 console.log('Notification permission status:', status);
		});
		console.log('deviceId', appStore.deviceId);
	}
	
  UserLoginOut(user: any){
					
/*	 appStore.serviceWorkerRegistration.showNotification('Vibration Sample', {
          		body: 'Buzz! Buzz!'});					*/
					
	if (user) {
		//let firebaseUser: firebase.User = user;
		appStore.loggedIn = true;
		var obj = JSON.parse(JSON.stringify(user));
		obj['accessToken'] = obj['stsTokenManager']['accessToken']; 			
	    UserLogin.userLogin(obj).then(result => {
			if (result){
				this.userAvatar.img = user.photoURL;
				appStore.email = user.email;   		
				Router.go({
  					pathname: router.baseUrl + 'map',
				});	    
				const messaging = firebase.messaging();
				messaging.getToken({ vapidKey: 'BGZfKgK6Wqm2IUd8W5U7etcIvW-JHrYfn8PVx4DEH47L3njPRsTK3fvA3OcOyAetBHZXAF7EN8443O-6x9Xl59U', serviceWorkerRegistration: appStore.serviceWorkerRegistration}).then((currentToken) => {
  					if (currentToken) {
						appStore.messagingToken = currentToken;
						UserDeviceEndPoint.updateMessagingToken(appStore.deviceId,currentToken); 
					  } else {
    						console.log('No registration token available. Request permission to generate one.');
  					}
					}).catch((err) => {
  						console.log('An error occurred while retrieving token. ', err);
				}); 			             
				let event = new CustomEvent("signOn", {bubbles: true, detail:user.email});
				this.dispatchEvent(event);

 				console.log(appStore.deviceId);
				console.log(appStore.messagingToken);
				var userDevice: UserDevice = {
                            appCodeName: navigator.appCodeName,
                            appName: navigator.appName,
                            appVersion: navigator.appVersion,
                            platform: navigator.platform,
  							deviceId: appStore.deviceId,
							messageToken: appStore.messagingToken,
  							email: appStore.email					
				};
				
				UserDeviceEndPoint.userDeviceLogin(userDevice).then(()=>{
					console.log('sikeres userdevice iras');
				});
			}
			else{
			    appStore.loggedIn = false;
				this.userAvatar.img = "images/logo.png";
				Router.go({
  					pathname: router.baseUrl,
				});
				this.sayError();				    				
			}
			this.applayout.drawerOpened = appStore.loggedIn;
			this.viewTitle.hidden  = !appStore.loggedIn;
			this.drawertoggle.disabled = !appStore.loggedIn;
			this.tabs.hidden = !appStore.loggedIn;					
		});		
    } else {
		appStore.loggedIn = false;
		UserLogin.userLogout(appStore.email);
		UserDeviceEndPoint.userDeviceLogout(appStore.deviceId).then(()=>{
					console.log('sikeres userdevice logoff');
				});
		appStore.email = "";
		appStore.messagingToken = "";
		this.userAvatar.img = "images/logo.png";
		Router.go({
  			pathname: router.baseUrl,
		});				    			
		this.applayout.drawerOpened = appStore.loggedIn;
		this.viewTitle.hidden  = !appStore.loggedIn;
		this.drawertoggle.disabled = !appStore.loggedIn;
		this.tabs.hidden = !appStore.loggedIn;					
    }

  }
  connectedCallback() {
    super.connectedCallback();

    this.reaction(
      () => appStore.location,
      () => {
        AppLayoutElement.dispatchCloseOverlayDrawerEvent();
      }
    );
  }

  private getMenuRoutes(): ViewRoute[] {
    return views.filter((route) => route.title);
  }

  private getSelectedViewRoute(): number {
    return this.getMenuRoutes().findIndex((viewRoute) => viewRoute.path == appStore.location);
  }

  sayError() {
    showNotification(`Sajnos ki vagy tiltva !!!`);
  }
}
