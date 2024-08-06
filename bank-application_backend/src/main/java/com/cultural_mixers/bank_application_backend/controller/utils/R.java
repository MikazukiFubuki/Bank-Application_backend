package com.cultural_mixers.bank_application_backend.controller.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class R implements Serializable {

    private Boolean flag; //成功の判定

    private Object data;  //データ

    private String msg; //エラーメッセージ

    public R(){}

    public R(Boolean flag){
        this.flag = flag;
    }

    public R(Boolean flag, Object data){
        this.flag = flag;
        this.data = data;
    }

    public R(Boolean flag, String msg){
        this.flag = flag;
        this.msg = msg;
    }

    public R(String msg){
        this.flag = false;
        this.msg = msg;
    }


}
