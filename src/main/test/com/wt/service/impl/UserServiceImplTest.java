package com.wt.service.impl;

import com.wt.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserServiceImplTest {
    @Test
    public void updateUserById() throws Exception {

        try {
            ApplicationContext applicationContext=new
                    ClassPathXmlApplicationContext("mybatis-spring.xml");
            UserService userService=(UserService) applicationContext.getBean("userServiceImpl");
            userService.updateUserById();
//            userService.updateUserById("zxc",2);
//            userService.updateUserById("wzyasfdgfdsafghgfds",5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}