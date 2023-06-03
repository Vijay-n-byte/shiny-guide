import { Component ,OnInit} from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Addtocart } from 'src/app/interfaces/addtocart';
import { SampleserviceService } from 'src/app/services/sampleservice.service';

@Component({
  selector: 'app-customercontent',
  templateUrl: './customercontent.component.html',
  styleUrls: ['./customercontent.component.css']
})
export class CustomercontentComponent implements OnInit{
  j:Array<number>=[10,20,30,11,12,13,14,15,16,17];

  constructor(private g:SampleserviceService,private k1:Router){}

  op="modalbackground1";

  public k:any;
  public v:any;
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

  filterit(j){
    console.log(j.value);
    this.k=this.v;
    this.op="modalbackground1";
    if(j.value.price===0){
      this.k=this.k.filter(function(b){
         return (b.category===j.value.category) && (b.cost<=500);
       }).map(function(c){
         return c;
       })
    }
    else if(j.value.price===1){

      this.k=this.k.filter(function(b){
        return (b.category===j.value.category) && (b.cost>=500);
      }).map(function(c){
        return c;
      })

    }
    else{

      this.k=this.k.filter(function(b){
         return (b.category===j.value.category);
       }).map(function(c){
         return c;
       })

    }
  }


  
  addtocart(r,h:any){
    let rr:number=r.value.quantity;
    let rrr:number=h as number;
    console.log(rr);
    console.log(rrr);
    this.g.addtocart(rrr,rr).subscribe();
    
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



  openmodal(){
    this.op="modalbackground";
  }
  closemodal(){
    this.op="modalbackground1";
    };
  

}
