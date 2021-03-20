importScripts('/VAADIN/static/server/workbox/workbox-sw.js');
importScripts('https://www.gstatic.com/firebasejs/8.3.1/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/8.3.1/firebase-messaging.js');
/* csácsaá*/

console.log('szeva');

var app = firebase.initializeApp({
	apiKey: "AIzaSyD_ClZV4paPW-DkYzeb4IrhsQwLXP38vDQ",
	authDomain: "monitor-dcde3.firebaseapp.com",
	databaseURL: "https://monitor-dcde3.firebaseio.com",
	projectId: "monitor-dcde3",
	storageBucket: "monitor-dcde3.appspot.com",
	messagingSenderId: "599266210703",
	appId: "1:599266210703:web:c836754716001d5f"
});

const messaging = firebase.messaging();

console.log(messaging);

workbox.setConfig({
	modulePathPrefix: '/VAADIN/static/server/workbox/'
});

workbox.precaching.precacheAndRoute([
	{ url: 'icons/icon-144x144.png', revision: '1457176795' },
	{ url: 'icons/icon-192x192.png', revision: '1978601739' },
	{ url: 'icons/icon-512x512.png', revision: '-639691905' },
	{ url: 'icons/icon-16x16.png', revision: '689317877' },
	{ url: 'offline.html', revision: '1738189567' },
	{ url: 'manifest.webmanifest', revision: '184015085' },
	{ url: 'images/logo.png', revision: '1867512923' }
]);

self.addEventListener('activate', async () => {
  console.log('service worker activate');  
});

self.addEventListener('push', function(event) {
  if (event.data) {  
    console.log('This push event has data: ', event.data.text());
    self.registration.showNotification(
    	'Testing', {
        body: event.data.text()
       }
    );					
  } else {
    console.log('This push event has no data.');
  }
});

self.addEventListener('fetch', function(event) {
	var request = event.request;
	if (request.mode === 'navigate') {
		event.respondWith(
			fetch(request)
				.catch(function() {
					return caches.match('offline.html');
				})
		);
	}
});

