package com.wt.service.impl;

import com.wt.dao.UserDao;
import com.wt.pojo.User;

import com.wt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional  //引入事务类
@Service
public class UserServiceImpl implements UserService{
    @Autowired
   private UserDao userDao;
    //用户登录
    public User loginUser(String userName,
                          String userPassword)throws  Exception{

        return userDao.loginUser(userName,userPassword);

    }
    //用户更新
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateUserById() throws Exception {
        int i =userDao .updateUserById("avd",23) ;
        return 0;
    }






}
