import {NgModule} from "@angular/core";
import {PostRoutingModule} from "./post.routing.module";
import {PostsComponent} from "./posts.component";
import {TagPostComponent} from "./post-tag.component";
import {PostDetailComponent} from "./post-detail.component";
import {MarkdownModule} from "angular2-markdown";
import {FormsModule} from "@angular/forms";

@NgModule({
  imports: [
    FormsModule,
    PostRoutingModule,
    MarkdownModule.forRoot()
  ],
  declarations: [PostsComponent, TagPostComponent, PostDetailComponent],
  providers: []
})

export class PostsModule {

}
