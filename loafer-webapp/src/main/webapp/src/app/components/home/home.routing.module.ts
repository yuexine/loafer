import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";

import {HomeComponent} from "app/components/home/home.component";
import {PostNavComponent} from "../navigation/post.nav.component";
import {ActiveTopicComponent} from "../navigation/topic.active.component";
import {TopicCategoryComponent} from "../topic/topic.category.component";
import {TopicComponent} from "../topic/topic.component";
import {IssueComponent} from "../article/issue.component";
import {ArticleComponent} from "../article/article.component";
import {PostArticleComponent} from "../publish/post.article.component";

const homeRoutes: Routes = [
  {
    path: '',
    component: HomeComponent,
    children: [
      {
        path: '',
        component: ActiveTopicComponent,
        children: [
          {
            path: '',
            component: PostNavComponent
          },
          {
            path: ':name',
            component: PostNavComponent
          }
        ]
      },
      {
        path: 'topic',
        component: TopicCategoryComponent
      },
      {
        path: 'topic/:name',
        component: TopicComponent
      },
      {
        path: 'issue/:id',
        component: IssueComponent
      },
      {
        path: 'article/:id',
        component: ArticleComponent
      },
      {
        path: 'publish/article',
        component: PostArticleComponent
      }
    ]
  },
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
