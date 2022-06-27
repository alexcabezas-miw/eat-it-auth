package com.upm.miw.tfm.eatitauth.service

import com.upm.miw.tfm.eatitauth.AbstractIntegrationTest
import com.upm.miw.tfm.eatitauth.service.model.IntegrationUser
import org.jasypt.util.password.StrongPasswordEncryptor
import org.springframework.beans.factory.annotation.Autowired

class AuthServiceIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    AuthService authService

    def "authenticate returns user when user is found and password matches" () {
        given:
        userRepository.save(IntegrationUser.builder()
                .username("username")
                .password(new StrongPasswordEncryptor().encryptPassword("password")).build())

        when:
        def user = authService.authenticate("username", "password")

        then:
        user
    }

    def "authenticate returns null when user is found but password does not match" () {
        given:
        userRepository.save(IntegrationUser.builder()
                .username("username")
                .password(new StrongPasswordEncryptor().encryptPassword("password")).build())

        when:
        def user = authService.authenticate("username", "password2")

        then:
        !user
    }

    def "authenticate returns null when user is not found" () {
        when:
        def user = authService.authenticate("username", "password")

        then:
        !user
    }
}
