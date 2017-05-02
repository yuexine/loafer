import {Component} from "@angular/core";
@Component({
  template: `
    <div>Post-Detail</div>
    <textarea [(ngModel)]="textData" cols="100" rows="10"></textarea>
    <markdown [data]="textData"></markdown>
  `
})

export class PostDetailComponent {
  public textData = `## Markdown context data`;
}
