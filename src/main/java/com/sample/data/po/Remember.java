package com.sample.data.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author zhenhui on 16/9/16.
 */
@Data
@AllArgsConstructor
public class Remember implements Serializable {

    private String series;

    private String username;

    private String token;

    private Timestamp timestamp;


    public Remember(PersistentRememberMeToken rememberMeToken) {
        if (null == rememberMeToken) {
            throw new IllegalArgumentException("rememberMeToken == null");
        }

        this.series = rememberMeToken.getSeries();
        this.username = rememberMeToken.getUsername();
        this.token = rememberMeToken.getTokenValue();
        this.timestamp = new Timestamp(rememberMeToken.getDate().getTime());
    }
}
