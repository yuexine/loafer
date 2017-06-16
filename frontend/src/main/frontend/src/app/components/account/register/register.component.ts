import {AfterViewInit, Component, OnInit, ViewChild} from "@angular/core";
import {Router} from "@angular/router";
import {AccountService} from "../../../services/account.service";

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['../account.component.css']
})

export class RegisterComponent implements OnInit, AfterViewInit {

  model: any = {};
  loading = false;
  errMsg: string;
  @ViewChild('f') form;

  constructor(private router: Router,
              private accountService: AccountService) {
  }

  ngOnInit(): void {
    this.initBackGround();
  }


  //https://stackoverflow.com/questions/34615425/how-to-watch-for-form-changes-in-angular-2/34615922#34615922
  ngAfterViewInit(): void {
    console.log(this.form)
    this.form.control.valueChanges.subscribe(values => {
      this.clearErrMsg();
    });
  }

  clearErrMsg(): void {
    this.errMsg = "";
  }


  initBackGround() {
    //https://stackoverflow.com/questions/34636661/how-do-i-change-the-body-class-via-a-typescript-class-angular2
    //any better idea to set bg to element body?
    let body = document.getElementsByTagName('body')[0];
    body.classList.remove('reg_bg');
    body.classList.remove('log_bg');
    body.classList.remove('bg-faded');
    body.classList.add('reg_bg');
  }

  register() {
    this.loading = true;
    console.log(this.model);
    this.accountService.create(this.model)
      .subscribe(
        data => {
          this.router.navigate(['/account/login'], {queryParams: {'e': 'rs'}}); //add register success event to query params
        },
        error => {
          this.loading = false;
          this.errMsg = error.ok && error._body ? JSON.parse(error._body).errMsg : "注册失败";
          console.log(error);
        }
      );
  }
}

