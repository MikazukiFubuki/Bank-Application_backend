package com.cultural_mixers.bank_application_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cultural_mixers.bank_application_backend.domain.Send;


public interface SendService extends IService<Send> {

    /**
     * 送金処理
     * @param send
     */
    boolean sendMoney(Send send);

    /**
     * 受取処理
     * @param send
     */
    boolean receiveMoney(Send send);

    /**
     * 送金記録
     * @param send
     */
    boolean sendRecords(Send send);
}
