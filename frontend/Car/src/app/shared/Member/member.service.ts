import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MemberService {

  public API = '//localhost:8080';
  constructor(private http: HttpClient) {  }

  getGender(): Observable<any> {
    return this.http.get(this.API + '/Gender/');
  }
  getProvince(): Observable<any> {
    return this.http.get(this.API + '/Province/');
  }
  getCarType(): Observable<any> {
    return this.http.get(this.API + '/CarType/');
  }
}
