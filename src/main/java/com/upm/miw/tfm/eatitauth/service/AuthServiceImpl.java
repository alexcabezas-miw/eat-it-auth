package com.upm.miw.tfm.eatitauth.service;

import com.upm.miw.tfm.eatitauth.repository.UserRepository;
import com.upm.miw.tfm.eatitauth.service.model.IntegrationUser;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final static StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Cacheable("auths")
    public boolean authenticate(String username, String password) {
        Optional<IntegrationUser> user = this.userRepository.findByUsername(username);
        return user.filter(integrationUser -> encryptor.checkPassword(password, integrationUser.getPassword())).isPresent();
    }
}
