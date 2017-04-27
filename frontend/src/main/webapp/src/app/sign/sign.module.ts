import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";

import {SignInComponent} from "./sign-in.component";
import {SignUpComponent} from "./sign-up.component";
import {SignRoutingModule} from "./sign.routing.module";
import {SignService} from "./sign.service";

@NgModule({
  imports: [FormsModule, SignRoutingModule],
  declarations: [SignInComponent, SignUpComponent],
  providers: [SignService]
})

export class SignModule {
}
