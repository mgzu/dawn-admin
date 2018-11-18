package com.github.mgzu.dawn.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author https://github.com/mgzu
 */
public class BaseEntity {

    @TableId
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                "}";
    }
}
