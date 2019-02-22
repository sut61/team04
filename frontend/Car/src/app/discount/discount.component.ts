import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { DiscountService } from '../shared/Discount/discount.service';
@Component({
  selector: 'app-discount',
  templateUrl: './discount.component.html',
  styleUrls: ['./discount.component.css']
})
export class DiscountComponent implements OnInit {
  TimeRange: Array<any>
  Admin: Array<any>
  CarType: Array<any>

  timeRange_id: any
  admin_id: any
  cartype_id: any
  discount: any
  message:boolean = false

  promotion: any
  date: any
  price: any
  constructor(private httpClient: HttpClient, private router: Router, private discountService: DiscountService) { }

  ngOnInit() {


  this.discountService.getTimeRange().subscribe(data => {
    this.TimeRange = data;
    console.log(this.TimeRange);
  });
  this.discountService.getAdmin().subscribe(data => {
    this.Admin = data;
    console.log(this.Admin);
  });

  this.discountService.getCarType().subscribe(data => {
    this.CarType = data;
    console.log(this.CarType);
  });
}

savetimeRange(timeRange_id){
  console.log(timeRange_id);
  this.timeRange_id =  timeRange_id;
}

savecartype(cartype_id){
  console.log(cartype_id);
  this.cartype_id = cartype_id;
}

saveadmin(admin_id){
  console.log(admin_id);
  this.admin_id = admin_id;
}

save(){
  if(this.admin_id!=null&&this.cartype_id!=null&&this.promotion!=null&&this.date!&&this.timeRange_id!=null&&this.price!){
  console.log("insave");
  this.httpClient.post('http://localhost:8080/Discount/'+this.admin_id+'/'+this.cartype_id+'/'+this.promotion+'/'+this.date+'/'+this.timeRange_id+'/'+this.price,this.discount)
  .subscribe(
    data => {
      alert("บันทึกสำเร็จ")
      this.router.navigate(['discountshow'])
      
     }
   );

}else {
  this.message=true
}

}
}
