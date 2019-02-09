import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {  Router } from '@angular/router';
import {ComplainService} from '../shared/Complain/complain.service';

@Component({
  selector: 'app-complain',
  templateUrl: './complain.component.html',
  styleUrls: ['./complain.component.css']
})
export class ComplainComponent implements OnInit {

  Driver : Array<any>
  Drivers : Array<any>
  DriverTaxi : Array<any>
  MemberLogin : any
  ID_Driver: any
  comment:String
  com:any
  point:Number

  message:boolean = false
  type:any
  constructor(private httpClient: HttpClient,private router: Router,private complainService: ComplainService) { }

  ngOnInit() {
    this.complainService.getDriver().subscribe(data => {
      this.Driver = data;
      console.log(this.Driver);
    });
    this.complainService.getDriverTaxi().subscribe(data => {
      this.DriverTaxi = data;
      console.log(this.DriverTaxi);
    });

    this.complainService.getLoginMember().subscribe(data => {
      this.MemberLogin = data[0];
      console.log(this.MemberLogin.member.id);
    });

    
    
  }

  testSave(){
    if(this.comment.length>4&&this.comment!=null){
    if(this.type=="true"){
    console.log(this.ID_Driver)
    console.log(this.MemberLogin.member.id)
    this.httpClient.post('http://localhost:8080/Complain1/'+this.comment+'/'+this.ID_Driver+'/'+this.MemberLogin.member.id,this.com)
    .subscribe(
      data => {
        //alert("บันทึกสำเร็จ")
        this.router.navigate(['/complaindescription']); 
       }
     );
    }else if(this.type == "false"){
      console.log(this.ID_Driver)
      console.log(this.MemberLogin.member.id)
    this.httpClient.post('http://localhost:8080/Complain2/'+this.comment+'/'+this.ID_Driver+'/'+this.MemberLogin.member.id,this.com)
    .subscribe(
      data => {
        //alert("บันทึกสำเร็จ")
        this.router.navigate(['/complaindescription']); 
       }
     );
    }

    }else {
      this.message=true
    }
  }

  setDriver(name :any){
    this.type = name
    console.log("This name =  "+name);
    if(name=="true"){
      console.log("in Set Driver ");
      this.Drivers = this.Driver
    }else if(name=="false"){
      console.log("in Set DriverTaxi ");
      this.Drivers = this.DriverTaxi
    }
  }

  saveDriver(ID_Driver){
    this.ID_Driver = ID_Driver
    console.log(ID_Driver)
  }


}
