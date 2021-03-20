import { Route } from '@vaadin/router';
import './views/main/main-view';
import './views/térkép/térkép-view';
import './views/login/login-view';

export type ViewRoute = Route & { title?: string; children?: ViewRoute[] };

export const views: ViewRoute[] = [
  // for client-side, place routes below (more info https://vaadin.com/docs/v18/flow/typescript/creating-routes.html)
  {
    path: '',
    component: 'login-view',
    title: '',
  },
  {
    path: 'map',
    component: 'térkép-view',
    title: 'Térkép',
  },
  {
    path: 'settings',
    component: 'beállítások-view',
    title: 'Beállítások',
    action: async () => {
      await import('./views/beállítások/beállítások-view');
    },
  },
];
export const routes: ViewRoute[] = [
  {
    path: '',
    animate: true,
    component: 'main-view',
    children: [...views],
  },
];
