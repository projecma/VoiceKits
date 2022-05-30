package com.example.voicemaster.tool;

import static org.junit.Assert.*;

import org.junit.Test;

public class VocalVerifyTest {

    /*
     * 注册声纹
     */
    @Test
    public void vocalEnroll() {
        // 创建数组存储密码信息
        int[] mNumPwdSegs = new int[20];
        // 将密码存入缓冲中
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append("请长按“按住说话”按钮！\n");
        strBuffer.append("请读出：" + mNumPwdSegs[0] + "\n");
        strBuffer.append("训练 第" + 1 + "遍，剩余4遍\n");
        String s = strBuffer.toString();

        VocalVerify vocalVerify = new VocalVerify();
        vocalVerify.vocalEnroll();
    }

    /*
     * 声纹验证
     */
    @Test
    public void vocalVerify() {
        // 创建数组存储密码信息
        String mVerifyNumPwd = "172952925";
        // 验证密码
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append("您的验证密码：" + mVerifyNumPwd + "\n");
        strBuffer.append("请长按“按住说话”按钮进行验证！\n");
        String s = strBuffer.toString();

        VocalVerify vocalVerify = new VocalVerify();
        vocalVerify.vocalVerify();
    }

    /*
     * 下载密码
     */
    @Test
    public void downloadPassword() {
        VocalVerify vocalVerify = new VocalVerify();
        vocalVerify.downloadPwd();
        // 查看密码
        System.out.println(vocalVerify.toString());
    }
}