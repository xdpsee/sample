package com.sample.security;

import com.sample.data.po.Client;
import com.sample.data.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

/**
 * @author zhenhui on 16/9/14.
 */
public class ClientDetailsServiceImpl implements ClientDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        Client client = clientRepository.getClient(clientId);
        if (null == client) {
            throw new ClientRegistrationException(String.format("Client %s is not exist!", clientId));
        }

        return new ClientDetailsImpl(client);
    }

}




