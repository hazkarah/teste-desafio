import { Component } from '@angular/core';
import {RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-content',
  imports: [
    RouterOutlet
  ],
  templateUrl: './content.html',
  styleUrl: './content.scss'
})
export class Content {

}
