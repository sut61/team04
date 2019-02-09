import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { DriverpctService } from '../shared/DriverPCT/driverpct.service';

@Component({
  selector: 'app-driverpct',
  templateUrl: './driverpct.component.html',
  styleUrls: ['./driverpct.component.css']
})
export class DriverpctComponent implements OnInit {

  Gender: Array<any>
  Province: Array<any>
  Career: Array<any>

  gender_id: any
  province_id: any
  career_id: any
  driverpct: any

  username: any
  password: any
  name: any
  address: any
  vehicletype: any
  phone: any

  constructor(private httpClient: HttpClient, private router: Router, 
    private driverpctService: DriverpctService) { }
    

  ngOnInit() {
    this.driverpctService.getGender().subscribe(data => {
      this.Gender = data;
      console.log(this.Gender);
    });

    this.driverpctService.getProvince().subscribe(data => {
      this.Province = data;
      console.log(this.Province);
    });

    this.driverpctService.getCareer().subscribe(data => {
      this.Career = data;
      console.log(this.Career);
    });
  }

    savegender(gender_id){
      console.log(gender_id)
      this.gender_id = gender_id;
    }

    saveprovince(province_id){
      console.log(province_id);
      this.province_id = province_id;
    }
  
    savecareer(career_id){
      console.log(career_id);
      this.career_id = career_id;
    }

    
    save(){
      console.log("insave");
      this.httpClient.post('http://localhost:8080/DriverPCT/'+this.username+'/'+this.password+'/'+
      this.name+'/'+this.address+'/'+this.vehicletype+'/'+this.phone+'/'+this.gender_id+'/'+this.province_id+'/'+
      this.career_id,this.driverpct)
      .subscribe(
        data => {
          alert("บันทึกสำเร็จ")
         }
       );
    }
}
