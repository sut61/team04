import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {  Router } from '@angular/router';
import {ComentService} from '../shared/Coment/coment.service';

@Component({
  selector: 'app-comment-description',
  templateUrl: './comment-description.component.html',
  styleUrls: ['./comment-description.component.css']
})
export class CommentDescriptionComponent implements OnInit {
  comment:Array<any>

  constructor(private httpClient: HttpClient,private router: Router,private comentService: ComentService) { }

  ngOnInit() {
    this.comentService.getComment().subscribe(data => {
      this.comment = data;
      console.log(this.comment);
    });
  }

}
