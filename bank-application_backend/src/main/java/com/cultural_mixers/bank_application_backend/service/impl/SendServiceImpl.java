package com.cultural_mixers.bank_application_backend.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cultural_mixers.bank_application_backend.dao.SendDao;
import com.cultural_mixers.bank_application_backend.dao.UserDao;
import com.cultural_mixers.bank_application_backend.domain.Send;
import com.cultural_mixers.bank_application_backend.domain.User;
import com.cultural_mixers.bank_application_backend.service.SendService;
import com.cultural_mixers.bank_application_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SendServiceImpl extends ServiceImpl<SendDao, Send> implements SendService {
    @Autowired
    private SendDao sendDao;

    @Autowired
    private UserDao userDao;

    @Override
    public boolean sendMoney(Send send) {
        try {

            User user = userDao.selectBalance(send.getSe_user_id());
            double balance = user.getBalance();
            if (balance < send.getMoney()) {
                return false;
            }
            sendDao.sendMoney(send);
            sendDao.receiveMoney(send);
            sendDao.sendRecords(send);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}