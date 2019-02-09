import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenudriverComponent } from './menudriver.component';

describe('MenudriverComponent', () => {
  let component: MenudriverComponent;
  let fixture: ComponentFixture<MenudriverComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenudriverComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenudriverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
