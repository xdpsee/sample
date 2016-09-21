package com.sample.data.po;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author zhenhui on 16/9/14.
 */
@Data
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String password;

    public User() {

    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(User user) {
        BeanUtils.copyProperties(user, this);
    }


}
