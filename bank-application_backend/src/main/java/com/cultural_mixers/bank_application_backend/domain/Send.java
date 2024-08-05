package com.cultural_mixers.bank_application_backend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("send")
public class Send implements Serializable {

    /**
     * 送金ID
     */
    @TableId(type = IdType.AUTO)
    @TableField("send_id")
    private Integer send_id;

    /**
     * アプリユーザID
     */
    @TableField("se_user_id")
    private Integer se_user_id;

    /**
     * 送金相手ID
     */
    @TableField("re_user_id")
    private Integer re_user_id;

    /**
     * 送金金額
     */
    @TableField("money")
    private Double money;

    /**
     * 送金時間
     */
    @TableField("time")
    private String time;

    /**
     * 送金メッセージ
     */
    @TableField("message")
    private String message;
}
