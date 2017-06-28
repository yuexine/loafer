import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {PostService} from "../../services/post.service";
import {Post} from "../../models/Post";

@Component({
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css', '../navigation/navigation.component.scss']
})

export class ArticleComponent implements OnInit {

  private articleId: number;

  post: Post = new Post();

  constructor(private router: Router,
              private route: ActivatedRoute,
              private postService: PostService) {

  }

  ngOnInit(): void {
    // https://stackoverflow.com/questions/39668916/angular2-get-url-query-parameters
    this.route.params.subscribe(params => {
      this.articleId = params['id'];
      this.initPostData(this.articleId);
    })
  }

  private initPostData(articleId: number) {
    console.log("get article data" + articleId)
    this.postService.getPost(articleId)
      .subscribe(
        data => {
          console.log(data)
          this.post = data.body;
          console.log(this.post)
        },
        error => {
          console.log(error)
        })
  }


}
