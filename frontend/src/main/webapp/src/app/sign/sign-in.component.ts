import {Component} from "@angular/core";
import {Router} from "@angular/router";

import {User} from "../models/index";
import {SignService} from "../services/index";

@Component({
  // template: `
  //   <h2>This is Sign In Component</h2>
  // `
  templateUrl: './sign-in.html',
  styleUrls: ['./sign-in.css']
})

export class SignInComponent {

  constructor(private router: Router,
              private signService: SignService) {
  }

  model = new User();

  onSubmit() {

    console.log(localStorage.getItem('currentUser'));

    this.signService.login(this.model).subscribe(
      data => {
        console.log(JSON.stringify(data));
        this.router.navigate(['/']);
      },
      error => {
        console.error(error);
      }
    );
  }

}
