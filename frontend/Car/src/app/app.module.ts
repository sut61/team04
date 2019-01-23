import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CommentComponent } from './comment/comment.component';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule,MatSelectModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import {MatRadioModule} from '@angular/material/radio';
import { MemberComponent } from './member/member.component';
import { CallcarComponent } from './callcar/callcar.component';
import { DriverComponent } from './driver/driver.component';
import { LoginMemberComponent } from './login-member/login-member.component';
import { MenuComponent } from './menu/menu.component';

const appRoutes: Routes = [
  { path: 'Comment', component: CommentComponent },
  { path: 'member', component: MemberComponent },
  { path: 'callcar', component: CallcarComponent },
  { path: 'driver', component: DriverComponent },
  { path: 'login', component: LoginMemberComponent },
  { path: 'menu', component: MenuComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    CommentComponent,
    MemberComponent,
    CallcarComponent,
    DriverComponent,
    LoginMemberComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatSelectModule,
    FormsModule,
    MatRadioModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
