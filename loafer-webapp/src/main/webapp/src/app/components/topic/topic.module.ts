import {NgModule} from "@angular/core";
import {HomeRoutingModule} from "../home/home.routing.module";
import {TopicComponent} from "./topic.component";
import {TopicCategoryComponent} from "./topic.category.component";

@NgModule({
  imports: [
    HomeRoutingModule
  ],
  declarations: [
    TopicComponent,
    TopicCategoryComponent
  ],
  providers: []
})

export class TopicModule{}
