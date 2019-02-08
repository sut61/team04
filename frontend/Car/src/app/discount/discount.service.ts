import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DiscountService {

  public API = '//localhost:8080';
  constructor(private http: HttpClient) {  }


  getTimeRange(): Observable<any> {
    return this.http.get(this.API + '/timeRange/');
  }
  getAdmin(): Observable<any> {
    return this.http.get(this.API + '/admin/');
  }
  getCarType(): Observable<any> {
    return this.http.get(this.API + '/CarType/');
  }
}
