import {Component, HostBinding, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {slideInDownAnimation} from "../animations";

@Component({
  template: `
    <h3 style="width: 100%">This is Sign up</h3>
    <button (click)="signIn()" class="btn btn-default">Sign In</button>
  `,
  animations: [slideInDownAnimation]
})

export class SignUpComponent{

  @HostBinding('@routeAnimation') routeAnimation = true;
  @HostBinding('style.display')   display = 'block';
  @HostBinding('style.position')  position = 'absolute';

  constructor(private route: Router) {
  }

  signIn() {
    console.log('Click Sign In');
    this.route.navigate(['/signin', {id: '01', name: 'roysmond'}]);
  }
}
