import { TestBed } from '@angular/core/testing';

import { OnlinepayService } from './onlinepay.service';

describe('OnlinepayService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OnlinepayService = TestBed.get(OnlinepayService);
    expect(service).toBeTruthy();
  });
});
