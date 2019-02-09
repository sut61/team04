import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginDriverService {

  public API = '//localhost:8080';
  constructor(private http: HttpClient) {  }

  getDriver(): Observable<any> {
    return this.http.get(this.API + '/Driver/');
  }

  
}
