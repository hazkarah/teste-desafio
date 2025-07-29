import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CreditosListComponent} from "./creditos-list.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@NgModule({
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  declarations: [CreditosListComponent],
  exports: []
})
export class CreditosModule {
}

