package com.sample.security;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * @author zhenhui on 16/9/16.
 */
@Data
@EqualsAndHashCode
public class Authority implements GrantedAuthority, Serializable {

    private final String name;

    public Authority(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Authority name is empty!");
        }

        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
