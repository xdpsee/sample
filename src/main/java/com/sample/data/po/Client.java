package com.sample.data.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhenhui on 16/9/14.
 */
@Data
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String clientId;

    private String clientSecret;

    private boolean secretRequired;

    private String grantTypes;

    private String authorities;

    private String scopes;

    private boolean scoped;

    private String resourceIds;

    private String redirectUri;

    private Integer accessTokenValiditySeconds;

    private Integer refreshTokenValiditySeconds;

}
