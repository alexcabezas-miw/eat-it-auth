package com.upm.miw.tfm.eatitauth.repository

import com.upm.miw.tfm.eatitauth.AbstractIntegrationTest
import com.upm.miw.tfm.eatitauth.service.model.IntegrationUser

class UserRepositoryIntegrationTest extends AbstractIntegrationTest {

    def "get integration user by username returns user" () {
        given:
        userRepository.save(IntegrationUser.builder()
                .username("username")
                .password("password").build())

        when:
        def user = userRepository.findByUsername("username")

        then:
        user.isPresent()
    }

    def "get integration user by username returns empty when not found" () {
        when:
        def user = userRepository.findByUsername("username")

        then:
        user.isEmpty()
    }




}
