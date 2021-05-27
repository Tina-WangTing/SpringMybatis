package com.wt.servlet;

import com.wt.pojo.User;
import com.wt.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
@WebServlet("/userServlet")
public class userServlet extends javax.servlet.http.HttpServlet {


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        try {
            ApplicationContext applicationContext=
                    new ClassPathXmlApplicationContext("mybatis-spring.xml");
            UserService userService=(UserService) applicationContext.getBean("userServiceImpl");
            User user= userService.loginUser("王洋","0000000");
            if(user!=null){
                System.out.println("登录"+user.toString());
            }else{
                System.out.println("登录失败！！！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
