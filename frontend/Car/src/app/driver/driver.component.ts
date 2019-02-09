import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { DriverService } from '../shared/Driver/driver.service';

@Component({
  selector: 'app-driver',
  templateUrl: './driver.component.html',
  styleUrls: ['./driver.component.css']
})
export class DriverComponent implements OnInit {
  Gender: Array<any>
  Province: Array<any>
  CarType: Array<any>

  gender_id1: any
  province_id1: any
  cartype_id1: any
  driver: any

  username: any
  password: any
  name: any
  address: any
  tel: any
  email: any
  constructor(private httpClient: HttpClient, private router: Router, private driverService: DriverService) { }

  ngOnInit() {
    this.driverService.getGender().subscribe(data => {
      this.Gender = data;
      console.log(this.Gender);
    });

    this.driverService.getProvince().subscribe(data => {
      this.Province = data;
      console.log(this.Province);
    });

    this.driverService.getCarType().subscribe(data => {
      this.CarType = data;
      console.log(this.CarType);
    });
  }

  savegender(gender_id1){
    console.log(gender_id1);
    this.gender_id1 =  gender_id1;
  }

  savecartype(cartype_id1){
    console.log(cartype_id1);
    this.cartype_id1 = cartype_id1;
  }

  saveprovince(province_id1){
    console.log(province_id1);
    this.province_id1 = province_id1;
  }

  save(){
    console.log("insave");
    this.httpClient.post('http://localhost:8080/Driver/'+this.gender_id1+'/'+this.province_id1+'/'+this.cartype_id1+'/'+this.name+'/'+this.tel+'/'+this.address+'/'+this.email+'/'+this.username+'/'+this.password,this.driver)
    .subscribe(
      data => {
        //alert("บันทึกสำเร็จ")
        this.router.navigate(['savefinish'])
       }
       
     );
  }

}
