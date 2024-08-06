package com.cultural_mixers.bank_application_backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@TableName("request")
public class Request implements Serializable {

    /**
     * 請求ID
     */
    @TableId(type = IdType.AUTO)
    @TableField("request_id")
    private Integer request_id;

    /**
     * 請求者ユーザーID
     */
    @TableField("req_user_id")
    private Integer req_user_id;

    /**
     * 請求金額
     */
    @TableField("money")
    private Double money;

    /**
     * 請求時間
     */
    @TableField("request_time")
    private String request_time;


    /**
     * 請求メッセージ
     */
    @TableField("message")
    private String message;

    /**
     * 請求リンク
     */
    @TableField(exist = false)
    private String link;

    /**
     * 支払い済み
     */
    @TableField(exist = false)
    private List<Pay> paid;


}