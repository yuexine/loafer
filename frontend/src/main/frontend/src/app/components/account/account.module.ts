import {NgModule} from "@angular/core";
import {AccountRoutingModule} from "./account.routing.module";
import {RegisterComponent} from "./register/register.component";
import {LoginComponent} from "./login/login.component";
import {FormsModule} from "@angular/forms";
import {BrowserModule} from "@angular/platform-browser";
import {AccountService} from "../../services/account.service";
import {HttpService} from "../../services/http.service";

@NgModule({
  imports: [BrowserModule, FormsModule, AccountRoutingModule],
  declarations: [RegisterComponent, LoginComponent],
  providers: [],
  exports: []
})

export class AccountModule {
}
