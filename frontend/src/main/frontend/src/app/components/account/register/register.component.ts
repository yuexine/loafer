import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Params, Route, Router} from "@angular/router";
import {AccountService} from "../../../services/account.service";

@Component({
  templateUrl: './register.component.html',
  styleUrls: ['../account.component.css']
})

export class RegisterComponent implements OnInit {

  model: any = {};
  loading = false;
  errMsg: string;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private accountService: AccountService) {
  }

  // https://stackoverflow.com/questions/35688084/how-get-query-params-from-url-in-angular2
  ngOnInit(): void {
    this.initBackGround();
    console.log(this.router.url)
    console.log(this.router);
    console.log(this.route);
    this.route.queryParams.subscribe((params: Params) => {
      console.log(params)
      let a= params['a'];
      console.log(a)
    })
  }

  initBackGround() {
    //https://stackoverflow.com/questions/34636661/how-do-i-change-the-body-class-via-a-typescript-class-angular2
    //any better idea to set bg to element body?
    let body = document.getElementsByTagName('body')[0];
    body.classList.remove('reg_bg');
    body.classList.remove('log_bg');
    body.classList.add('reg_bg');
  }

  register() {
    this.loading = true;
    console.log(this.model);
    this.accountService.create(this.model)
      .subscribe(
        data => {
          console.log(data);
          this.router.navigate(['/account/login']);
        },
        error => {
          this.loading = false;
          this.errMsg = error._body ? JSON.parse(error._body).errMsg : "注册失败";
          console.log(error)
        }
      );
  }
}
