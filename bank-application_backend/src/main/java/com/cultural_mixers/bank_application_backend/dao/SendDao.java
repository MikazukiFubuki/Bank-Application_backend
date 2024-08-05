package com.cultural_mixers.bank_application_backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cultural_mixers.bank_application_backend.domain.Send;
import com.cultural_mixers.bank_application_backend.domain.User;

public interface SendDao extends BaseMapper<Send> {

    /**
     * 送金処理
     * @param send
     */
    void sendMoney(Send send);

    /**
     * 受取処理
     * @param send
     */
    void receiveMoney(Send send);

    /**
     * 送金記録
     * @param send
     */
    void sendRecords(Send send);
}
