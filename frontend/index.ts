import { Router } from '@vaadin/router';
import { routes } from './routes';
import { appStore } from './store/app-store';
import './styles/shared-styles';
import firebase from 'firebase';
import { v4 as uuid } from 'uuid';

export const router = new Router(document.querySelector('#outlet'));
router.setRoutes(routes);

console.log('deviceId', localStorage.getItem("ladnyik.flightmonitor.deviceId"));
var devicedId = localStorage.getItem("ladnyik.flightmonitor.deviceId");

if (!devicedId) {
	devicedId = uuid();
	localStorage.setItem("ladnyik.flightmonitor.deviceId",devicedId);
	appStore.deviceId = devicedId; 
}
else
	appStore.deviceId = devicedId;

firebase.initializeApp({
	apiKey: "AIzaSyD_ClZV4paPW-DkYzeb4IrhsQwLXP38vDQ",
	authDomain: "monitor-dcde3.firebaseapp.com",
	databaseURL: "https://monitor-dcde3.firebaseio.com",
	projectId: "monitor-dcde3",
	storageBucket: "monitor-dcde3.appspot.com",
	messagingSenderId: "599266210703",
	appId: "1:599266210703:web:c836754716001d5f"
});

if ('serviceWorker' in navigator) {
	console.log("van sw");
	navigator.serviceWorker.register('sw.js')
		.then(function(swReg) {
			appStore.serviceWorkerRegistration = swReg;
		})
		.catch(function(error) {
			console.error('Service Worker Error', error);
		});
}

if ('PushManager' in window) {
	console.log("van push");
}
else {
	console.log("nincs push");
}

window.addEventListener('vaadin-router-location-changed', (e) => {
	appStore.setLocation((e as CustomEvent).detail.location);
	const title = appStore.currentViewTitle;
	if (title) {
		document.title = title + ' | ' + appStore.applicationName;
	} else {
		document.title = appStore.applicationName;
	}
});
