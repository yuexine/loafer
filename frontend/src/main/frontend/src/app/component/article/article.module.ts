import {NgModule} from "@angular/core";
import {HomeRoutingModule} from "../home/home.routing.module";
import {ArticleComponent} from "./article.component";
import {IssueComponent} from "./issue.component";

@NgModule({
  imports: [
    HomeRoutingModule
  ],
  declarations: [
    ArticleComponent,
    IssueComponent
  ],
  providers: []
})

export class ArticleModule{}
