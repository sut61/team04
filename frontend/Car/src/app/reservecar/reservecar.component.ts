import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { ReservecarService } from '../shared/Reservecar/reservecar.service';


@Component({
  selector: 'app-reservecar',
  templateUrl: './reservecar.component.html',
  styleUrls: ['./reservecar.component.css']
})
export class ReservecarComponent implements OnInit {
  
  LoginMember: any
  CarType: Array<any>
  Driver: Array<any>
  Unavailable: Array<any>

  Dest: any
  Cur: any
  DD: any
  MM: any
  YY: any
  HH: any
  Mi: any
  hidenull:boolean = false
  hidedate:boolean = false
  hideplace:boolean = false
  hidedr:boolean = false
  cartype_id: any
  driver_id: any
  unavailablechck:boolean = false

  reservecar: any

  constructor(private httpClient: HttpClient, private router: Router, private reservecarService: ReservecarService) { }

  ngOnInit() {
    this.reservecarService.getLoginMember().subscribe(data => {
      this.LoginMember = data[0];
      console.log(this.LoginMember);
    });

    this.reservecarService.getCarType().subscribe(data => {
      this.CarType = data;
      console.log(this.CarType);
    });

    this.reservecarService.getDriver().subscribe(data => {
      this.Driver = data;
      console.log(this.Driver);
    });

    this.reservecarService.getUnavailable().subscribe(data => {
      this.Unavailable = data;
      console.log(this.Unavailable.length);
    });
  }

  savecartype(cartype_id){
    console.log(cartype_id);
    this.cartype_id = cartype_id;
  }

  savedriver(driver_id){
    this.driver_id = driver_id;

    if(this.Unavailable.length == 0){
      this.unavailablechck = true;
    }else if(this.Unavailable.length > 0){

      for(var i = 0;i<this.Unavailable.length;i++) { 
        if(this.driver_id == this.Unavailable[i].driver.id){
          this.unavailablechck = false;
          this.hidedr= true;
          setTimeout(function() {
          this.hidedr = false;
          }.bind(this), 5000);
          var i = this.Unavailable.length;
        }else if(this.driver_id != this.Unavailable[i].driver.id){
          this.unavailablechck = true;
          this.hidedr= false;
        }
        console.log(this.Unavailable[i]) 
    }
  }
    /* if(this.driver_id === this.Unavailable[0].driver.id){
      this.hidedr = true;
      setTimeout(function() {
        this.hidedr = false;
      }.bind(this), 5000);
      this.driver_id = null;
    }else{
    console.log(driver_id);
    this.driver_id = driver_id;
  } */
  }

// ************************************************************************************************

  numberOnly(event): boolean {
    const charCode = (event.which) ? event.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
      return false;
    }
    return true;

  }

// ************************************************************************************************  

  save(){

    if (this.Dest == null || this.Cur == null || this.DD == null || this.MM == null || this.YY == null || this.HH == null || this.Mi == null || this.cartype_id == null || this.driver_id == null){
      this.hidenull = true;
      setTimeout(function() {
        this.hidenull = false;
      }.bind(this), 5000);
    }else if(this.DD < 1 || this.DD > 31 || this.MM < 1 || this.MM > 12 || this.YY < 19){
      this.hidedate = true;
      setTimeout(function() {
        this.hidedate = false;
      }.bind(this), 5000);
    }else if(this.Dest === this.Cur){
      this.hideplace = true;
      setTimeout(function() {
        this.hideplace = false;
      }.bind(this), 5000);
    }else if(this.unavailablechck == false){
      this.hidedr= true;
      setTimeout(function() {
        this.hidedr = false;
      }.bind(this), 5000);
    }else{

      this.httpClient.post('http://localhost:8080/Unavailable/'+this.driver_id,this.reservecar)
    .subscribe(
      data => {
        console.log("saved");
        console.log(this.driver_id);
       }
     );

      this.httpClient.post('http://localhost:8080/Reservecar/'+this.Dest+'/'+this.Cur+'/'+this.DD+'-'+this.MM+'-'+this.YY+'/'+this.HH+':'+this.Mi+'/'+this.cartype_id+'/'+this.driver_id+'/'+this.LoginMember.member.id,this.reservecar)
    .subscribe(
      data => {
        this.hidenull = false;
        console.log("saved");
        this.router.navigate(['/reservesum']);
        console.log(this.Dest+'/'+this.Cur+'/'+this.DD+'-'+this.MM+'-'+this.YY+'/'+this.cartype_id+'/'+this.driver_id+'/'+this.LoginMember);
       }
     );
    }
  }

}
