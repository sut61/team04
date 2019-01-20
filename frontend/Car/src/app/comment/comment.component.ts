import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {  Router } from '@angular/router';
import {ComentService} from '../shared/Coment/coment.service';
@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {
  Driver : Array<any>
  Drivers : Array<any>
  DriverTaxi : Array<any>
  ID_Driver: any
  comment:String
  com:any
  point:Number

  type:any
  constructor(private httpClient: HttpClient,private router: Router,private comentService: ComentService) { }

  ngOnInit() {
    this.comentService.getDriver().subscribe(data => {
      this.Driver = data;
      console.log(this.Driver);
    });
    this.comentService.getDriverTaxi().subscribe(data => {
      this.DriverTaxi = data;
      console.log(this.DriverTaxi);
    });

    
    
  }

  testSave(){
    if(this.type=="true"){
    console.log(this.ID_Driver)
    this.httpClient.post('http://localhost:8080/Comment1/'+this.comment+'/'+this.ID_Driver,this.com)
    .subscribe(
      data => {
        alert("บันทึกสำเร็จ")
       }
     );
    }else if(this.type == "false"){
      console.log(this.ID_Driver)
    this.httpClient.post('http://localhost:8080/Comment2/'+this.comment+'/'+this.ID_Driver,this.com)
    .subscribe(
      data => {
        alert("บันทึกสำเร็จ")
       }
     );
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
