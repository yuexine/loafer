import {AfterContentChecked, AfterContentInit, AfterViewChecked, AfterViewInit, Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {EmitterService} from "app/services/event.emitter.service";

@Component({
  templateUrl: './post.nav.component.html',
  styleUrls: ['./navigation.component.scss']
})

export class PostNavComponent implements OnInit, AfterViewInit, AfterViewChecked, AfterContentChecked, AfterContentInit {

  // http://blog.mgechev.com/2016/01/23/angular2-viewchildren-contentchildren-difference-viewproviders/
  // @ViewChildren(PostListComponent) postListComponents: QueryList<PostListComponent>;

  private topicName: string;

  private selected: string = 'latest';

  constructor(private router: Router,
              private route: ActivatedRoute,
              private emitterService: EmitterService) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      console.log(params);
      console.log(this.topicName)
      this.topicName = params.name;
    });

    this.initHotPlate();
  }

  ngAfterViewInit(): void {
  }

  ngAfterViewChecked(): void {
  }

  ngAfterContentChecked(): void {
  }

  ngAfterContentInit(): void {
  }

  tabSelect(event) {
    console.log(event)
    this.selected = event;
  }

  private initHotPlate() {
    console.log("initHotPlate")
  }
}
