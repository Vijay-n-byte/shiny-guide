import { Component,OnInit } from '@angular/core';
import {FormGroup,FormControl,FormArray,Validators} from '@angular/forms'; 
import { Router } from '@angular/router';
import { SampleserviceService } from 'src/app/services/sampleservice.service';
@Component({
  selector: 'app-password',
  templateUrl: './password.component.html',
  styleUrls: ['./password.component.css']
})
export class PasswordComponent  implements OnInit{

userform:FormGroup;
bo:boolean;
bo1:boolean;
bo2:boolean;
constructor(private t:SampleserviceService,private tt :Router){};
ngOnInit(): void {

  this.userform=new FormGroup({

    username:new FormControl('',
    [Validators.required,Validators.minLength(5),Validators.maxLength(10)]),
    currentpassword:new FormControl('',[Validators.required,Validators.minLength(3),Validators.maxLength(10)]),
    newpassword:new FormControl('',[Validators.required,Validators.minLength(3),Validators.maxLength(10)]),
    newpassword1:new FormControl('',[Validators.required,Validators.minLength(3),Validators.maxLength(10)]),
  });
 // this.bo=false;
  
}

submitted(k:FormGroup){
  this.bo=false;
  this.bo1=false;
  this.bo2=false;
  let de:any=k.value.currentpassword;
  if(k.value.newpassword===k.value.newpassword1){
    
    console.log("equal");
    this.t.getadminlogincredentials(k.value.username).subscribe(n=>{
      if(n!==null){
        console.log(n.password);
        console.log(k.value.password);
        if(n.password==k.value.currentpassword){
          //give post call to post the new password to api
          console.log("hello");
          this.t.putadminlogincredentials(k.value.username,k.value.newpassword).subscribe();
          this.tt.navigate(['adminlogin']);

        }
        else{
          //password wrong
          this.bo2=true;
        }
      }
      else{
        this.bo1=true;
        //no username found
      }
    });

  }
  else{
       //new password and repeat password didnt match

       this.bo=true;
 
  }

}

}
