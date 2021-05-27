package com.wt.dao;

import com.wt.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    //用户登录
    public User loginUser(@Param("userName") String userName,
                          @Param("userPassword") String userPassword)throws  Exception;

    //更新用户信息
    public  int updateUserById(@Param("userName")String userName,
                               @Param("id")Integer id)throws Exception ;

}
