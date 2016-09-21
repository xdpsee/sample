package com.sample.security;

import com.sample.data.po.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author zhenhui on 16/9/14.
 */
@Data
public class UserDetailsImpl implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    private final User user;

    private final Collection<? extends GrantedAuthority> authorities;

    UserDetailsImpl(User user, Collection<? extends GrantedAuthority> authorities) {
        if (null == user) {
            throw new IllegalArgumentException("user == null");
        }

        this.user = user;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
