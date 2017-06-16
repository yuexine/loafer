import {Component} from "@angular/core";
@Component({
  templateUrl: './discovery.component.html',
  styleUrls: ['./discovery.component.css']
})

export class DiscoveryComponent{
  constructor(){
    console.log("DiscoveryComponent constructor init.");
  }

  tabChange(event){
    //doSomething when tab change
  }
}
