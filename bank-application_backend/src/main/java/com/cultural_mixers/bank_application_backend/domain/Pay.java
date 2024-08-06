package com.cultural_mixers.bank_application_backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("pay")
public class Pay implements Serializable {

    /**
     * 支払ID
     */
    @TableId(type = IdType.AUTO)
    @TableField("pay_id")
    private Integer pay_id;

    /**
     * 請求ID
     */
    @TableField("request_id")
    private Integer request_id;

    /**
     * 支払人ユーザーID
     */
    @TableField("pay_user_id")
    private Integer pay_user_id;

    /**
     * 請求リンク
     */
    @TableField(exist = false)
    private Integer user_id;

    /**
     * 請求リンク
     */
    @TableField(exist = false)
    private String name;

    /**
     * 請求リンク
     */
    @TableField(exist = false)
    private String icon;


}