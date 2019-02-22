import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { SalaryService } from '../shared/Salary/salary.service';

@Component({
  selector: 'app-salary',
  templateUrl: './salary.component.html',
  styleUrls: ['./salary.component.css']
})
export class SalaryComponent implements OnInit {
  Admin: Array<any>
  Driver: Array<any>
  Position: Array<any>

  admin_id: any
  driver_id: any
  position_id: any
  salary: any
  message:boolean = false


  date: any
  price: any
  payment: any
  constructor(private httpClient: HttpClient, private router: Router, private salaryService: SalaryService) { }
  ngOnInit() {
   
    this.salaryService.getAdmin().subscribe(data => {
      this.Admin = data;
      console.log(this.Admin);
    });
  
    this.salaryService.getDriver().subscribe(data => {
      this.Driver = data;
      console.log(this.Driver);
    });

    this.salaryService.getPosition().subscribe(data => {
      this.Position = data;
      console.log(this.Position);
    });
  }
  
  
  saveadmin(admin_id){
    console.log(admin_id);
    this.admin_id = admin_id;
  }

  savedriver(driver_id){
    console.log(driver_id);
    this.driver_id =  driver_id;
  }
  saveposition(position_id){
    console.log(position_id);
    this.position_id = position_id;
  }
  
  save(){
    if(this.admin_id!=null&&this.driver_id!=null&&this.position_id!=null&&this.date!&&this.payment!=null&&this.price!){

    console.log("insave");
    this.httpClient.post('http://localhost:8080/Salary/'+this.admin_id.name+'/'+this.driver_id.name+'/'+this.position_id.name+'/'+this.driver_id.tel+'/'+this.date+'/'+this.price+'/'+this.payment+'/'+this.admin_id.id+'/'+this.driver_id.id+'/'+this.position_id.id,this.salary)
    .subscribe(
      data => {
        alert("บันทึกสำเร็จ")
        this.router.navigate(['salaryshow'])
      }
      );
   
   }else {
     this.message=true
   }
   
   }
   }
   