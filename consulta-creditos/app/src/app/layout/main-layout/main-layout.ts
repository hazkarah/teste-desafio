import { Component } from '@angular/core';
import {Header} from "../header/header";
import {Content} from "../content/content";
import {Footer} from "../footer/footer";
import {RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-main-layout',
  imports: [
    Header,
    Content,
    Footer,
    RouterOutlet
  ],
  templateUrl: './main-layout.html',
  styleUrl: './main-layout.scss'
})
export class MainLayout {

}
