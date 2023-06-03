import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomercontentComponent } from './customercontent.component';

describe('CustomercontentComponent', () => {
  let component: CustomercontentComponent;
  let fixture: ComponentFixture<CustomercontentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CustomercontentComponent]
    });
    fixture = TestBed.createComponent(CustomercontentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
