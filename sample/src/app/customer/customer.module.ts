import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerComponent } from './customer/customer.component';
import { CustomercontentComponent } from './customercontent/customercontent.component';
import { CartComponent } from './cart/cart.component';
import { AppRoutingModule } from '../app-routing.module';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { PaymentComponent } from './payment/payment.component';
import { SuccessfulComponent } from './successful/successful.component';


@NgModule({
  declarations: [
    CustomerComponent,
    CustomercontentComponent,
    CartComponent,
    PaymentComponent,
    SuccessfulComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    FormsModule
  ]
})
export class CustomerModule { }
