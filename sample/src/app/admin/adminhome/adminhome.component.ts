import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog'
import { PopupaddComponent } from '../popupadd/popupadd.component';
import { FixedSizeVirtualScrollStrategy } from '@angular/cdk/scrolling';
import {FormGroup,FormControl,FormArray,Validators} from '@angular/forms'; 
import { SampleserviceService } from 'src/app/services/sampleservice.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Products } from 'src/app/interfaces/products';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {

  public k:any;
  op="modalbackground1";
  constructor(private g:SampleserviceService,private j:Router){}
  openmodel="modal";
  r:number;


  

  ngOnInit(): void {
     this.g.getproductsdetails().subscribe(
      m =>this.k=m
     );
      console.log("refreshed");
  }



  openmodal(){
    this.op="modalbackground";
  }
  closemodal(){
    this.op="modalbackground1";
    this.j.navigateByUrl('/',{skipLocationChange:true}).then(()=>{
      this.j.navigate(['/adminpage/adminhome'])
    });
    
  
  
  }
  submitvalue(){
    // console.log(n.value);
  }

  deleteit(j:number){
    this.g.deleteproducts(j).subscribe();

    this.j.navigateByUrl('/',{skipLocationChange:true}).then(()=>{
      this.j.navigate(['/adminpage/adminhome'])
    });
  }


  onFileSelected(event,n:number){
    console.log(event);
      let f=new FormData();
      let file:File=event.target.files[0];
      console.log(file);
   
      if(file){
        console.log("hello");
        f.append("sample",file);
        this.g.uploadimg(n,f).subscribe();
      }
    }
}
