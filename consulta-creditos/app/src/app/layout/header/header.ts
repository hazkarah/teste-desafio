import { Component } from '@angular/core';
import {MatToolbar} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-header',
  imports: [
    MatToolbar,
    MatButtonModule,
    RouterLink,
  ],
  templateUrl: './header.html',
  styleUrl: './header.scss'
})
export class Header {

}
