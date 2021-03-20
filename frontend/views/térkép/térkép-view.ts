import '!style-loader!css-loader!./térkép-view.css';
import '!style-loader!css-loader?url=false!leaflet/dist/leaflet.css';
import { customElement, html, PropertyValues, query, property } from 'lit-element';
import { View } from '../../views/view';
import * as L from 'leaflet';
//	import UserArea from '../../generated/com/flightmonitor/application/endpoint/entity/UserArea';
import * as  UserAreaEndPoint from '../../generated/UserAreaEndPoint';
import { appStore } from '../../store/app-store';
import '@vaadin/vaadin-form-layout';
import '@vaadin/vaadin-text-field/vaadin-text-field';
import '@vaadin/vaadin-text-field/vaadin-number-field';
import "@vaadin/vaadin-button";
import ObservedArea from '../../generated/com/flightmonitor/application/endpoint/entity/ObservedArea';
import Area from '../../generated/com/flightmonitor/application/endpoint/entity/Area';
import "@vaadin/vaadin-checkbox";

//import * as  UserArea from '../../generated/com/flightmonitor/application/endpoint/entity/UserArea';

const openStreetMapLayer = 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
const openStreetMapAttribution = `&copy; <a href='https://www.openstreetmap.org/copyright'>OpenStreetMap</a> contributors`;

@customElement('térkép-view')
export class TérképView extends View {

	private map!: L.Map;

	private myMarker1?: L.Marker;
	private myMarker2?: L.Marker;

	@query('.map')
	private mapContainer!: HTMLElement;

	@query('#savebutton')
	private savebutton: any;

	@query('#descriptionfield')
	private descriptionfield: any;

	@query('#sendnotificationfield')
	private sendnotificationfield: any;

	@query('#bottomlatitudefield')
	private bottomlatitudefield: any;

	@query('#bottomlongitudefield')
	private bottomlongitudefield: any;

	@query('#toplatitudefield')
	private toplatitudefield: any;

	@query('#toplongitudefield')
	private toplongitudefield: any;

	@query('#minaltitudefield')
	private minaltitudefield: any;

	@query('#maxaltitudefield')
	private maxaltitudefield: any;

	@query('#minspeedfield')
	private minspeedfield: any;

	@query('#maxspeedfield')
	private maxspeedfield: any;

	@query('#minverticalfield')
	private minverticalfield: any;

	@query('#maxverticalfield')
	private maxverticalfield: any;

	@query('#formlayout')
	private formlayout: any;

	private rectangles: Array<L.Rectangle> = [];

	@property()
	private actualRectangle?: L.Rectangle;

	@property()
	private newRect?: L.Rectangle;

	private userArea: any;

	@property()
	description: String = "description";

	@property()
	sendEmailNotification: boolean = false;

	@property()
	bottomLongitude: number = 0;
	@property()
	bottomLatitude: number = 0;

	@property()
	topLongitude: number = 0;
	@property()
	topLatitude: number = 0;

	@property()
	minAltitude: number = 0;
	@property()
	maxAltitude: number = 0;

	@property()
	minVertical: number = 0;
	@property()
	maxVertical: number = 0;

	@property()
	minSpeed: number = 0;
	@property()
	maxSpeed: number = 0;

