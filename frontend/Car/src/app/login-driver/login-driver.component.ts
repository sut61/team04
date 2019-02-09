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



}
