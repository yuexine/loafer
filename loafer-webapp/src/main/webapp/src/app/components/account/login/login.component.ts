import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {AccountService} from "../../../services/account.service";
import {GlobalVariable} from "../../../configs/globals";
import {UserService} from "../../../services/user.service";

@Component({
  templateUrl: './login.component.html',
  styleUrls: ['../account.component.css']
})

export class LoginComponent implements OnInit {

  message: string;
  type: string;
  model: any = {};
  loading = false;

  // https://stackoverflow.com/questions/35688084/how-get-query-params-from-url-in-angular2
  constructor(private route: ActivatedRoute,
              private router: Router,
              private accountService: AccountService,
              private userService: UserService) {
    this.route.queryParams.subscribe((params: Params) => {
      let e = params['e'];
      if (e == 'rs') {
        this.message = '注册成功!';
        this.type = 'info';
      }
    })
  }

  ngOnInit(): void {
    this.initBackGround();
    this.userService.removeCurrentUser();
  }

  initBackGround() {
    let body = document.getElementsByTagName('body')[0];
    body.classList.remove('reg_bg');
    body.classList.remove('log_bg');
    body.classList.remove('bg-faded');
    body.classList.add('log_bg');
  }

  login() {
    console.log(this.model);
    this.accountService.login(this.model).subscribe(
      data => {
        console.log(data);
        this.accountService.loginSuccess(data.headers.get(GlobalVariable.TOKEN_KEY));
        this.router.navigate(['/']);
      },
      error => {
        console.log(error);
        this.message = "用户名或密码不匹配 ";
        this.type = "danger";
      }
    )
  }
}
