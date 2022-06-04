package com.upm.miw.tfm.eatitauth.service;

public interface AuthService {
    boolean authenticate(String username, String password);
}
