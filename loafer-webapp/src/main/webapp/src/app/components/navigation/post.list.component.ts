import {Component, Input, OnChanges, OnInit, SimpleChanges} from "@angular/core";
import {NavigationEnd, Router} from "@angular/router";
import {PostService} from "../../services/post.service";
import {style, state, trigger, transition, animate} from "@angular/animations";

@Component({
  selector: 'post-list',
  templateUrl: './post.list.component.html',
  animations: [
    trigger('flyInOut', [
      state('in', style({transform: 'translateX(0)'})),
      transition('void => *', [
        style({
          opacity: 0,
          transform: 'translateX(-100%)'
        }),
        animate('0.4s ease-in')
      ]),
      transition('* => void', [
        animate('0.2s 0.1s ease-out', style({
          opacity: 0,
          transform: 'translateX(100%)'
        }))
      ])
    ])
  ]
})

export class PostListComponent implements OnInit, OnChanges {

  @Input() type: 'latest' | 'recommend' | 'hot' | 'comment';

  @Input() selected: 'latest' | 'recommend' | 'hot' | 'comment';

  @Input() topicName: string;

  title = "Post List";

  data = {};

  currentPage = 1;

  itemsPerPage = 10;

  constructor(private router: Router, private postService: PostService) {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
      }
    });
  }


  ngOnInit(): void {
    this.title = this.type

    // EmitterService.get('TabChangeEvent').subscribe(event=>{
    //   console.log(event)
    //   this.topicName = event;
    // });
  }

  //get data when condition changed
  ngOnChanges(changes: SimpleChanges): void {
    if (this.selected == this.type) {
      this.initData();
    }
  }

  pageChanged(data) {
    this.currentPage = data.page;
    this.itemsPerPage = data.itemsPerPage;
    this.initData();
  }

  toPostDetail(item) {
    this.router.navigate(['article/' + item.id])
  }

  initData() {
    //load data
    console.log("get Date: " + this.topicName + ";" + this.type + ";" + this.currentPage);
    this.postService.getPostSummaries(this.type, this.topicName, this.currentPage, this.itemsPerPage)
      .subscribe(
        data => {
          console.log(data);
          this.data = data.body;
        },
        error => {
          console.log(error)
        }
      );
  }

}
