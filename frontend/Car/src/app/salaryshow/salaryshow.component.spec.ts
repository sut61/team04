import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalaryshowComponent } from './salaryshow.component';

describe('SalaryshowComponent', () => {
  let component: SalaryshowComponent;
  let fixture: ComponentFixture<SalaryshowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalaryshowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalaryshowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
