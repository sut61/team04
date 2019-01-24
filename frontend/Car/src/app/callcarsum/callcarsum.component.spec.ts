import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CallcarsumComponent } from './callcarsum.component';

describe('CallcarsumComponent', () => {
  let component: CallcarsumComponent;
  let fixture: ComponentFixture<CallcarsumComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CallcarsumComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CallcarsumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
