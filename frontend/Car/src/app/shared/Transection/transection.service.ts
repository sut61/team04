import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransectionService {

  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  
  getOnlinePay(): Observable<any> {
    return this.http.get(this.API + '/onlinepay/');
  }
  
}
