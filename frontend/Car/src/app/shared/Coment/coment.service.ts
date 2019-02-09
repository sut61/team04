import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ComentService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  getDriver(): Observable<any> {
    console.log("in get Driver");
    return this.http.get(this.API + '/Driver/');
  }

  getDriverTaxi(): Observable<any> {
    console.log("in get Driver");
    return this.http.get(this.API + '/DriverTaxi/');
  }
  getScore(): Observable<any> {
    return this.http.get(this.API + '/Score/');
  }

  getLoginMember(): Observable<any> {
    return this.http.get(this.API + '/loginmember/');
  }

  getComment(): Observable<any> {
    return this.http.get(this.API + '/Comment/');
  }


}
