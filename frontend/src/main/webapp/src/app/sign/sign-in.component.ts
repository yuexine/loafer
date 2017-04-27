import {Component} from "@angular/core";
import {User} from "./user";

@Component({
  // template: `
  //   <h2>This is Sign In Component</h2>
  // `
  templateUrl: './sign-in.html',
  styleUrls: ['./sign-in.css']
})

export class SignInComponent {

  model = new User();

  onSubmit() {
    console.log(JSON.stringify(this.model));
  }
}
