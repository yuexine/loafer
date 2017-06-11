import {Component, OnInit} from "@angular/core";

@Component({
  templateUrl: './login.component.html',
  styleUrls: ['../account.component.css']
})

export class LoginComponent implements OnInit{

  ngOnInit(): void {
    this.initBackGround();
  }

  private initBackGround() {
    let body = document.getElementsByTagName('body')[0];
    body.classList.remove('reg_bg');
    body.classList.remove('log_bg');
    body.classList.add('log_bg');
  }
}
