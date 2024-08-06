package com.cultural_mixers.bank_application_backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cultural_mixers.bank_application_backend.domain.Pay;
import com.cultural_mixers.bank_application_backend.domain.Request;

import java.util.List;

public interface PayDao extends BaseMapper<Pay> {

    /**
     * 支払処理
     * @param pay
     */
    void payment(Pay pay);

    /**
     * 支払い済み
     * @param request_id
     * @return
     */
    List<Pay> selectPaid(Integer request_id);


}
