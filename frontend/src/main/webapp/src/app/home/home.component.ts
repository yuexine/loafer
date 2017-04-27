import {Component, OnChanges, OnInit, SimpleChanges} from "@angular/core";
import {HomeService} from "./home.service";
import {User} from "../sign/user";
import {NavigationEnd, Router} from "@angular/router";
import "rxjs/add/operator/filter";

@Component({
  selector: 'app-home',
  templateUrl: './home.html',
  styleUrls: ['./home.css']
})

export class HomeComponent implements OnInit, OnChanges {


  currentUser: User = this.homeService.currentUser();

  constructor(private homeService: HomeService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.router.events
      .filter(event => event instanceof NavigationEnd)
      .subscribe((event) => {
        this.currentUser = this.homeService.currentUser();
      })
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log(changes)
  }

  logout() {
    this.homeService.logout();
    this.currentUser = this.homeService.currentUser();
    this.router.navigate(['']);
  }
}
