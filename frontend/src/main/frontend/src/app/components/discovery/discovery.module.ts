import {NgModule} from "@angular/core";

import {DiscoveryComponent} from "./discovery.component";
import {DiscoveryListComponent} from "app/components/discovery/discovery.list.component";
import {HomeRoutingModule} from "../home/home.routing.module";

@NgModule({
  imports: [
    HomeRoutingModule
  ],
  declarations: [
    DiscoveryComponent,
    DiscoveryListComponent
  ]
})

export class DiscoveryModule{}
