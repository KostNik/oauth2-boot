package com.edu.authservice.websecurityconfig.mongodb.changelogs;


import com.edu.authservice.auth.Authorities;
import com.edu.authservice.domain.AuthClientDetails;
import com.edu.authservice.domain.User;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.google.common.collect.Sets;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.HashSet;
import java.util.Set;

@ChangeLog
public class InitialValuesChangeLog {

    @ChangeSet(order = "001", id = "insertBrowserClientDetails", author = "Kostiuk Mykyta")
    public void insertBrowserClientDetails(MongoTemplate mongoTemplate) {
        AuthClientDetails browserClientDetails = new AuthClientDetails();
        browserClientDetails.setClientId("browser");
        browserClientDetails.setClientSecret("$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK");
        browserClientDetails.setScopes(Sets.newHashSet("ui"));
        browserClientDetails.setGrantTypes(Sets.newHashSet("refresh_token", "password"));

        mongoTemplate.save(browserClientDetails);
    }

    @ChangeSet(order = "002", id = "insertUserToTestAuthentication", author = "Kostiuk Mykyta")
    public void insertUserToTestAuthentication(MongoTemplate mongoTemplate) {
        Set<Authorities> authorities = new HashSet<>();
        authorities.add(Authorities.ROLE_USER);

        User user = new User();
        user.setActivated(true);
        user.setAuthorities(authorities);
        user.setPassword("$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK"); //1234 (by BCrypt)
        user.setUsername("randomuser");

        mongoTemplate.save(user);
    }

}
