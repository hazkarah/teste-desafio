import {Routes} from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () => import('./home/home.component').then((c) => c.HomeComponent)
  },
  {
    path: 'creditos',
    loadComponent: () => import('./creditos/creditos.module').then((c) => c.CreditosModule)
  }
];
