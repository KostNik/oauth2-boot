package com.edu.authservice.service;

import com.edu.authservice.repo.AuthClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class AuthClientDetailsService implements ClientDetailsService {

    @Autowired
    private AuthClientRepository authClientRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return authClientRepository
                .findByClientId(clientId)
                .orElseThrow(() -> new ClientRegistrationException("No client found by " + clientId));
    }
}
