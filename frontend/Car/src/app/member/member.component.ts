import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {  Router } from '@angular/router';

@Component({
  selector: 'app-member',
  templateUrl: './member.component.html',
  styleUrls: ['./member.component.css']
})
export class MemberComponent implements OnInit {
name:any
  constructor() { }

  ngOnInit() {
  }

}
