import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {  Router } from '@angular/router';
import {ComplainService} from '../shared/Complain/complain.service';

@Component({
  selector: 'app-complain-description',
  templateUrl: './complain-description.component.html',
  styleUrls: ['./complain-description.component.css']
})
export class ComplainDescriptionComponent implements OnInit {
Complain : Array<any>
  constructor(private httpClient: HttpClient,private router: Router,private complainService: ComplainService) { }

  ngOnInit() {
    this.complainService.getComplain().subscribe(data => {
      this.Complain = data;
      console.log(this.Complain);
    });
  }

}
