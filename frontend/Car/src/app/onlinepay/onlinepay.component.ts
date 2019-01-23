import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { OnlinepayService } from '../shared/onlinepay/onlinepay.service';

@Component({
  selector: 'app-onlinepay',
  templateUrl: './onlinepay.component.html',
  styleUrls: ['./onlinepay.component.css']
})
export class OnlinepayComponent implements OnInit {

  Member: Array<any>
  Distance: Array<any>
  Driver: Array<any>
  Money: Array<any>

  member_id : any
  driver_id : any
  distance : any
  money : any
  

  constructor(private httpClient: HttpClient, private router: Router, private onlinepayService: OnlinepayService) { }

  ngOnInit() {

    this.onlinepayService.getMember().subscribe(data => {
      this.Member = data;
      console.log(this.Member);
    });

    this.onlinepayService.getDistance().subscribe(data => {
      this.Distance = data;
      console.log(this.Distance);
    });

    this.onlinepayService.getDriver().subscribe(data => {
      this.Driver = data;
      console.log(this.Driver);
    });

    this.onlinepayService.getMoney().subscribe(data => {
      this.Money = data;
      console.log(this.Money);
    });

  }

  savemember(member_id){
    console.log(member_id);
    this.member_id = member_id;
  }

  savedriver(driver_id){
    console.log(driver_id);
    this.driver_id = driver_id;
  }

  savedistance(distance){
    console.log(distance);
    this.distance = distance;
  }

  savemoney(money){
    console.log(money);
    this.money = money;
  }

}
