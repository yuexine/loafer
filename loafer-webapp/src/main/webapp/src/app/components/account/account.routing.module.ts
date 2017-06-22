import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {RegisterComponent} from "./register/register.component";
import {LoginComponent} from "./login/login.component";

const accountRoutes: Routes = [
  {path: 'account/register', component: RegisterComponent},
  {path: 'account/login', component: LoginComponent},
];

@NgModule({
  id: module.id,
  imports: [
    RouterModule.forChild(accountRoutes)
  ],
  exports: [
    RouterModule
  ]
})

export class AccountRoutingModule {
}
