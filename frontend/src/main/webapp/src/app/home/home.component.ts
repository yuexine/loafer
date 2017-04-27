import {Component, OnChanges, OnInit, SimpleChanges} from "@angular/core";
import {NavigationEnd, Router} from "@angular/router";
import "rxjs/add/operator/filter";

import {User} from "../models/index";
import {SignService} from "../services/index";

@Component({
  selector: 'app-home',
  templateUrl: './home.html',
  styleUrls: ['./home.css']
})

export class HomeComponent implements OnInit, OnChanges {

  constructor(private signService: SignService,
              private router: Router) {
  }

  currentUser: User = this.signService.currentUser();

  ngOnInit(): void {
    this.router.events
      .filter(event => event instanceof NavigationEnd)
      .subscribe((event) => {
        this.currentUser = this.signService.currentUser();
      })
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log(changes)
  }

  logout() {
    this.signService.logout();
    this.currentUser = this.signService.currentUser();
    this.router.navigate(['']);
  }
}
