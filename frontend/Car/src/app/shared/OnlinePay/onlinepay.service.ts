import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OnlinepayService {

  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  getLoginMember(): Observable<any> {
    return this.http.get(this.API + '/loginmember/');
  }
  getDistance(): Observable<any> {
    return this.http.get(this.API + '/Distance/');
  }
  getDriver(): Observable<any> {
    return this.http.get(this.API + '/Driver/');
  }
  getMoney(): Observable<any> {
    return this.http.get(this.API + '/Money/');
  }

  getBank(): Observable<any> {
    return this.http.get(this.API + '/Bank/');
  }
}
