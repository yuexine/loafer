import {AfterViewInit, Component, EventEmitter, OnChanges, OnInit, Output, SimpleChanges} from "@angular/core";
import {HomeService} from "./home.service";
import {User} from "../sign/user";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.html',
  styleUrls: ['./home.css']
})

export class HomeComponent implements OnInit,OnChanges {


  currentUser: User = this.homeService.currentUser();

  constructor(private homeService: HomeService,
              private router: Router) {
  }

  ngOnInit(): void {
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
