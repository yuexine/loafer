import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

import {TagPostComponent} from "./post-tag.component";
import {PostsComponent} from "./posts.component";
import {PostDetailComponent} from "./post-detail.component";

const postRoutes: Routes = [
  {
    path: 'post',
    component: PostsComponent
  },
  {
    path: 'post/:id',
    component: PostDetailComponent
  },
  {
    path: 'post/tag/:id',
    component: TagPostComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(postRoutes)
  ],
  exports: [
    RouterModule
  ]
})

export class PostRoutingModule {
}
