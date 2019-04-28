package com.edu.authservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;


@Document
public class AuthClientDetails implements ClientDetails {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String clientId;
    private String clientSecret;
    private Set<String> grantTypes;
    private Set<String> scopes;
    private Set<String> resources;
    private Set<String> redirectUris;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    private Map<String, Object> additionalInformation;


    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return resources;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    @Override
    public boolean isScoped() {
        return false;
    }

    @Override
    public Set<String> getScope() {
        return scopes;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return grantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return redirectUris;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValidity;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValidity;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return true;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return additionalInformation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setGrantTypes(Set<String> grantTypes) {
        this.grantTypes = grantTypes;
    }

    public void setScopes(Set<String> scopes) {
        this.scopes = scopes;
    }

    public void setResources(Set<String> resources) {
        this.resources = resources;
    }

    public void setRedirectUris(Set<String> redirectUris) {
        this.redirectUris = redirectUris;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public void setAdditionalInformation(Map<String, Object> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
