package com.upm.miw.tfm.eatitauth

import com.upm.miw.tfm.eatitauth.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@ActiveProfiles("test")
@AutoConfigureDataMongo
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class AbstractIntegrationTest extends Specification {

    @Autowired
    protected UserRepository userRepository

    def cleanup() {
        userRepository.deleteAll()
    }
}
