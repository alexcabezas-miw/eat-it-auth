package com.upm.miw.tfm.eatitauth


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.web.ServerProperties
import org.springframework.test.web.reactive.server.WebTestClient

class AbstractWebIntegrationTest extends AbstractIntegrationTest {

    protected WebTestClient webTestClient

    @Autowired
    ServerProperties serverProperties

    void setup() {
        this.webTestClient = WebTestClient
                .bindToServer()
                .baseUrl("http://localhost:" + serverProperties.getPort())
                .build()
    }
}
