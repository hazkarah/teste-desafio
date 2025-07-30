import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CreditosListComponent} from "./creditos-list.component";

export const CREDITOS_ROUTES: Routes = [
  {
    path: '', component: CreditosListComponent,
  },
  {
    path: 'numero/:numeroCredito', component: CreditosListComponent,
  }
];


@NgModule({
  imports: [RouterModule.forChild(CREDITOS_ROUTES)],
  exports: [RouterModule]
})
export class CreditosRoutesModule {}

