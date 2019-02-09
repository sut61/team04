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
  Score:Array<any>
  MemberLogin : any

  ID_Score:any
  ID_Driver: any
  comment:any
  
  point:Number

  com:any
  typeSelec:any
  type:any

  message:boolean = false
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

    this.comentService.getLoginMember().subscribe(data => {
      this.MemberLogin = data[0];
      console.log(this.MemberLogin.member);
    });

    this.comentService.getScore().subscribe(data => {
      this.Score = data;
      console.log(this.Score);
    });

    
  }

  testSave(){
    if(this.comment!=null&&this.typeSelec==1&&this.comment.length!>=5){
    if(this.type=="true"){
    console.log(this.MemberLogin.member.name)
    this.httpClient.post('http://localhost:8080/Comment1/'+this.comment+'/'+this.ID_Driver.name+'/'+this.MemberLogin.member.name+'/'+this.ID_Driver.tel+'/'+this.MemberLogin.member.phone+'/'+this.ID_Score.id+'/'+this.ID_Driver.id+'/'+this.MemberLogin.member.id,this.com)
    .subscribe(
      data => {
        alert("บันทึกสำเร็จ")
        this.router.navigate(['/CommentDescription']); 

       }
     );
    }else if(this.type == "false"){
      console.log(this.MemberLogin.member.name)
    this.httpClient.post('http://localhost:8080/Comment2/'+this.comment+'/'+this.ID_Driver.name+'/'+this.MemberLogin.member.name+'/'+this.ID_Driver.tel+'/'+this.MemberLogin.member.phone+'/'+this.ID_Score.id+'/'+this.ID_Driver.id+'/'+this.MemberLogin.member.id,this.com)
    .subscribe(
      data => {
        alert("บันทึกสำเร็จ")
        this.router.navigate(['/CommentDescription']); 
       }
     );
    }
  }else{
    this.message = true
  }
  }

  setDriver(name :any){
    this.typeSelec = 1
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

  saveScore(ID_Score){
    this.ID_Score = ID_Score
    console.log(this.ID_Score)
  }

  

}
