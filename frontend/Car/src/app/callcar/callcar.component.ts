import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { CallcarService } from '../shared/Callcar/callcar.service';

@Component({
  selector: 'app-callcar',
  templateUrl: './callcar.component.html',
  styleUrls: ['./callcar.component.css']
})
export class CallcarComponent implements OnInit {

  
  LoginMember: any
  CarType: Array<any>
  Driver: Array<any>

  Dest: any
  Cur: any
  cartype_id: any
  driver_id: any

  callcar: any

  constructor(private httpClient: HttpClient, private router: Router, private callcarService: CallcarService) { }

  ngOnInit() {
    this.callcarService.getLoginMember().subscribe(data => {
      this.LoginMember = data[0];
      console.log(this.LoginMember);
    });

    this.callcarService.getCarType().subscribe(data => {
      this.CarType = data;
      console.log(this.CarType);
    });

    this.callcarService.getDriver().subscribe(data => {
      this.Driver = data;
      console.log(this.Driver);
    });
  }

  savecartype(cartype_id){
    console.log(cartype_id);
    this.cartype_id = cartype_id;
  }

  savedriver(driver_id){
    console.log(driver_id);
    this.driver_id = driver_id;
  }

  save(){
    console.log("saved");
    this.httpClient.post('http://localhost:8080/Callcar/'+this.Dest+'/'+this.Cur+'/'+this.cartype_id+'/'+this.driver_id+'/'+this.LoginMember.member.id,this.callcar)
    .subscribe(
      data => {
        alert("Saved")
       }
     );
     this.router.navigate(['/callcarsum']);
     console.log(this.Dest+'/'+this.Cur+'/'+this.cartype_id+'/'+this.driver_id+'/'+this.LoginMember);
  }

}
