import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-successful',
  templateUrl: './successful.component.html',
  styleUrls: ['./successful.component.css']
})
export class SuccessfulComponent {
  constructor(private f:Router){}

  backtohome(){
    this.f.navigate(['customerhome/productsbuypage']);
  }

}
