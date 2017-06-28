import {Component} from "@angular/core";
import {Post} from "../../models/Post";
@Component({
  templateUrl: './post.article.component.html',
})
export class PostArticleComponent {
  post: Post = new Post();
  postTitle = '';
  postContent = '';
  packagePostTitle = '';

  // https://stackoverflow.com/questions/34569094/what-is-the-angular2-equivalent-to-an-angularjs-watch
  packageTitle(v) {
    this.packagePostTitle = v ? '# ' + v : '';
  }

  postArticle() {
    console.log(this.postContent)
  }

}
