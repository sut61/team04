import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { LoginMemberService } from '../shared/LoginMember/login-member.service';

@Component({
  selector: 'app-login-member',
  templateUrl: './login-member.component.html',
  styleUrls: ['./login-member.component.css']
})
export class LoginMemberComponent implements OnInit {
  Member: Array<any>
  username:any
  password:any
  login:any
  id_member:any
  constructor(private httpClient: HttpClient, private router: Router, private loginMemberService: LoginMemberService) { }

  ngOnInit() {
    this.loginMemberService.getMember().subscribe(data => {
      this.Member = data;
      console.log(this.Member);
    });
  }

  save(){
    console.log("in save");
    var c =true;
    for(let check of this.Member){
        if(this.username==check.username&&this.password==check.password){
          this.id_member= check
          this.httpClient.post('http://localhost:8080/LoginMember1/'+this.id_member.id,this.login)          
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
