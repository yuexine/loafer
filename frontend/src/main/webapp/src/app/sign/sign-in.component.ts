import {Component} from "@angular/core";
import {Router} from "@angular/router";

import {User} from "../_models/index";
import {SignService} from "../_services/index";
import {StorageService} from "../_services/storage.service";

@Component({
  // template: `
  //   <h2>This is Sign In Component</h2>
  // `
  templateUrl: './sign-in.html',
  styleUrls: ['./sign-in.css']
})

export class SignInComponent {

  constructor(private router: Router,
              private signService: SignService,
              private storageService: StorageService) {
  }

  model = new User();

  private tokenKey = "X-AuthToken";

  onSubmit() {

    this.signService.login(this.model).subscribe(
      data => {
        if (data.status == 200) {
          let authToken = data.headers.get(this.tokenKey);
          this.storageService.setItem(this.tokenKey, authToken);
          this.signService.account().subscribe(
            data => {
              console.log(data);
              this.storageService.setItem("currentUser", JSON.stringify(data.json()));
              this.router.navigate(['/']);
            },
            error => {
              console.log(error)
            }
          );
        }
      },
      error => {
        console.error(error);
      }
    );
  }

}
