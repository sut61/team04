import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CommentDescriptionComponent } from './comment-description.component';

describe('CommentDescriptionComponent', () => {
  let component: CommentDescriptionComponent;
  let fixture: ComponentFixture<CommentDescriptionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CommentDescriptionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CommentDescriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
