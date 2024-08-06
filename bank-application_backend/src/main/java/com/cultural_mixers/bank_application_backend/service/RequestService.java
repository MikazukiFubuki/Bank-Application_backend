package com.cultural_mixers.bank_application_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cultural_mixers.bank_application_backend.domain.Request;
import com.cultural_mixers.bank_application_backend.domain.User;

import java.util.List;

public interface RequestService extends IService<Request> {

    /**
     * 請求処理
     * @param request
     */
    boolean requestMoney(Request request);

    /**
     * 請求処理後、リンク情報を検索
     * @param request
     */
    Request requestMoneySelect(Request request);


    /**
     * 請求情報
     * @param request_id
     * @return
     */
    Request selectRequest(Integer request_id);

    /**
     * 請求履歴
     * @param req_user_id
     * @return
     */
    List<Request> selectHistory(Integer req_user_id);


}
