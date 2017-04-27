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
import {ContextModule} from "./context/context.module";
import {SignService} from "./services/sign.service";

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    SignModule,
    ContextModule,
    AppRouteModule,
    BrowserAnimationsModule
  ],
  declarations: [
    AppComponent,
    HomeComponent,
    PageNotFoundComponent
  ],
  providers: [SignService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
