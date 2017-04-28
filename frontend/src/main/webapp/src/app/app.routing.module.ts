import {RouterModule, Routes} from "@angular/router";
import {PageNotFoundComponent} from "./404/not-found.component";
import {NgModule} from "@angular/core";
import {TagsComponent} from "app/tag/tags.components";

const appRoutes: Routes = [
  {path: 'tags', component: TagsComponent},
  {path: '', redirectTo: '', pathMatch: 'full'},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})

export class AppRouteModule {
}