	render() {
		return html`
			<div id="wrapper">
				<div id="map" class="map"></div>
				<div class="form">
					<vaadin-form-layout id="formlayout">
						<vaadin-form-item>
							<vaadin-text-field @change=${this.change} id="descriptionfield" label="Description1"
								value=${this.description} class="myclass"></vaadin-text-field>
							<vaadin-checkbox id="sendnotificationfield" @change=${this.change}>Send notification</vaadin-checkbox>
						</vaadin-form-item>
						<br>
						
						<vaadin-form-item>
							<vaadin-number-field class="latlng" id="bottomlatitudefield" label="Bottom Latitude" step="0.01"
								@change=${this.change} value=${this.bottomLatitude} min="0" max="90" has-controls>
							</vaadin-number-field>
							<vaadin-number-field class="latlng" id="bottomlongitudefield" label="Bottom Longitude" step="0.01"
								@change=${this.change} value=${this.bottomLongitude} min=" 0" max="180" has-controls>
							</vaadin-number-field>
						</vaadin-form-item>
						<br>
						
						<vaadin-form-item>
							<vaadin-number-field class="latlng" id="toplatitudefield" label="Top Latitude" step="0.01"
								@change=${this.change} value=${this.topLatitude} min=" 0" max="90" has-controls>
							</vaadin-number-field>
							<vaadin-number-field class="latlng" id="toplongitudefield" label="Top Longitude" step="0.01"
								value=${this.topLongitude} @change=${this.change} min=" 0" max="180" has-controls>
							</vaadin-number-field>
						</vaadin-form-item>
						<br>
						
						<vaadin-form-item>
							<vaadin-number-field class="latlng" id="minaltitudefield" @change=${this.change} label="Min Altitude"
								step="100" value=${this.minAltitude} min="0" max="15000" has-controls></vaadin-number-field>
							<vaadin-number-field id="maxaltitudefield" @change=${this.change} label="Max Altitude" step="100"
								value=${this.maxAltitude} min="0" max="15000" has-controls></vaadin-number-field>
						</vaadin-form-item>
						<br>
			
						<vaadin-form-item>
							<vaadin-number-field id="minverticalfield" @change=${this.change} label="Min Vertical" step="1"
								value=${this.minVertical} min="-100" max="0" has-controls></vaadin-number-field>
							<vaadin-number-field id="maxverticalfield" @change=${this.change} label="Max Vertical" step="1"
								value=${this.maxVertical} min="0" max="100" has-controls>
							</vaadin-number-field>
						</vaadin-form-item>
						<br>
						
						<vaadin-form-item>
							<vaadin-number-field id="minspeedfield" @change=${this.change} label="Min Speed" step="30"
								value=${this.minSpeed} min="0" max="1500" has-controls>
							</vaadin-number-field>
							<vaadin-number-field id="maxspeedfield" @change=${this.change} label="Max Speed" step="30"
								value=${this.maxSpeed} min="0" max="1500" has-controls>
							</vaadin-number-field>
						</vaadin-form-item>
						<br>
						
						<vaadin-form-item>
							<vaadin-button id="savebutton" @click="${this.save}">Save</vaadin-button>
							<vaadin-button @click="${this.cancel}">Cancel</vaadin-button>
							<vaadin-button @click="${this.delete}">Delete</vaadin-button>
						</vaadin-form-item>
					</vaadin-form-layout>
				</div>
			</div
			`;
	}

	firstUpdated(_changedProperties: PropertyValues) {
		super.firstUpdated(_changedProperties);

		this.formlayout.hidden = true;
		this.map = L.map(this.mapContainer);
		this.map.setView([0, 0], 10);
		let tileLayer = L.tileLayer(openStreetMapLayer, { attribution: openStreetMapAttribution, maxZoom: 19 });
		tileLayer.addTo(this.map);
		this.map.on('contextmenu', (e) => {
			this.mapContextMenu(e);
		});
		if (appStore.email.length > 0)
			this.updateUserAreas();
		document.addEventListener("signOn", () => this.updateUserAreas());
		//document.addEventListener("signOn", (event) => this.testSignOn(event));

	}

	/*	testSignOn(event: Event){
			console.log(typeof event);
			let e = event as CustomEvent;
			console.log(e.detail);
		}*/

	mapContextMenu(e: any) {

		if (!this.myMarker1)
			this.myMarker1 = L.marker(e.latlng).addTo(this.map);
		else {
			if (!this.myMarker2) {
				this.myMarker2 = L.marker(e.latlng).addTo(this.map);
				let latlngs: Array<L.LatLng> = [];
				var latlng1 = L.latLng(this.myMarker1.getLatLng());
				var latlng2 = L.latLng(this.myMarker2.getLatLng());
				latlngs.push(latlng1);
				latlngs.push(latlng2);
				var bounds = L.latLngBounds(latlngs);
				this.newRect = L.rectangle(bounds, { color: "#0000ff", weight: 1 });
				this.newRect.addTo(this.map);
				this.actualRectangle = this.newRect;
				this.map.removeLayer(this.myMarker1);
				this.map.removeLayer(this.myMarker2);
				this.formlayout.hidden = false;
				this.description = "";
				this.sendEmailNotification = false;
				this.savebutton.disabled = true;
				this.bottomLatitude = this.newRect.getBounds().getSouthWest().lat;
				this.bottomLongitude = this.newRect.getBounds().getSouthWest().lng;
				this.topLatitude = this.newRect.getBounds().getNorthEast().lat;
				this.topLongitude = this.newRect.getBounds().getNorthEast().lng;
				this.minAltitude = 0;
				this.maxAltitude = 20000;
				this.minVertical = -50;
				this.maxVertical = 50;
				this.minSpeed = 0;
				this.maxSpeed = 2000;
			}
		}
	}

