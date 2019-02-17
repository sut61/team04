import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SalaryService {

  public API = '//localhost:8080';
  constructor(private http: HttpClient) {  }

  getAdmin(): Observable<any> {
    return this.http.get(this.API + '/admin/');
  }
  getDriver(): Observable<any> {
    return this.http.get(this.API + '/driver/');
  }
  
  getPosition(): Observable<any> {
    return this.http.get(this.API + '/position/');
  }
  getSalary(): Observable<any> {
    return this.http.get(this.API + '/salary/');
  }
}
