import {NgModule} from "@angular/core";
import {MarkdownModule} from "angular2-markdown";
import {HomeRoutingModule} from "../home/home.routing.module";
import {BrowserModule} from "@angular/platform-browser";
import {PostArticleComponent} from "./post.article.component";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule} from "@angular/forms";
import {PostService} from "../../services/post.service";

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HomeRoutingModule,
    MarkdownModule.forRoot(),
    NgbModule.forRoot()
  ],
  declarations: [
    PostArticleComponent
  ],
  providers: [
    PostService
  ]
})

export class PostArticleModule {
}
