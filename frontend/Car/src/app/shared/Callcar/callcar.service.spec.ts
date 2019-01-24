import { TestBed } from '@angular/core/testing';

import { CallcarService } from './callcar.service';

describe('CallcarService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CallcarService = TestBed.get(CallcarService);
    expect(service).toBeTruthy();
  });
});
