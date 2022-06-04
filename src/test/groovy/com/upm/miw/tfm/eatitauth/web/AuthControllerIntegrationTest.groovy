package com.upm.miw.tfm.eatitauth.web

import com.upm.miw.tfm.eatitauth.AbstractWebIntegrationTest
import com.upm.miw.tfm.eatitauth.service.model.IntegrationUser
import com.upm.miw.tfm.eatitauth.web.dto.AuthenticationDTO
import org.jasypt.util.password.StrongPasswordEncryptor
import org.springframework.web.reactive.function.BodyInserters

class AuthControllerIntegrationTest extends AbstractWebIntegrationTest {

    def "server returns 200 and integration user when it is found and password matches" () {
        given:
        userRepository.save(IntegrationUser.builder()
                .username("username")
                .password(new StrongPasswordEncryptor().encryptPassword("password")).build())

        expect:
        webTestClient.post().uri(AuthController.AUTH_PATH)
                .body(BodyInserters.fromValue(AuthenticationDTO.builder()
                        .username("username")
                        .password("password").build())
                ).exchange()
                .expectStatus().isOk().expectBody(Boolean.class)
                .value({authenticated ->
                    Boolean.TRUE == authenticated
                })
    }

    def "server returns 200 and null body when user is found but password does not match" () {
        given:
        userRepository.save(IntegrationUser.builder()
                .username("username")
                .password(new StrongPasswordEncryptor().encryptPassword("password2")).build())

        expect:
        webTestClient.post().uri(AuthController.AUTH_PATH)
                .body(BodyInserters.fromValue(AuthenticationDTO.builder()
                        .username("username")
                        .password("password").build())
                ).exchange()
                .expectStatus().isOk()
                .expectBody(Boolean.class).value({authenticated ->
                    Boolean.FALSE == authenticated
                })
    }

    def "server returns 200 and null body when user is not found" () {
        expect:
        webTestClient.post().uri(AuthController.AUTH_PATH)
                .body(BodyInserters.fromValue(AuthenticationDTO.builder()
                        .username("username")
                        .password("password").build())
                ).exchange()
                .expectStatus().isOk().expectBody(Boolean.class).value({authenticated ->
                    Boolean.FALSE == authenticated
                })
    }
}
