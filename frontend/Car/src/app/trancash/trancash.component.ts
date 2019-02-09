import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { CashpayService } from '../shared/Cashpay/cashpay.service';
@Component({
  selector: 'app-trancash',
  templateUrl: './trancash.component.html',
  styleUrls: ['./trancash.component.css']
})
export class TrancashComponent implements OnInit {
  
  cashpay : Array<any>
  num :any

  constructor(private httpClient: HttpClient, private router: Router, private CashpayService: CashpayService) { }

  ngOnInit() {this.CashpayService.getCashpay().subscribe(data => {
    this.cashpay = data;
    this.num = data.length
    console.log(this.cashpay);
    console.log(this.num);
  });
  }

}
