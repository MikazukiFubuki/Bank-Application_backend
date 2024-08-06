package com.cultural_mixers.bank_application_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cultural_mixers.bank_application_backend.domain.Pay;
import com.cultural_mixers.bank_application_backend.domain.Request;

import java.util.List;

public interface PayService extends IService<Pay> {

    /**
     * 支払処理
     * @param pay
     */
    boolean payment(Pay pay);


    /**
     * 支払い済み
     * @param request_id
     * @return
     */
    List<Pay> selectPaid(Integer request_id);

}
