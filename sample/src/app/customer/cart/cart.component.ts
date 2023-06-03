import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SampleserviceService } from 'src/app/services/sampleservice.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit{
  
  r:any;
  constructor(private g:SampleserviceService,private ro:Router){

  }

  ngOnInit(): void {
    this.g.getcart().subscribe(n=>{
      if(n!=null){
        this.r=n;
        this.g.settotalprice(n.totalcost);
      }

    }
        
     );
  
  }
  proceedtopay(){
    
     this.ro.navigate(['paymentpage']);
  }
}
