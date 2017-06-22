import {NgModule} from "@angular/core";

import {DiscoveryComponent} from "./discovery.component";
import {DiscoveryListComponent} from "app/components/discovery/discovery.list.component";
import {HomeRoutingModule} from "../home/home.routing.module";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {PostListComponent} from "./post.list.component";
import {BrowserModule} from "@angular/platform-browser";

@NgModule({
  imports: [
    BrowserModule,
    HomeRoutingModule,
    NgbModule.forRoot()
  ],
  declarations: [
    DiscoveryComponent,
    DiscoveryListComponent,
    PostListComponent
  ]
})

export class DiscoveryModule {
}
