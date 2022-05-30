package com.example.voicemaster.login;

import static org.junit.Assert.*;

import org.junit.Test;

public class Login_ActivityTest {

    @Test
    public void readUsersInfo() {
    }

    /*
     * 获取用户信息
     */
    @Test
    public void readUserInfo() {
        Login_Activity loginActivity = new Login_Activity();
        String name = "user";
        String password = "123456";
        loginActivity.login(name, password);
        // 获取用户的信息
        loginActivity.readUserInfo();
    }

    /*
     * 测试登录功能
     */
    @Test
    public void login() {
        Login_Activity loginActivity = new Login_Activity();
        String name = "user";
        String password = "123456";
        boolean result = loginActivity.login(name, password);
        System.out.println(result);
    }

    /*
     * 测试登录功能
     */
    @Test
    public void login1() {
        Login_Activity loginActivity = new Login_Activity();
        // 使用错误的用户名
        String name = "";
//        String name = "klashdkfhasldkghlas";
        // 使用超出限制的密码
        String password = "1hksdfkahsdkfhalkshdfaskdf";
//        String password = "123456";
        boolean result = loginActivity.login(name, password);
        System.out.println(result);
    }
}