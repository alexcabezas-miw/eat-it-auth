package com.upm.miw.tfm.eatitauth.repository;

import com.upm.miw.tfm.eatitauth.service.model.IntegrationUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<IntegrationUser, String> {
    Optional<IntegrationUser> findByUsername(String username);
}
