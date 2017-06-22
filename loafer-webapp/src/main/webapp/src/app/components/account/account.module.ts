import {NgModule} from "@angular/core";
import {AccountRoutingModule} from "./account.routing.module";
import {RegisterComponent} from "./register/register.component";
import {LoginComponent} from "./login/login.component";
import {FormsModule} from "@angular/forms";
import {BrowserModule} from "@angular/platform-browser";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";

@NgModule({
  imports: [BrowserModule, FormsModule, AccountRoutingModule, NgbModule],
  declarations: [RegisterComponent, LoginComponent],
  providers: [],
  exports: []
})

export class AccountModule {
}
