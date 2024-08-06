package main.java.com.cultural_mixers.bank_application_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cultural_mixers.bank_application_backend.dao.UserDao;
import com.cultural_mixers.bank_application_backend.domain.User;
import com.cultural_mixers.bank_application_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SendServiceImpl extends ServiceImpl<SendDao, Send> implements SendService {
    @Autowired
    private SendDao sendDao;

    @Override
    public boolean sendMoney(Send send) {
        try {

            
            int balance = sendDao.selectBalance(send);
            if (balance < send.getMoney()) {
                return false;
            }
            sendDao.sendMoney(send);
            sendDao.receiveMoney(send);
            sendDao.sendRecords(send);
            return true
        } catch (Exception e) {
            return false
        }

    // @Override
    // public boolean receiveMoney(Send send) {
    //     sendDao.receiveMoney(send);
    //     return true;
    // }

    // @Override
    // public boolean sendRecords(Send send) {
    //     sendDao.sendRecords(send);
    //     return true;
    // }
}