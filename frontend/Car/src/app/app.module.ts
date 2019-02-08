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
import { CallcarsumComponent } from './callcarsum/callcarsum.component';
import { OnlinepayComponent } from './onlinepay/onlinepay.component';
import { TransectionComponent } from './transection/transection.component';
import { DriverComponent } from './driver/driver.component';
import { ComplainComponent } from './Complain/complain.component';
import { LoginMemberComponent } from './login-member/login-member.component';
import { MenuComponent } from './menu/menu.component';
import {MatExpansionModule} from '@angular/material/expansion';
import { ComplainDescriptionComponent } from './complain-description/complain-description.component';
import { EmergencyComponent } from './emergency/emergency.component';


const appRoutes: Routes = [
  { path: 'Comment', component: CommentComponent },
  { path: 'member', component: MemberComponent },
  { path: 'callcar', component: CallcarComponent },
  { path: 'onlinepay', component: OnlinepayComponent },
  { path: 'transection', component: TransectionComponent },
  { path: 'callcarsum', component: CallcarsumComponent },
  { path: 'complain', component: ComplainComponent },
  { path: 'driver', component: DriverComponent },
  { path: 'login-member', component: LoginMemberComponent },
  { path: 'menu', component: MenuComponent },
  { path: 'complaindescription', component: ComplainDescriptionComponent },
  { path: '', redirectTo: 'login-member', pathMatch: 'full' },
  { path: 'emergency', component: EmergencyComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    CommentComponent,
    MemberComponent,
    CallcarComponent,
    CallcarsumComponent,
    OnlinepayComponent,
    TransectionComponent,
    DriverComponent,
    ComplainComponent,
    LoginMemberComponent,
    MenuComponent,
    ComplainDescriptionComponent,
    EmergencyComponent,

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
    MatRadioModule,
    MatExpansionModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
