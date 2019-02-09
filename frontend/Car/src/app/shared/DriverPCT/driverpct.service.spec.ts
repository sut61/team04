import { TestBed } from '@angular/core/testing';

import { DriverpctService } from './driverpct.service';

describe('DriverpctService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DriverpctService = TestBed.get(DriverpctService);
    expect(service).toBeTruthy();
  });
});
