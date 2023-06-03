import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SampleserviceService } from 'src/app/services/sampleservice.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit{

  j:number;

  constructor(private o:SampleserviceService,private re:Router){}
  ngOnInit(): void {
    this.j=this.o.gettotalprice();
    console.log(this.j);
  }

  confirmbooking(){

    this.o.customerbookingcofirm().subscribe();
    this.re.navigate(['confirmpage']);

    
  }

}
