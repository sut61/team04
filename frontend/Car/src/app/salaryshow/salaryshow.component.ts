import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {  Router } from '@angular/router';
import {SalaryService} from '../shared/Salary/salary.service';
@Component({
  selector: 'app-salaryshow',
  templateUrl: './salaryshow.component.html',
  styleUrls: ['./salaryshow.component.css']
})
export class SalaryshowComponent implements OnInit {

salary:Array<any>


constructor(private httpClient: HttpClient,private router: Router,private salaryService: SalaryService) { }

ngOnInit() {
  this.salaryService.getSalary().subscribe(data => {
    this.salary = data;
    console.log(this.salary);
  });
}

}