import {NgModule} from "@angular/core";

import {HomeRoutingModule} from "./home.routing.module";
import {HomeComponent} from "./home.component";
import {NavigationModule} from "../navigation/navigation.module";
import {ArticleModule} from "../article/article.module";
import {TopicModule} from "../topic/topic.module";
import {PostArticleModule} from "../publish/post.article.module";

@NgModule({
  id: module.id,
  imports: [
    HomeRoutingModule,
    NavigationModule,
    ArticleModule,
    TopicModule,
    PostArticleModule
  ],
  declarations: [
    HomeComponent
  ],
  providers: [],
  exports: []
})

export class HomeModule {
}

