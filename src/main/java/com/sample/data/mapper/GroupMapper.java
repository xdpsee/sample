package com.sample.data.mapper;

import com.sample.data.po.Group;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhenhui on 16/9/16.
 */
public interface GroupMapper {

    int insert(Group group);

    List<Group> selectAll();

    List<Group> selectUserGroups(@Param("userId") long userId);

    List<String> selectGroupAuthorities(@Param("groupId") long groupId);

    List<String> selectAuthoritiesInGroups(@Param("groupIds") List<Long> groupIds);
}
