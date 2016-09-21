package com.sample.security;

import com.sample.data.po.Client;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * @author zhenhui on 16/9/14.
 */
class ClientDetailsImpl implements ClientDetails, Serializable {

    private static final long serialVersionUID = 1L;
    private static final String COMMA = ",";
    private final Client client;

    ClientDetailsImpl(Client client) {
        if (null == client) {
            throw new IllegalArgumentException("client == null");
        }

        this.client = client;
    }

    @Override
    public String getClientId() {
        return client.getClientId();
    }

    @Override
    public Set<String> getResourceIds() {
        String resourceIds = client.getResourceIds();
        return Arrays.stream(resourceIds.split(COMMA)).collect(toSet());
    }

    @Override
    public boolean isSecretRequired() {
        return client.isSecretRequired();
    }

    @Override
    public String getClientSecret() {
        return client.getClientSecret();
    }

    @Override
    public boolean isScoped() {
        return client.isScoped();
    }

    @Override
    public Set<String> getScope() {
        String scopes = client.getScopes();
        return Arrays.stream(scopes.split(COMMA)).collect(toSet());
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        String grantTypes = client.getGrantTypes();
        return Arrays.stream(grantTypes.split(COMMA)).collect(toSet());
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        String uris = client.getRedirectUri();
        return Arrays.stream(uris.split(COMMA)).collect(toSet());
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return client.getAccessTokenValiditySeconds();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return client.getRefreshTokenValiditySeconds();
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}