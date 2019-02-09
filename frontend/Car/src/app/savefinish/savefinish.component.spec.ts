import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SavefinishComponent } from './savefinish.component';

describe('SavefinishComponent', () => {
  let component: SavefinishComponent;
  let fixture: ComponentFixture<SavefinishComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SavefinishComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SavefinishComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
