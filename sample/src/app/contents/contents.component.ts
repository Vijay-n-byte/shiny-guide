import { Component, OnInit } from '@angular/core';
import { SampleserviceService } from '../services/sampleservice.service';
import { AppRoutingModule } from '../app-routing.module';
import { Router } from '@angular/router';
import { CustomerloginComponent } from '../customerlogin/customerlogin.component';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-contents',
  templateUrl: './contents.component.html',
  styleUrls: ['./contents.component.css']
})
export class ContentsComponent implements OnInit {

  constructor(private g:SampleserviceService,private k1:Router){}

  public k:any;
  public v:any;
  // public chan:any;
  ngOnInit(): void {

    // this.g.getproductsdetails().subscribe(
    //   m =>this.k=m
    //  );

     this.g.getproductsdetails().subscribe(m=>{
      if(m!=null){
        this.k=m;
        this.v=m;
      }
     }
     );
  }
  sendtologin(){
    // this.k1.navigate(['adminlogin']);
    this.k1.navigate(['customerlogin']);
  }
  sample(u){
    this.k=this.v;
    let gf:string=u.value.fooditem;
    console.log(gf);
    this.k=this.k.filter(function(b){
      return b.productname===gf;
      // return (b.category==="breakfast") && (b.cost>=100);
      // return b.cost<=100;
    }).map(function(c){
      return c;
    })
  }
}
