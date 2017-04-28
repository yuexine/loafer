import {Component} from "@angular/core";
import {Tag} from "../_models/tag";
@Component({
  templateUrl: './tags.html',
  styleUrls: ['./tags.css']
})

export class TagsComponent {

  tags = [
    new Tag(1, 'jQuery', 3),
    new Tag(2, 'Spring', 13),
    new Tag(3, 'Spring-Boot', 43),
    new Tag(4, 'JAVA', 32),
    new Tag(5, 'TypeScript', 15),
  ]

}
