import { TestBed } from '@angular/core/testing';

import { ReservecarService } from './reservecar.service';

describe('ReservecarService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ReservecarService = TestBed.get(ReservecarService);
    expect(service).toBeTruthy();
  });
});
