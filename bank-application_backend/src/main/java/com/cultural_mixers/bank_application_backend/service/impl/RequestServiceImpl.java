package com.cultural_mixers.bank_application_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cultural_mixers.bank_application_backend.dao.PayDao;
import com.cultural_mixers.bank_application_backend.dao.RequestDao;
import com.cultural_mixers.bank_application_backend.dao.UserDao;
import com.cultural_mixers.bank_application_backend.domain.Pay;
import com.cultural_mixers.bank_application_backend.domain.Request;
import com.cultural_mixers.bank_application_backend.domain.User;
import com.cultural_mixers.bank_application_backend.service.RequestService;
import com.cultural_mixers.bank_application_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class RequestServiceImpl extends ServiceImpl<RequestDao, Request> implements RequestService {

    @Autowired
    private RequestDao requestDao;

    @Autowired
    private PayDao payDao;

    @Override
    public boolean requestMoney(Request request) {
        requestDao.reqMoney(request);
        return true;
    }

    @Override
    public Request requestMoneySelect(Request request) {
        Integer req_user_id = request.getReq_user_id();
        Double money = request.getMoney();
        String message = request.getMessage();
        Request request1 = requestDao.selectRequestId(req_user_id, money, message);
        Integer request_id = request1.getRequest_id();
        Request request2 = requestDao.selectRequest(request_id);
        return request2;
    }

    @Override
    public Request selectRequest(Integer request_id) {
        Request request = requestDao.selectRequest(request_id);
        return request;
    }

    @Override
    public List<Request> selectHistory(Integer req_user_id) {
        // 通过req_user_id获取request_id列表
        List<Request> list = requestDao.selectRequestIdByReq_user_id(req_user_id);

        // 获取所有的request_id
        List<Integer> requestIds = list.stream()
                .map(Request::getRequest_id)
                .collect(Collectors.toList());

        // 通过request_id列表获取对应的pay数据
        List<Pay> list1 = new ArrayList<>();
        for (Integer requestId : requestIds) {
            list1.addAll(payDao.selectPaid(requestId));
        }

        // 通过req_user_id获取历史记录
        List<Request> list2 = requestDao.selectHistory(req_user_id);

        // 将list1中的pay数据合并到list2中
        for (Request request : list2) {
            List<Pay> pays = list1.stream()
                    .filter(pay -> pay.getRequest_id().equals(request.getRequest_id()))
                    .collect(Collectors.toList());
            request.setPaid(pays);
        }

        return list2;
    }

}