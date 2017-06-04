import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

import {AppComponent} from "./app.component";
import {HomeModule} from "./home/index";
import {AppRouteModule} from "./app.routing.module";
import {AuthenticationService, HttpClient, SignService, StorageService} from "./_services/index";
import {LoginComponent} from "./login/index";
import {RegisterComponent} from "./register/index";
import {AlertComponent} from "./alert";
import {AlertService} from "./_services";

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    HomeModule,
    AppRouteModule,   //order is important
    // BrowserAnimationsModule
  ],
  declarations: [
    AlertComponent,
    AppComponent,
    LoginComponent,
    RegisterComponent
  ],
  providers: [
    AlertService,
    AuthenticationService,
    HttpClient,
    SignService,
    StorageService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {
}
