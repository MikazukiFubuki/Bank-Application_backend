package com.cultural_mixers.bank_application_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cultural_mixers.bank_application_backend.domain.Send;


public interface SendService extends IService<Send> {

    /**
     * 送金処理
     * @param send
     */
    boolean sendMoney(Send send);
}