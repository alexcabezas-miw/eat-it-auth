package com.upm.miw.tfm.eatitauth.service.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Document(collection = IntegrationUser.INTEGRATION_USERS_COLLECTION_NAME)
public class IntegrationUser {

    public static final String INTEGRATION_USERS_COLLECTION_NAME = "users";

    private String username;

    private String password;

    @Builder.Default
    private List<String> roles = new ArrayList<>();
}
