package com.cultural_mixers.bank_application_backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cultural_mixers.bank_application_backend.domain.User;

import java.util.List;

public interface UserDao extends BaseMapper<User> {
    /**
     * すべてのユーザー情報を検索する
     * @param user
     * @return
     */
    List<User> selectALL(User user);

    /**
     * ユーザー1人情報を検索する
     * @param user_id
     * @return
     */
    User selectByUser_id(Integer user_id);

    /**
     * 自分以外のユーザーの情報を検索する
     * @param user_id
     * @return
     */
    List<User> selectUserList(Integer user_id);

    /**
     * 口座残高を検索する
     * @param user_id
     * @return
     */
    User selectBalance(Integer user_id);




}
