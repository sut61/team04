import { TestBed } from '@angular/core/testing';

import { ComentService } from './coment.service';

describe('ComentService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ComentService = TestBed.get(ComentService);
    expect(service).toBeTruthy();
  });
});
