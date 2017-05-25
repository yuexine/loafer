import {Component, HostBinding, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {slideInDownAnimation} from "../animations";
import {User} from "../_models/user";
import {SignService} from "../_services/sign.service";

@Component({
  templateUrl: './sign.html',
  animations: [slideInDownAnimation]
})

export class SignUpComponent{

  @HostBinding('@routeAnimation') routeAnimation = true;
  @HostBinding('style.display')   display = 'block';
  @HostBinding('style.position')  position = 'absolute';

  constructor(private route: Router,
              private signService: SignService) {
  }

  model = new User();

  signIn() {
    console.log('Click Sign In');
    this.route.navigate(['/signin', {id: '01', name: 'roysmond'}]);
  }

  signUp(){
    console.log(JSON.stringify(this.model));
    let status = this.signService.register(this.model).subscribe(
      data => { console.log(data)}
    );
    console.log(status);
  }
}
