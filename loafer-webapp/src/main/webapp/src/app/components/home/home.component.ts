/**
 * Created by roysmond on 2017/6/1.
 */
import {Component, OnInit} from "@angular/core";
import {NavigationEnd, Router} from "@angular/router";

@Component({
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {

  currentPath: string;

  constructor(private router: Router) {
    router.events.subscribe((event: any) => {
      if (event instanceof NavigationEnd) {
        this.currentPath = event.url
      }
    });
  }

  ngOnInit(): void {
    this.initBg()
  }

  private initBg() {
    let body = document.getElementsByTagName('body')[0];
    body.classList.remove('reg_bg');
    body.classList.remove('log_bg');
    body.classList.remove('bg-faded');
    body.classList.add('bg-faded');
  }

  to(link) {
    this.router.navigate([link]);
  }

  activeRoute(activeRoute) {
    if (activeRoute == this.currentPath) {
      return true;
    } else {
      return false;
    }
  }
}
