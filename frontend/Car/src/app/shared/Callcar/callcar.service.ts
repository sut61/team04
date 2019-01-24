import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CallcarService {


  public API = '//localhost:8080';
  constructor(private http: HttpClient) {  }

  getCarType(): Observable<any> {
    return this.http.get(this.API + '/CarType/');
  }

  getDriver(): Observable<any> {
    return this.http.get(this.API + '/driver/');
  }

  getLoginMember(): Observable<any> {
    return this.http.get(this.API + '/loginmember/');
  }
}
