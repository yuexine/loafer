import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

import {AppComponent} from "./app.component";
import {HomeComponent} from "./home/home.component";
import {AppRouteModule} from "./app.routing.module";
import {PageNotFoundComponent} from "./404/not-found.component";
import {SignModule} from "./sign/sign.module";


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    SignModule,
    AppRouteModule,
    BrowserAnimationsModule
  ],
  declarations: [
    AppComponent,
    HomeComponent,
    PageNotFoundComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
