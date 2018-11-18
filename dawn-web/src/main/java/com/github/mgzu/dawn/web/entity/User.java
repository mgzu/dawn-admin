package com.github.mgzu.dawn.web.entity;

import com.github.mgzu.dawn.common.entity.BaseEntity;

/**
 * <p>
 * 
 * </p>
 *
 * @author https://github.com/mgzu
 * @since 2018-11-17
 */
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;

    private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
        "name=" + name +
        ", age=" + age +
        ", email=" + email +
        "}";
    }
}
