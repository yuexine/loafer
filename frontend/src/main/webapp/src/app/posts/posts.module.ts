import {NgModule} from "@angular/core";
import {PostRoutingModule} from "./post.routing.module";
import {PostsComponent} from "./posts.component";
import {TagPostComponent} from "./post-tag.component";
import {PostDetailComponent} from "./post-detail.component";

@NgModule({
  imports: [PostRoutingModule],
  declarations: [PostsComponent, TagPostComponent, PostDetailComponent],
  providers: []
})

export class PostsModule {

}
