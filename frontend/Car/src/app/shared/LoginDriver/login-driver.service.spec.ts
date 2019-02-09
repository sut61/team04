import { TestBed } from '@angular/core/testing';

import { LoginDriverService } from './login-driver.service';

describe('LoginDriverService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LoginDriverService = TestBed.get(LoginDriverService);
    expect(service).toBeTruthy();
  });
});
