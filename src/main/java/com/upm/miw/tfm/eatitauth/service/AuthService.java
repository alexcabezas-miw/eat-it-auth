package com.upm.miw.tfm.eatitauth.service;

import com.upm.miw.tfm.eatitauth.service.model.IntegrationUser;

public interface AuthService {
    IntegrationUser authenticate(String username, String password);
}
