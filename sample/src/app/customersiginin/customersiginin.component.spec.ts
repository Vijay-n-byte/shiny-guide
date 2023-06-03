import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomersigininComponent } from './customersiginin.component';

describe('CustomersigininComponent', () => {
  let component: CustomersigininComponent;
  let fixture: ComponentFixture<CustomersigininComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CustomersigininComponent]
    });
    fixture = TestBed.createComponent(CustomersigininComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
