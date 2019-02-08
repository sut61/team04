import { TestBed } from '@angular/core/testing';

import { CashpayService } from './cashpay.service';

describe('CashpayService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CashpayService = TestBed.get(CashpayService);
    expect(service).toBeTruthy();
  });
});
