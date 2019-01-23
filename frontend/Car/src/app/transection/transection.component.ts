import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { TransectionService } from '../shared/transection/transection.service';

@Component({
  selector: 'app-transection',
  templateUrl: './transection.component.html',
  styleUrls: ['./transection.component.css']
})
export class TransectionComponent implements OnInit {

  Bank: Array<any>
  Money: Array<any>
  Moneypay: Array<any>
  Member : Array<any>

  member_id : any
  bank_id : any
  money : any
  moneypay : any

  constructor(private httpClient: HttpClient, private router: Router, private transectionService: TransectionService) { }

  ngOnInit() {

    this.transectionService.getMember().subscribe(data => {
      this.Member = data;
      console.log(this.Member);
    });

    this.transectionService.getBank().subscribe(data => {
      this.Bank = data;
      console.log(this.Bank);
    });

    this.transectionService.getMoney().subscribe(data => {
      this.Money = data;
      console.log(this.Money);
    });

    this.transectionService.getMoneypay().subscribe(data => {
      this.Moneypay = data;
      console.log(this.Moneypay);
    });

  }

  savemember(member_id){
    console.log(member_id);
    this.member_id = member_id;
  }

  savebank(bank_id){
    console.log(bank_id);
    this.bank_id = bank_id;
  }

  savemoney(money){
    console.log(money);
    this.money = money;
  }
  savemoneypay(moneypay){
    console.log(moneypay);
    this.moneypay = moneypay;
  }

}
