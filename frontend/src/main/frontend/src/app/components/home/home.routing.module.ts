import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";

import {HomeComponent} from "app/components/home/home.component";
import {DiscoveryComponent} from "../discovery/discovery.component";
import {DiscoveryListComponent} from "../discovery/discovery.list.component";
import {TopicCategoryComponent} from "../topic/topic.category.component";
import {TopicComponent} from "../topic/topic.component";
import {IssueComponent} from "../article/issue.component";
import {ArticleComponent} from "../article/article.component";

const homeRoutes: Routes = [
  {
    path: '',
    component: HomeComponent,
    children: [
      {
        path: '',
        component: DiscoveryListComponent,
        children: [
          {
            path: '',
            component: DiscoveryComponent
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