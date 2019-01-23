import { TestBed } from '@angular/core/testing';

import { LoginMemberService } from './login-member.service';

describe('LoginMemberService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LoginMemberService = TestBed.get(LoginMemberService);
    expect(service).toBeTruthy();
  });
});
