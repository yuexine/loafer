import {NgModule} from "@angular/core";

import {PostNavComponent} from "./post.nav.component";
import {ActiveTopicComponent} from "app/components/navigation/topic.active.component";
import {HomeRoutingModule} from "../home/home.routing.module";
import {PostListComponent} from "./post.list.component";
import {BrowserModule} from "@angular/platform-browser";
import {TopicService} from "../../services/topic.service";
import {PaginationModule, TabsModule} from "ngx-bootstrap";
import {FormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HomeRoutingModule,
    PaginationModule.forRoot(),
    TabsModule.forRoot(),
  ],
  declarations: [
    PostNavComponent,
    ActiveTopicComponent,
    PostListComponent
  ],
  providers: [
    TopicService
  ]
})

export class NavigationModule {
}
