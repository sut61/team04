import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservesumComponent } from './reservesum.component';

describe('ReservesumComponent', () => {
  let component: ReservesumComponent;
  let fixture: ComponentFixture<ReservesumComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReservesumComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservesumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
