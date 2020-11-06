package com.zy.domain;

import lombok.Data;

/**
 * @author 17616
 * 用户的实体
 */
@Data
public class User {
    private Integer userid;

    private String username;

    private String userpwd;

    private String sex;

    private String address;


}