import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { EmergencyService } from '../shared/Emergency/emergency.service';
@Component({
  selector: 'app-emergency',
  templateUrl: './emergency.component.html',
  styleUrls: ['./emergency.component.css']
})
export class EmergencyComponent implements OnInit {
  Driver: Array<any>
  Member: Array<any>
  Cause: Array<any>
  PriceType: Array<any>

  driver_id: any
  member_id: any
  cause_id: any
  pricetype_id: any
  emergency: any

  position: any
  phone: any

  constructor(private httpClient: HttpClient, private router: Router, private emergencyService: EmergencyService) { }
  
  ngOnInit() {
    this.emergencyService.getDriver().subscribe(data => {
      this.Driver = data;
      console.log(this.Driver);
    });

    this.emergencyService.getMember().subscribe(data => {
      this.Member = data;
      console.log(this.Member);
    });

    this.emergencyService.getCause().subscribe(data => {
      this.Cause = data;
      console.log(this.Cause);
    });

    this.emergencyService.getPriceType().subscribe(data => {
      this.PriceType = data;
      console.log(this.PriceType);
    });
  }

  
  savedriver(driver_id){
    console.log(driver_id);
    this.driver_id =  driver_id;
  }

  savemember(member_id){
    console.log(member_id);
    this.member_id = member_id;
  }

  savecause(cause_id){
    console.log(cause_id);
    this.cause_id = cause_id;
  }

  savepriceType(pricetype_id){
    console.log(pricetype_id);
    this.pricetype_id = pricetype_id;
  }

  save(){
    console.log("insave");
    this.httpClient.post('http://localhost:8080/Emergency/'+this.position+'/'+this.phone+'/'+this.cause_id+'/'+this.member_id+'/'+this.driver_id+'/'+this.pricetype_id,this.emergency)
    .subscribe(
      data => {
        //alert("บันทึกสำเร็จ")
        this.router.navigate(['savefinish'])
       }
     );
  }

}
