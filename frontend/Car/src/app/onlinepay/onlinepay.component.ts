import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { OnlinepayService } from '../shared/onlinepay/onlinepay.service';

@Component({
  selector: 'app-onlinepay',
  templateUrl: './onlinepay.component.html',
  styleUrls: ['./onlinepay.component.css'],
  
})
export class OnlinepayComponent implements OnInit {

  Member: any
  Distance: Array<any>
  Driver: Array<any>
  Money: Array<any>
  Bank : Array<any>

  member_id : any
  bank_id : any
  driver_id : any
  distance : Number
  money : any
  moneypay : Number
  onlinepay : any

  isShow:boolean = false;
  isShow2:boolean = false;

      setShow(){
        if(this.isShow == true){
          this.isShow = false; 
        }else{
          this.isShow = true;
        }
        this.moneypay= this.distance
      }

      setShow2(){
        if(this.isShow2 == true){
          this.isShow2 = false; 
        }else{
          this.isShow2 = true;
        }
      }
      

  constructor(private httpClient: HttpClient, private router: Router, private onlinepayService: OnlinepayService) { }

  ngOnInit() {

    this.onlinepayService.getLoginMember().subscribe(data => {
      this.Member = data[0];
      console.log(this.Member);
    });


    this.onlinepayService.getDriver().subscribe(data => {
      this.Driver = data;
      console.log(this.Driver);
    });

    this.onlinepayService.getMoney().subscribe(data => {
      this.Money = data;
      console.log(this.Money);
    });

    this.onlinepayService.getBank().subscribe(data => {
      this.Bank = data;
      console.log(this.Bank);
    });
  }

  save(){
    console.log("in save");
    console.log(this.distance+'is distande');console.log(this.moneypay+'ismoney');console.log(this.Member.id+'is member');console.log(this.driver_id.id+'is iD');console.log(this.bank_id.id+'Ba ID');

    this.httpClient.post('http://localhost:8080/OnlinePay/'+this.distance+'/'+this.moneypay+'/'+this.Member.member.id+'/'+this.driver_id+'/'+this.bank_id,this.onlinepay)
    .subscribe(
      data => {
        alert("บันทึกสำเร็จ")
       }
     );
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

  save_bank(bank_id){
    console.log(bank_id);
    this.bank_id = bank_id; 
  }
  // save_level(bank_id){
  //   console.log(bank_id);
  //   this.bank_id = bank_id;
  // }

}
