import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";

import {AppComponent} from "./app.component";
import {AppRoutingModule} from "./app.routing.module";
import {HomeModule} from "./components/home/home.module";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {AccountModule} from "./components/account/account.module";

import {AccountService} from "./services/account.service";
import {HttpService} from "./services/http.service";
import {UserService} from "./services/user.service";
import {EmitterService} from "./services/event.emitter.service";
import {MarkdownModule} from "angular2-markdown";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    HomeModule,
    AccountModule,
    AppRoutingModule,
    NgbModule.forRoot(),
    MarkdownModule.forRoot()
  ],
  providers: [HttpService, AccountService, UserService, EmitterService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
