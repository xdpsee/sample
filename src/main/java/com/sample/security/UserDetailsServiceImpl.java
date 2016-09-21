package com.sample.security;

import com.sample.data.po.User;
import com.sample.data.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhenhui on 16/9/14.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        User user = userRepository.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.addAll(userRepository.getUserAuthorities(user.getId()));
        authorities.addAll(userRepository.getGroupAuthorities(user.getId()));

        if (authorities.isEmpty()) {
            logger.debug("User '" + username
                    + "' has no authorities and will be treated as 'not found'");
            throw new UsernameNotFoundException(String.format("User %s has no GrantedAuthority", username));
        }

        return new UserDetailsImpl(user, authorities);
    }

}


