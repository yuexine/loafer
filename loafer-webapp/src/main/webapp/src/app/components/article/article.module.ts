import {NgModule} from "@angular/core";
import {HomeRoutingModule} from "../home/home.routing.module";
import {ArticleComponent} from "./article.component";
import {IssueComponent} from "./issue.component";
import {MarkdownModule} from "angular2-markdown";

@NgModule({
  imports: [
    HomeRoutingModule,
    MarkdownModule.forRoot()
  ],
  declarations: [
    ArticleComponent,
    IssueComponent,
  ],
  providers: []
})

export class ArticleModule{}
