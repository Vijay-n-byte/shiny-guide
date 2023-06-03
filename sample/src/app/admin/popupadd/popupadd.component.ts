import { Component,OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { buffer } from 'rxjs';
import { Products } from 'src/app/interfaces/products';
import { SampleserviceService } from 'src/app/services/sampleservice.service';


@Component({
  selector: 'app-popupadd',
  templateUrl: './popupadd.component.html',
  styleUrls: ['./popupadd.component.css']
})
export class PopupaddComponent implements OnInit{
	constructor(private y:SampleserviceService,private x:Router){}


  ngOnInit(): void {
    
  }
  


 
  submitvalue(n:NgForm){
    let p=n.value;
    console.log(p);
    // this.f.append("products",JSON.stringify(p));
    this.y.uploadproducts(p).subscribe();
    n.resetForm();
  }
}
