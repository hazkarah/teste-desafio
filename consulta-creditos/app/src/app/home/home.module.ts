import {NgModule} from '@angular/core';
import {HomeRoutesModule} from "./home-routes.module";
import {SharedModule} from "../shared/shared.module";

@NgModule({
  imports: [
    SharedModule,
    HomeRoutesModule
  ],
})
export class HomeModule {
}
