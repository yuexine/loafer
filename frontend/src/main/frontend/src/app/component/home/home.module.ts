import {NgModule} from "@angular/core";

import {HomeRoutingModule} from "./home.routing.module";
import {HomeComponent} from "./home.component";
import {DiscoveryModule} from "../discovery/discovery.module";
import {ArticleModule} from "../article/article.module";
import {TopicModule} from "../topic/topic.module";

@NgModule({
  id: module.id,
  imports: [
    HomeRoutingModule,
    DiscoveryModule,
    ArticleModule,
    TopicModule
  ],
  declarations: [
    HomeComponent
  ],
  providers: [],
  exports: []
})

export class HomeModule {
}

