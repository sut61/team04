import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { MemberService } from '../shared/Member/member.service';

@Component({
  selector: 'app-member',
  templateUrl: './member.component.html',
  styleUrls: ['./member.component.css']
})
export class MemberComponent implements OnInit {
  Gender: Array<any>
  Province: Array<any>
  CarType: Array<any>
  
  gender_id: any
  province_id: any
  cartype_id: any
  member: any

  username: any
  password: any
  name: any
  address: any
  phone: any
  constructor(private httpClient: HttpClient, private router: Router, private memberService: MemberService) { }

  ngOnInit() {
    this.memberService.getGender().subscribe(data => {
      this.Gender = data;
      console.log(this.Gender);
    });

    this.memberService.getProvince().subscribe(data => {
      this.Province = data;
      console.log(this.Province);
    });

    this.memberService.getCarType().subscribe(data => {
      this.CarType = data;
      console.log(this.CarType);
    });
  }

  savegender(gender_id){
    console.log(gender_id);
    this.gender_id = gender_id;
  }

  savecartype(cartype_id){
    console.log(cartype_id);
    this.cartype_id = cartype_id;
  }

  saveprovince(province_id){
    console.log(province_id);
    this.province_id = province_id;
  }

  save(){
    console.log("insave");
    this.httpClient.post('http://localhost:8080/Member/'+this.username+'/'+this.password+'/'+
    this.name+'/'+this.address+'/'+this.phone+'/'+this.gender_id+'/'+this.province_id+'/'+
    this.cartype_id,this.member)
    .subscribe(
      data => {
        alert("บันทึกสำเร็จ")
       }
     );
  }

}
