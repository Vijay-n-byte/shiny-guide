import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { AdminComponent } from './admin/admin.component';
import { ChangepassComponent } from './changepass/changepass.component';
import { AppRoutingModule } from '../app-routing.module';
import { PopupaddComponent } from './popupadd/popupadd.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { PasswordComponent } from './password/password.component';


@NgModule({
  declarations: [
    AdminhomeComponent,
    AdminComponent,
    ChangepassComponent,
    PopupaddComponent,
    PasswordComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AdminModule { }
