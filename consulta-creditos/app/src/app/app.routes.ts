import {Routes} from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then((h) => h.HomeModule)
  },
  {
    path: 'creditos',
    loadChildren: () => import('./creditos/creditos.module').then((c) => c.CreditosModule)
  }
];
