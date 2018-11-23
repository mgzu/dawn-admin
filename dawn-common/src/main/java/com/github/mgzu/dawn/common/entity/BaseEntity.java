package com.github.mgzu.dawn.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author https://github.com/mgzu
 * @since 2018-11-20
 */
public class BaseEntity {

	@TableId(value = "ID", type = IdType.INPUT)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                "}";
    }
}
