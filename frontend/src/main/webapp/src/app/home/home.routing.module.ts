import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {HomeComponent} from "./index";

const homeRoutes: Routes = [
  {path: '', component: HomeComponent}
];

@NgModule({
  id: module.id,
  imports: [
    RouterModule.forChild(homeRoutes)
  ],
  exports: [
    RouterModule
  ]
})

export class HomeRoutingModule {
}
