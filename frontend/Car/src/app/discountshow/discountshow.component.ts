import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {  Router } from '@angular/router';
import {DiscountService} from '../shared/Discount/discount.service';
@Component({
  selector: 'app-discountshow',
  templateUrl: './discountshow.component.html',
  styleUrls: ['./discountshow.component.css']
})
export class DiscountshowComponent implements OnInit {

  discount:Array<any>


constructor(private httpClient: HttpClient,private router: Router,private discountService: DiscountService) { }

ngOnInit() {
  this.discountService.getDiscount().subscribe(data => {
    this.discount = data;
    console.log(this.discount);
  });
}

}
