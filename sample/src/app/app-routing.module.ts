import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminsigninComponent } from './adminsignin/adminsignin.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { AdminComponent } from './admin/admin/admin.component';
import { ChangepassComponent } from './admin/changepass/changepass.component';
import { AdminhomeComponent } from './admin/adminhome/adminhome.component';
import { CustomerloginComponent } from './customerlogin/customerlogin.component';
import { CustomerComponent } from './customer/customer/customer.component';
import { CustomersigininComponent } from './customersiginin/customersiginin.component';
import { CartComponent } from './customer/cart/cart.component';
import { CustomercontentComponent } from './customer/customercontent/customercontent.component';
import { ContentsComponent } from './contents/contents.component';
import { PaymentComponent } from './customer/payment/payment.component';
import { SuccessfulComponent } from './customer/successful/successful.component';
import { PasswordComponent } from './admin/password/password.component';


const routes: Routes = [
  {path:"",component:WelcomeComponent},
  {path:"customerlogin",component:AdminsigninComponent},
  {path:"adminlogin",component:CustomerloginComponent},
  {path:"customersignin",component:CustomersigininComponent},
  {path:"adminpage",component:AdminComponent,children:[{path:"changepass",component:ChangepassComponent,children:[{path:"password",component:PasswordComponent}]},
  {path:"adminhome",component:AdminhomeComponent}],pathMatch:"prefix"},
  {path:"customerhome",component:CustomerComponent,children:[{path:"customercart",component:CartComponent},
  {path:"productsbuypage",component:CustomercontentComponent},
]},
{path:"paymentpage",component:PaymentComponent},
{path:"confirmpage",component:SuccessfulComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
