import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OnlinepayComponent } from './onlinepay.component';

describe('OnlinepayComponent', () => {
  let component: OnlinepayComponent;
  let fixture: ComponentFixture<OnlinepayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OnlinepayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OnlinepayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
