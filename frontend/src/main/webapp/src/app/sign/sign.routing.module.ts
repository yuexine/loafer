import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

import {SignInComponent} from "./sign-in.component";
import {SignUpComponent} from "./sign-up.component";

const loginRoutes: Routes = [
  {path: 'signin', component: SignInComponent},
  {path: 'signup', component: SignUpComponent}
];

@NgModule({
  imports: [
    RouterModule.forChild(loginRoutes)
  ],
  exports: [
    RouterModule
  ]
})

export class SignRoutingModule {
}
