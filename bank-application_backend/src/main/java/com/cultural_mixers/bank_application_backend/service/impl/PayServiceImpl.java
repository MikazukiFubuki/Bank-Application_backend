package com.cultural_mixers.bank_application_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cultural_mixers.bank_application_backend.dao.PayDao;
import com.cultural_mixers.bank_application_backend.dao.RequestDao;
import com.cultural_mixers.bank_application_backend.dao.SendDao;
import com.cultural_mixers.bank_application_backend.dao.UserDao;
import com.cultural_mixers.bank_application_backend.domain.Pay;
import com.cultural_mixers.bank_application_backend.domain.Request;
import com.cultural_mixers.bank_application_backend.domain.Send;
import com.cultural_mixers.bank_application_backend.domain.User;
import com.cultural_mixers.bank_application_backend.service.PayService;
import com.cultural_mixers.bank_application_backend.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PayServiceImpl extends ServiceImpl<PayDao, Pay> implements PayService {

    @Autowired
    private PayDao payDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RequestDao requestDao;

    @Autowired
    private SendDao sendDao;


    @Override
    public boolean payment(Pay pay) {
        try {
            User user = userDao.selectBalance(pay.getPay_user_id());
            double balance = user.getBalance();
            Request request = requestDao.selectRequest(pay.getRequest_id());
            if (balance < request.getMoney()) {
                return false;
            }
            Send send = new Send();
            send.setSe_user_id(pay.getPay_user_id());
            send.setRe_user_id(request.getReq_user_id());
            send.setMoney(request.getMoney());
            sendDao.sendMoney(send);
            sendDao.receiveMoney(send);
            payDao.payment(pay);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<Pay> selectPaid(Integer request_id) {
        List<Pay> list = payDao.selectPaid(request_id);
        return list;
    }
}