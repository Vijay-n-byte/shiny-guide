import { HttpClient, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ilogin } from '../interfaces/ilogin';
import { Products } from '../interfaces/products';
import { Customer } from '../interfaces/customer';
import { Customerdetails } from '../interfaces/customerdetails';
import { Addtocart } from '../interfaces/addtocart';

@Injectable({
  providedIn: 'root'
})
export class SampleserviceService {
  data:Ilogin;
  user:string;
  customerid:number;
  totalprice:number;

  constructor(private http:HttpClient) { }

  private root:string ="http://localhost:8080/login/";
  private rootad:string ="http://localhost:8080/login/admin/";
  private rootadup:string ="http://localhost:8080/login/admin";
  
  private root1:string ="http://localhost:8080/products";
  private root2:string ="http://localhost:8080/products/dummy";
  private root3:string ="http://localhost:8080/customers";
  private root4:string ="http://localhost:8080/customers/full/";
  private root5:string ="http://localhost:8080/customers/customerno=";
  private root6:string ="http://localhost:8080/customers/cartadd/";
  private root7:string ="http://localhost:8080/customers/cart/";
  private root8:string ="http://localhost:8080/customers/";
  
  

  set(n:string){
    this.user=n;
  }
  get():string{
    return this.user;
  }

  set1(m:number){
   // console.log(m);
    this.customerid=m;
  }

  settotalprice(m:number){
    console.log(m);
    this.totalprice=m;
  }

  gettotalprice():number{
    return this.totalprice;
  }

  customerbookingcofirm():Observable<any|null>|null{
    let r=`${this.root8}${this.customerid}/confirm`;
    return this.http.post<any>(r,null);
  }
 

  addtocart(pr:number,qu:number):Observable<Addtocart|null>|null{
    let r:number=this.customerid as number;
    let w=`${this.root6}${this.customerid}`;
    console.log(w);
   
    let d:Addtocart={productnumber:pr,quantity:qu};
   
   return this.http.post<Addtocart>(w,d); 
 }

 getcart():Observable<any|null>|null{
  let w=`${this.root7}${this.customerid}`;
  console.log(w);
  return this.http.get<any>(w);
 }



  getcustomerdetails():Observable<Customerdetails|null>|null{
    let k:string=`${this.root4}${this.user}`;
    return this.http.get<Customerdetails>(k);
  }
  

  
  getlogincredentials(username:string):Observable<Ilogin | null> | null {
    let y=this.root+username;
    let z=this.http.get<Ilogin>(y);
    z.subscribe(m=>this.data=m);
    console.log(this.data);
    return z;
  }

  putadminlogincredentials(y:string,z:string):Observable<Ilogin|null>|null{
    let h=this.rootadup;
    let d:Ilogin={username:y,password:z};
    return this.http.put<Ilogin>(h,d);
  }

  getadminlogincredentials(username:string):Observable<Ilogin | null> | null {
    let y=this.rootad+username;
    let z=this.http.get<Ilogin>(y);
    z.subscribe(m=>this.data=m);
    console.log(this.data);
    return z;
  }

  deleteproducts(n:number):Observable<Products|null>|null{
    let y=`${this.root1}/${n}`;
    return this.http.delete<Products>(y);
  }

  getproductsdetails():Observable<Products|null>|null{
    return this.http.get<Products>(this.root1);
  } 

  uploadimg(h:number,j:FormData){
    let y=`${this.root2}/${h}`;
    return this.http.post(y,j);
  }

  signin(d:Customer):Observable<Customer|null>|null{
    return this.http.post<Customer>(this.root3,d);
    
  }

  uploadproducts(y:Products):Observable<any|null>|null{
    console.log(y);
   return this.http.post(this.root1,JSON.stringify(y));
  }

}

