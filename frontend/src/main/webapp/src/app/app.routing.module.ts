import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {PageNotFoundComponent} from "./404/not-found.component";
import {NgModule} from "@angular/core";

const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
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
