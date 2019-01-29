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

  // Bank: Array<any>
  // Money: Array<any>
  // Moneypay: Array<any>
  // Member : Array<any>
  OnlinePay : Array<any>
  num :any
  // member_id : any
  // bank_id : any
  // money : any
  // moneypay : any

  constructor(private httpClient: HttpClient, private router: Router, private transectionService: TransectionService ) { }

  ngOnInit() {

    this.transectionService.getOnlinePay().subscribe(data => {
      this.OnlinePay = data;
      this.num = data.length
      console.log(this.OnlinePay);
      console.log(this.num);
    });


  }

 




  
}
