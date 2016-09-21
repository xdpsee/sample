package com.sample.data.mapper;

import com.sample.data.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhenhui on 16/9/16.
 */
public interface UserMapper {

    int insert(User user);

    User selectById(@Param("id") Long userId);

    User selectByName(@Param("username") String userName);

    List<String> selectUserAuthorities(@Param("userId") long userId);
}