	updateUserAreas() {

		this.rectangles.forEach((rectangle) => {
			this.map.removeLayer(rectangle);
		});
		this.rectangles = [];
		delete this.actualRectangle;
		UserAreaEndPoint.getUserArea(appStore.email).then((result) => {
			if (result) {
				this.userArea = result;
				if (result.areas) {
					let latlngs: Array<L.LatLng> = [];
					let latlngsForFit: Array<L.LatLng> = [];
					var areaexists = false;
					for (let observedArea of result.areas) {
						areaexists = true;
						latlngs = [];
						var latlng = L.latLng(observedArea.area.bottomLatitude, observedArea.area.bottomLongitude);
						latlngs.push(latlng);
						var latlng1 = L.latLng(observedArea.area.topLatitude, observedArea.area.topLongitude);
						latlngs.push(latlng1);
						var bounds1 = L.latLngBounds(latlngs);
						var rect;
						if (observedArea.sendEmailNotification) {
							rect = L.rectangle(bounds1, { color: "#ff0000", weight: 1 });
							this.sendnotificationfield.checked = true;
						}
						else {
							rect = L.rectangle(bounds1, { color: "#0000ff", weight: 1 });
							this.sendnotificationfield.checked = false;
						}
						rect.addTo(this.map).on('click', (e: L.LeafletMouseEvent) => {
							this.myRectangleClick(e);
						});
						this.rectangles.push(rect);
						latlngsForFit.push(latlng);
						latlngsForFit.push(latlng1);
					}
					if (areaexists) {
						var bounds = L.latLngBounds(latlngsForFit);
						this.map.fitBounds(bounds);
					}
					else {
						if (!navigator.geolocation) {
							console.log("not supported");
						}
						else {
							navigator.geolocation.getCurrentPosition((position) => {
								this.map.setView(new L.LatLng(position.coords.latitude, position.coords.longitude), 7);
							});
						}
					}
				}
			}
		});
	}

	save() {

		var i = 0;
		var exists = false;
		for (let rectangle of this.rectangles) {
			if (rectangle == this.actualRectangle) {
				this.userArea.areas[i].sendEmailNotification = this.sendEmailNotification;
				this.userArea.areas[i].description = this.description;
				this.userArea.areas[i].area.bottomLatitude = this.bottomLatitude;
				this.userArea.areas[i].area.bottomLongitude = this.bottomLongitude;
				this.userArea.areas[i].area.topLatitude = this.topLatitude;
				this.userArea.areas[i].area.topLongitude = this.topLongitude;
				this.userArea.areas[i].minAltitude = this.minAltitude;
				this.userArea.areas[i].maxAltitude = this.maxAltitude;
				this.userArea.areas[i].minVertical = this.minVertical;
				this.userArea.areas[i].maxVertical = this.maxVertical;
				this.userArea.areas[i].minSpeed = this.minSpeed;
				this.userArea.areas[i].maxSpeed = this.maxSpeed;
				exists = true;
			}
			i++;
		}
		if (!exists) {
			var area: Area = {
				bottomLatitude: this.bottomLatitude,
				bottomLongitude: this.bottomLongitude,
				topLatitude: this.topLatitude,
				topLongitude: this.topLongitude,
			};
			var observedArea: ObservedArea = {
				sendEmailNotification: this.sendEmailNotification,
				description: this.description.toString(),
				area: area,
				minAltitude: this.minAltitude,
				maxAltitude: this.maxAltitude,
				minVertical: this.minVertical,
				maxVertical: this.maxVertical,
				minSpeed: this.minSpeed,
				maxSpeed: this.maxSpeed,
				minTrack: 0,
				maxTrack: 360
			};
			this.userArea.areas.push(observedArea);
			delete this.myMarker1;
			delete this.myMarker2;
			if (this.newRect)
				this.map.removeLayer(this.newRect);
		}
		UserAreaEndPoint.setUserArea(this.userArea).then(() => {
			this.formlayout.hidden = true;
			this.updateUserAreas();
		});
	}

	cancel() {
		this.formlayout.hidden = true;
		var exists = false;
		for (let rectangle of this.rectangles) {
			if (rectangle == this.actualRectangle) {
				exists = true;
			}
		}

		if (!exists && this.actualRectangle) {
			this.map.removeLayer(this.actualRectangle);
		}
		delete this.myMarker1;
		delete this.myMarker2;
		delete this.actualRectangle;
	}

