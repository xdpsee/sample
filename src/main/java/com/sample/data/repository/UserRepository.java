package com.sample.data.repository;

import com.sample.data.mapper.GroupMapper;
import com.sample.data.mapper.UserMapper;
import com.sample.data.po.Group;
import com.sample.data.po.User;
import com.sample.security.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * @author zhenhui on 16/9/14.
 */
@Component
public class UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GroupMapper groupMapper;

    public User getUserByName(String username) {
        return userMapper.selectByName(username);
    }

    public Set<Authority> getUserAuthorities(long userId) {
        return userMapper.selectUserAuthorities(userId).stream()
                .map(Authority::new).collect(toSet());
    }

    public Set<Authority> getGroupAuthorities(long userId) {
        List<Long> groupIds = groupMapper.selectUserGroups(userId)
                .stream().map(Group::getId).collect(toList());

        if (!groupIds.isEmpty()) {
            return groupMapper.selectAuthoritiesInGroups(groupIds)
                    .stream().map(Authority::new).collect(toSet());
        }

        return new HashSet<>();
    }

}
