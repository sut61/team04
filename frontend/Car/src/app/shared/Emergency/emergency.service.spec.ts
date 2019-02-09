import { TestBed } from '@angular/core/testing';

import { EmergencyService } from './emergency.service';

describe('LoginMemberService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EmergencyService = TestBed.get(EmergencyService);
    expect(service).toBeTruthy();
  });
});
