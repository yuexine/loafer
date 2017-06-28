import {NgModule} from "@angular/core";
import {HomeRoutingModule} from "../home/home.routing.module";
import {ArticleComponent} from "./article.component";
import {IssueComponent} from "./issue.component";
import {MarkdownModule} from "angular2-markdown";
import {PostService} from "../../services/post.service";
import {BrowserModule} from "@angular/platform-browser";

@NgModule({
  imports: [
    BrowserModule,
    HomeRoutingModule,
    MarkdownModule.forRoot()
  ],
  declarations: [
    ArticleComponent,
    IssueComponent,
  ],
  providers: [
    PostService
  ]
})

export class ArticleModule{}
