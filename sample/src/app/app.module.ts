import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {Location} from '@angular/common';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { AdminsigninComponent } from './adminsignin/adminsignin.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'
import { SampleserviceService } from './services/sampleservice.service';
import { AdminModule } from './admin/admin.module';
import { CustomerloginComponent } from './customerlogin/customerlogin.component';
import { CustomersigininComponent } from './customersiginin/customersiginin.component';
import {MatDialogModule} from '@angular/material/dialog';
import { ScrollStrategy } from '@angular/cdk/overlay';
import { ContentsComponent } from './contents/contents.component';
import { CustomerModule } from './customer/customer.module';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    AdminsigninComponent,
    CustomerloginComponent,
    CustomersigininComponent,
    ContentsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatDialogModule,
    FormsModule,ReactiveFormsModule,
    HttpClientModule,
    AdminModule,
    CustomerModule,

  ],
  providers: [SampleserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
