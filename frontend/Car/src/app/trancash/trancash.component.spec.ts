import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrancashComponent } from './trancash.component';

describe('TrancashComponent', () => {
  let component: TrancashComponent;
  let fixture: ComponentFixture<TrancashComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrancashComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrancashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
