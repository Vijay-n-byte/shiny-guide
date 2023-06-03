import { Component, OnInit } from '@angular/core';
import{FormGroup,FormArray,FormControl,Validators} from '@angular/forms'
import { Ilogin } from '../interfaces/ilogin';
import { Router } from '@angular/router';
import { SampleserviceService } from '../services/sampleservice.service';

@Component({
  selector: 'app-customerlogin',
  templateUrl: './customerlogin.component.html',
  styleUrls: ['./customerlogin.component.css']
})
export class CustomerloginComponent implements OnInit{

  userform!: FormGroup;

  data: Ilogin;
  bo:boolean;

  constructor(private s:SampleserviceService,private h:Router){}

  ngOnInit(): void {

    this.userform=new FormGroup({

      username:new FormControl('',
      [Validators.required,Validators.minLength(5),Validators.maxLength(10)]),
      password:new FormControl('',[Validators.required,Validators.minLength(3),Validators.maxLength(10)])
    });
    this.bo=false;
  }

  submited(y:FormGroup)
  {
    let p=y.value.password;
    console.log(y.value.username);
    console.log(y.value.password);
    this.s.getadminlogincredentials(y.value.username).subscribe(m=>{
     if(m!=null){
      if(m.password===p){
        console.log("welcome");
        this.s.set(y.value.username);
        this.h.navigate(['adminpage/adminhome']);
      }
      else{
        console.log("go back");
      }
    }
    else{
      console.log("wrong username");
      this.bo=true;
      console.log(this.bo);
      
    }



      });  
    
  }

}
