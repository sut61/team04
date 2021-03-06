import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginMemberService {

  public API = '//localhost:8080';
  constructor(private http: HttpClient) {  }

  getMember(): Observable<any> {
    return this.http.get(this.API + '/Member/');
  }
  getember(): Observable<any> {
    return this.http.get(this.API + '/Score/');
  }
  
}
