import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SampleserviceService } from '../services/sampleservice.service';

@Component({
  selector: 'app-customersiginin',
  templateUrl: './customersiginin.component.html',
  styleUrls: ['./customersiginin.component.css']
})
export class CustomersigininComponent {

  userform!: FormGroup;

  bo:boolean;

  constructor(private s:SampleserviceService,private h:Router){}

  ngOnInit(): void {

    this.userform=new FormGroup({

      username:new FormControl('',
      [Validators.required,Validators.minLength(5),Validators.maxLength(10)]),
      password:new FormControl('',[Validators.required,Validators.minLength(3),Validators.maxLength(10)]),
      name:new FormControl('',[Validators.required,Validators.minLength(5),Validators.maxLength(10)]),
      address:new FormControl('',Validators.required),
      phonenumber:new FormControl('',[Validators.required,Validators.minLength(5),Validators.maxLength(10)]),
      adhaarno:new FormControl('',[Validators.required,Validators.minLength(5),Validators.maxLength(10)])
    });
    this.bo=false;
  }

  submited(y:FormGroup)
  {
    console.log(y.value);
    this.s.signin(y.value).subscribe();
    this.h.navigate(['customerlogin']);
      }
    
  }

