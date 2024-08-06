package com.cultural_mixers.bank_application_backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cultural_mixers.bank_application_backend.domain.Request;
import com.cultural_mixers.bank_application_backend.domain.Send;
import com.cultural_mixers.bank_application_backend.domain.User;

import java.util.List;

public interface RequestDao extends BaseMapper<Request> {

    /**
     * 請求処理
     * @param request
     */
    void reqMoney(Request request);

    /**
     *
     * @param req_user_id
     * @param money
     * @param message
     * @return
     */
    Request selectRequestId(Integer req_user_id, Double money, String message);

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

    /**
     * 請求履歴
     * @param req_user_id
     * @return
     */
    List<Request> selectRequestIdByReq_user_id(Integer req_user_id);


}
