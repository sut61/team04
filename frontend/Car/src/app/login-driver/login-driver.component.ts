import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { LoginDriverService } from '../shared/LoginDriver/login-driver.service';

@Component({
  selector: 'app-login-driver',
  templateUrl: './login-driver.component.html',
  styleUrls: ['./login-driver.component.css']
})
export class LoginDriverComponent implements OnInit {
  Driver: Array<any>
  username:any
  password:any
  login:any
  id_driver:any
  constructor(private httpClient: HttpClient, private router: Router, private loginDriverService: LoginDriverService) { }

  ngOnInit() {
    this.loginDriverService.getDriver().subscribe(data => {
      this.Driver = data;
      console.log(this.Driver);
    });
  }

  save(){
    console.log("in save");
    var c =true;
    for(let check of this.Driver){
        if(this.username==check.username&&this.password==check.password){
          this.id_driver= check
          this.httpClient.post('http://localhost:8080/LoginDriver/'+this.id_driver.id,this.login)          
          .subscribe(
          data => {
          alert("เข้าสู่ระบบสำเร็จ")
          }
          );
          this.router.navigate(['/menu']);  
          var c =false;
        }else{
          var c =true;
        }

    }

    if(c){
      alert("เข้้าสู่ระบบล้มเหลว Username หรือ password ไม่ถูกต้อง")
    }

  }

}
