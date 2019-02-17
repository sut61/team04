import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscountshowComponent } from './discountshow.component';

describe('DiscountshowComponent', () => {
  let component: DiscountshowComponent;
  let fixture: ComponentFixture<DiscountshowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiscountshowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiscountshowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
