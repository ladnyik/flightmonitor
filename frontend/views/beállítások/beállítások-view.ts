import '!style-loader!css-loader!./beállítások-view.css';
import '@vaadin/vaadin-button';
import '@vaadin/vaadin-checkbox';
import { customElement, html, query, property } from 'lit-element';
import { View } from '../../views/view';
import * as  NotificationEndPoint from '../../generated/NotificationEndPoint';
import * as  FmUtilities from '../../generated/FmUtilities';
import { appStore } from '../../store/app-store';

@customElement('beállítások-view')
export class BeállításokView extends View {
	
  @query('#sendopenskymessages')
  private sendopenskymessages: any;
  @query('#sendf24messages')
  private sendf24messages: any;
  @query('#sendosf24messages')
  private sendosf24messages: any;

  @property()	
  private serverPort?: number; 

  render() {
    return html`
      <h3>${this.serverPort}</h3>
      <vaadin-checkbox id="sendopenskymessages" value="Send alerts"  @change="${this.sendUpdate}">Send alerts from OpenSky</vaadin-checkbox>
	  <vaadin-checkbox id="sendf24messages" value="Send alerts"  @change="${this.sendUpdate}">Send alerts from F24</vaadin-checkbox>
	  <vaadin-checkbox id="sendosf24messages" value="Send alerts"  @change="${this.sendUpdate}">Send alerts from Os & F24</vaadin-checkbox>
    `;
  }
	firstUpdated(){	
		
		FmUtilities.getMongoPort().then(result => {
			this.serverPort = result;
		});
			
		NotificationEndPoint.getNotifications(appStore.email).then(result => {
			console.log(result)
			if (result){
				this.sendopenskymessages.checked = result.sendOpenSkyMessages;
				this.sendf24messages.checked = result.sendF24Messages;
				this.sendosf24messages.checked = result.sendOsF24Messages;
			}
		});
		
	}
		
	sendUpdate() {		
		console.log(this.sendosf24messages.checked);
		var obj = JSON.parse('{}');
		obj['email'] = appStore.email;
		obj['sendF24Messages'] = this.sendf24messages.checked;
		obj['sendOpenSkyMessages'] = this.sendopenskymessages.checked;
		obj['sendOsF24Messages'] = this.sendosf24messages.checked;
		console.log(obj);
		NotificationEndPoint.setNotifications(obj);
	}		
			
}
