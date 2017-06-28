import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {TopicService} from "../../services/topic.service";
import {Topic} from "../../models/Topic";
import {style, state, trigger, transition, animate} from "@angular/animations";

@Component({
  templateUrl: './topic.active.component.html',
  styleUrls: ['./navigation.component.scss']
})

export class ActiveTopicComponent implements OnInit {

  activeTopic: Topic[];

  constructor(private router: Router,
              private topicService: TopicService) {
    console.log("DiscoveryListComponent constructor init.");
  }

  ngOnInit(): void {
    this.initActiveTopic();
    console.log("DiscoveryListComponent init")

  }

  private navigateTo(topicName, topicId) {
    console.log(topicName);
    this.router.navigate([topicName]);
  }

  private initActiveTopic() {
    this.topicService.getActiveTopic()
      .subscribe(
        data => {
          this.activeTopic = data.body;
          console.log(this.activeTopic)
        },
        error => {
          console.log(error)
        })
  }
}
