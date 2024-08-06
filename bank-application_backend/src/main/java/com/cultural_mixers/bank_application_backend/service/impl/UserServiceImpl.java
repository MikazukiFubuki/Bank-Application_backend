package com.cultural_mixers.bank_application_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cultural_mixers.bank_application_backend.dao.UserDao;
import com.cultural_mixers.bank_application_backend.domain.User;
import com.cultural_mixers.bank_application_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    private UserDao userDao;



    @Override
    public List<User> selectALL(User user) {
        List<User> list = userDao.selectALL(user);
        return list;
    }

    @Override
    public User selectByUser_id(Integer user_id) {
        User user = userDao.selectByUser_id(user_id);
        return user;
    }

    @Override
    public List<User> selectUserList(Integer user_id) {
        List<User> list = userDao.selectUserList(user_id);
        return list;
    }

    @Override
    public User selectBalance(Integer user_id) {
        User user = userDao.selectBalance(user_id);
        return user;
    }
}