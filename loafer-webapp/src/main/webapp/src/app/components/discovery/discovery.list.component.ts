import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";

@Component({
  templateUrl: './discovery.list.component.html',
  styleUrls: ['./discovery.component.css']
})

export class DiscoveryListComponent implements OnInit{
  ngOnInit(): void {
    console.log("DiscoveryListComponent init")
  }
  constructor(private router:Router){
    console.log("DiscoveryListComponent constructor init.");
  }

  navigateTo(link){
    console.log(link);
    this.router.navigate([link]);
  }
}
