import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DriverpctComponent } from './driverpct.component';

describe('DriverpctComponent', () => {
  let component: DriverpctComponent;
  let fixture: ComponentFixture<DriverpctComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DriverpctComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DriverpctComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
