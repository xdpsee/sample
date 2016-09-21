package com.sample.data.mapper;

import com.sample.data.po.Remember;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author zhenhui on 16/9/16.
 */
public interface RememberMapper {

    int insert(Remember remember);

    Remember selectBySeries(@Param("series") String seriesId);

    int update(@Param("series") String series
            , @Param("token") String token
            , @Param("timestamp") Date timestamp);

    int removeByUsername(@Param("username") String username);

}
