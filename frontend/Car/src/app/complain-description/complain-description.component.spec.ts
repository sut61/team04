import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComplainDescriptionComponent } from './complain-description.component';

describe('ComplainDescriptionComponent', () => {
  let component: ComplainDescriptionComponent;
  let fixture: ComponentFixture<ComplainDescriptionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComplainDescriptionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComplainDescriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
