import { Component,OnInit } from '@angular/core';
import {FormGroup,FormControl,FormArray,Validators} from '@angular/forms'; 
import { SampleserviceService } from '../services/sampleservice.service';
import { Observable } from 'rxjs';
import { Ilogin } from '../interfaces/ilogin';
import { AppRoutingModule } from '../app-routing.module';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminsignin',
  templateUrl: './adminsignin.component.html',
  styleUrls: ['./adminsignin.component.css']
})
export class AdminsigninComponent implements OnInit{

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
    this.s.getlogincredentials(y.value.username).subscribe(m=>{
     if(m!=null){
      if(m.password===p){
        console.log("welcome");
       // this.h.navigate(['adminpage']);
        this.s.set(y.value.username);
        this.h.navigate(['customerhome/productsbuypage']);
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
