import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ComplainService {

  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  getDriver(): Observable<any> {
    console.log("in get Driver");
    return this.http.get(this.API + '/driver/');
  }
  getComplain(): Observable<any> {
    console.log("in get Complain");
    return this.http.get(this.API + '/Complain/');
  }
  getDriverTaxi(): Observable<any> {
    console.log("in get DriverTaxi");
    return this.http.get(this.API + '/DriverTaxi/');
  }
  getLoginMember(): Observable<any> {
    return this.http.get(this.API + '/loginmember/');
  }
}
