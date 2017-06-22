import {
  AfterContentChecked, AfterContentInit, AfterViewChecked, AfterViewInit, Component, ContentChild, ContentChildren,
  OnInit,
  QueryList, ViewChildren
} from "@angular/core";
import {NavigationEnd, Router} from "@angular/router";
import {PostListComponent} from "./post.list.component";
import {EmitterService} from "app/services/event.emitter.service";
@Component({
  templateUrl: './discovery.component.html',
  styleUrls: ['./discovery.component.css']
})

export class DiscoveryComponent implements OnInit, AfterViewInit, AfterViewChecked ,AfterContentChecked, AfterContentInit {

  // http://blog.mgechev.com/2016/01/23/angular2-viewchildren-contentchildren-difference-viewproviders/
  @ViewChildren(PostListComponent) postListComponents: QueryList<PostListComponent>;

  topicName: string;

  constructor(private router: Router,
              private emitterService: EmitterService) {
    console.log(router.url.replace('/', ''))
  }

  ngOnInit(): void {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.topicName = event.url.replace('/', '');
      }
    })
  }

  ngAfterViewInit(): void {
    console.log("ngAfterViewInit");
    console.log(this.postListComponents)
  }

  ngAfterViewChecked(): void {
    console.log("ngAfterViewChecked");
    console.log(this.postListComponents)
  }

  ngAfterContentChecked(): void {
    console.log("ngAfterContentChecked");
    console.log(this.postListComponents)
  }

  ngAfterContentInit(): void {
    console.log("ngAfterContentInit");
    console.log(this.postListComponents)
  }

  tabChange(event) {
    //doSomething when tab change
    // this.topicName = event.nextId;
    // EmitterService.get('TabChangeEvent').emit(event.nextId);
  }
}
