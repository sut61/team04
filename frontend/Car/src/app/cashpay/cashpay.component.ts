import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { CashpayService } from '../shared/Cashpay/cashpay.service';


@Component({
    selector: 'app-cashpay',
    templateUrl: './cashpay.component.html',
    styleUrls: ['./cashpay.component.css']
})
export class CashpayComponent implements OnInit {

  Member: any
  Distance: Array<any>
  Driver: any
  Money: Array<any>
  Gift : Array<any>

  member_id : any
  driver_id : any
  driver_name : any
  distance : any
  moneypay : any
  gift_id : any
  money : any
  change : any
  cashpay : any
  dis : any
  mon : any
  tel : any
  dnam : any

  isShow3:boolean = false;
  isShow4:boolean = false;
  isShow5:boolean = false;


      setShow(){
        if(this.isShow3 == true ){
          this.isShow3 = false; 
        }else if(this.tel==this.Member.member.phone){
          this.isShow3 = true;
        }
        else{
          alert("ไม่ได้เป็นสมาชิก")
          this.isShow4 = true;
        
        }
     
      }

      setShow2(){
        if(this.isShow5 == true ){
          this.isShow5 = false; 
        }else if(this.dnam==this.Driver.name){
          this.isShow5 = true;
        }
        else{
          alert("ไม่ได้เป็นสมาชิก")
        
        }
     
      }



  constructor(private httpClient: HttpClient, private router: Router, private cashpayService: CashpayService) { }

  ngOnInit() {

    this.cashpayService.getLoginMember().subscribe(data => {
      this.Member = data[0];
      console.log(this.Member);
    });


    this.cashpayService.getDriver().subscribe(data => {
      this.Driver = data[0];
      console.log(this.Driver);
    });

    // this.cashpayService.getMoney().subscribe(data => {
    //   this.Money = data;
    //   console.log(this.Money);
    // });

    this.cashpayService.getGift().subscribe(data => {
      this.Gift = data;
      console.log(this.Gift);
    });
  
  }

  save(){
    var a = this.mon -(this.dis*3) 
    this.change = a
    //this.Distance = this.dis
    //this.Money = this.mon
    console.log("in save");
    console.log(this.Driver.id+'is iD');console.log(this.Driver.name+'is Dname');console.log(this.distance+'is distande');console.log(this.moneypay+'ismoney');console.log(this.change+'is change');console.log(this.Member.member.id+'is member');console.log(this.gift_id+'gift ID');

    this.httpClient.post('http://localhost:8080/CashPay/'+this.Driver.id+'/'+this.Driver.name+'/'+this.distance+'/'+this.moneypay+'/'+this.change+'/'+this.Member.member.id+'/'+this.gift_id,this.cashpay)
    .subscribe(
      data => {
        alert("บันทึกสำเร็จ")
       }
     );
  }

    save2(){
      var a = this.mon -(this.dis*3) 
      this.change = a
    
      console.log("in save2");
      console.log(this.Driver.id+'is iD');console.log(this.Driver.name+'is Dname');console.log(this.distance+'is distance');console.log(this.moneypay+'ismoney');console.log(this.change+'is change');

      this.httpClient.post('http://localhost:8080/CashPay2/'+this.Driver.id+'/'+this.Driver.name+'/'+this.distance+'/'+this.moneypay+'/'+this.change,this.cashpay)
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

  savedrivern(driver_name){
    console.log(driver_name);
    this.driver_name = driver_name;
  }

  savedistance(distance){
    console.log(distance);
    this.distance = distance;
  }

  savemoney(money){
    console.log(money);
    this.money = money;
  }

  save_gift(gift_id){
    console.log(gift_id);
    this.gift_id = gift_id; 
  }
  
  savechange(change){
    console.log(change);
    this.change = change;
  }

}

