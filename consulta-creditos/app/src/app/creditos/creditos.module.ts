import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CreditosRoutesModule} from "./creditos-routes.module";
import {CreditosListComponent} from './creditos-list.component';
import {SharedModule} from "../shared/shared.module";

@NgModule({
  imports: [
    SharedModule,
    CommonModule,
    CreditosRoutesModule
  ],
  declarations: [CreditosListComponent],
  exports: []
})
export class CreditosModule {
}
