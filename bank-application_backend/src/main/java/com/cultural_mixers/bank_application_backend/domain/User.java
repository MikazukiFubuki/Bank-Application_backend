package com.cultural_mixers.bank_application_backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User implements Serializable {

    /**
     * ユーザーID
     */
    @TableId(type = IdType.AUTO)
    @TableField("user_id")
    private Integer user_id;

    /**
     * 口座番号
     */
    @TableField("account_number")
    private Integer account_number;

    /**
     * 預金残高
     */
    @TableField("balance")
    private Double balance;

    /**
     * ユーザ名
     */
    @TableField("name")
    private String name;


    /**
     * ユーザアイコン
     */
    @TableField("icon")
    private String icon;


}