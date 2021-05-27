package com.wt.service;

import com.wt.pojo.User;



public interface UserService {
    //用户登录
    public User loginUser(String userName,
                          String userPassword)throws  Exception;

    //更新用户信息
    public  int updateUserById()throws Exception ;

    //更新用户信息
//    public int updateUserById(String userName,Integer id)throws Exception;
}
