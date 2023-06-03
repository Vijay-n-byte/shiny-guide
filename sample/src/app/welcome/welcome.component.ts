import { Component } from '@angular/core';
import { PopupaddComponent } from '../admin/popupadd/popupadd.component';
import {MatDialog} from '@angular/material/dialog'
import { Router } from '@angular/router';
@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent {

  constructor(private h:Router){}

  // openpopup(){
  //   this.h.open(PopupaddComponent,{
  //     width:'90px',
  //     height:'90px',      
  //   });
  // }

  sendtologin(){
   //  this.h.navigate(['adminlogin']);
     this.h.navigate(['customerlogin']);

  }

}
