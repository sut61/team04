import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CallcarComponent } from './callcar.component';

describe('CallcarComponent', () => {
  let component: CallcarComponent;
  let fixture: ComponentFixture<CallcarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CallcarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CallcarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