	delete(e: CustomEvent) {
		e;
		var i = 0;
		for (let rectangle of this.rectangles) {
			if (rectangle == this.actualRectangle) {
				this.userArea.areas.splice(i, 1);
			}
			i++;
		}

		if (this.actualRectangle) {
			this.map.removeLayer(this.actualRectangle);
		}

		UserAreaEndPoint.setUserArea(this.userArea).then(() => {
			this.formlayout.hidden = true;
			this.updateUserAreas();
			delete this.actualRectangle;
		});
		this.formlayout.hidden = true;
	}

	change(e: CustomEvent) {
		e;
		if (e.target == this.bottomlatitudefield || e.target == this.bottomlongitudefield || e.target == this.toplatitudefield || e.target == this.toplongitudefield) {
			if (this.actualRectangle) {
				let latlngs: Array<L.LatLng> = [];
				this.bottomLatitude = this.bottomlatitudefield.value;
				this.bottomLongitude = this.bottomlongitudefield.value;
				this.topLatitude = this.toplatitudefield.value;
				this.topLongitude = this.toplongitudefield.value;
				var latlng1 = L.latLng(this.bottomLatitude, this.bottomLongitude);
				latlngs.push(latlng1);
				var latlng2 = L.latLng(this.topLatitude, this.topLongitude);
				latlngs.push(latlng2);
				var bounds = L.latLngBounds(latlngs);
				this.actualRectangle.setBounds(bounds);
				this.actualRectangle.redraw();
				let latlngsForFit: Array<L.LatLng> = [];
				for (let rectangle of this.rectangles) {
					rectangle.getBounds().getSouthEast;
					latlngsForFit.push(rectangle.getBounds().getSouthWest());
					latlngsForFit.push(rectangle.getBounds().getNorthEast());
					var bounds = L.latLngBounds(latlngsForFit);
					this.map.fitBounds(bounds);
				}
			}
		}
		if (e.target == this.descriptionfield) {
			this.description = this.descriptionfield.value;
			if (this.description.length > 0)
				this.savebutton.disabled = false;
			else
				this.savebutton.disabled = true;
		}
		if (e.target == this.minaltitudefield)
			this.minAltitude = this.minaltitudefield.value;
		if (e.target == this.maxaltitudefield)
			this.maxAltitude = this.maxaltitudefield.value;
		if (e.target == this.minspeedfield)
			this.minSpeed = this.minspeedfield.value;
		if (e.target == this.maxspeedfield)
			this.maxSpeed = this.maxspeedfield.value;
		if (e.target == this.minverticalfield)
			this.minVertical = this.minverticalfield.value;
		if (e.target == this.maxverticalfield)
			this.maxVertical = this.maxverticalfield.value;
		if (e.target == this.sendnotificationfield) {
			this.sendEmailNotification = this.sendnotificationfield.checked;
			/*			if (this.actualRectangle){
							console.log('change lesz');
							console.log(this.sendEmailNotification);
							console.log(this.actualRectangle.options);
							if (this.sendEmailNotification)
								this.actualRectangle.options = { color: "#ff0000", weight: 1 };
							else			
								this.actualRectangle.options = { color: "#0000ff", weight: 1 };
							console.log(this.actualRectangle.options);	
							this.actualRectangle.redraw();
						}*/
		}
	}

	myRectangleClick(e: L.LeafletMouseEvent) {
		this.formlayout.hidden = false;
		var i = 0;
		for (let rectangle of this.rectangles) {
			if (rectangle == e.target) {
				this.sendEmailNotification = this.userArea.areas[i].sendEmailNotification;
				this.sendnotificationfield.checked = this.userArea.areas[i].sendEmailNotification;
				this.description = this.userArea.areas[i].description;
				this.bottomLatitude = this.userArea.areas[i].area.bottomLatitude;
				this.bottomLongitude = this.userArea.areas[i].area.bottomLongitude;
				this.topLatitude = this.userArea.areas[i].area.topLatitude;
				this.topLongitude = this.userArea.areas[i].area.topLongitude;
				this.minAltitude = this.userArea.areas[i].minAltitude;
				this.maxAltitude = this.userArea.areas[i].maxAltitude;
				this.minVertical = this.userArea.areas[i].minVertical;
				this.maxVertical = this.userArea.areas[i].maxVertical;
				this.minSpeed = this.userArea.areas[i].minSpeed;
				this.maxSpeed = this.userArea.areas[i].maxSpeed;
				this.actualRectangle = rectangle;
				break;
			}
			i++;
		}
	}
}
