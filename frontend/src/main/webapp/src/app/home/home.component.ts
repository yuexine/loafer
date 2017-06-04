import {Component, OnChanges, OnInit, SimpleChanges} from "@angular/core";
import {NavigationEnd, Router} from "@angular/router";
import "rxjs/add/operator/filter";

import {User} from "../_models/index";
import {SignService} from "../_services/index";

@Component({
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit, OnChanges {

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log(changes)
  }

}
