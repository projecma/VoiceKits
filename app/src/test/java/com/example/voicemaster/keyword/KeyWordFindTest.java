package com.example.voicemaster.keyword;

import android.widget.TextView;

import org.junit.Test;


public class KeyWordFindTest {

    KeyWordFind keyWord = new KeyWordFind();

    /*
     * 测试正常输入时，能否调用远程接口，并把结果保存到 TextView 对象中
     */
    @Test
    public void test1() {
        // 测试文本
        keyWord.TEXT = "我明天想去爬山，前提是不要下雨";
        // 调用接口
        keyWord.getResult();
        TextView tv_key = keyWord.getTV_Key();
        // 查看分析结果
        System.out.println(tv_key.toString());;
    }

    /*
     * 测试空字符串的调用结果
     */
    @Test
    public void test2() {
        // 测试文本
        keyWord.TEXT = "";
        // 调用接口
        keyWord.getResult();
        TextView tv_key = keyWord.getTV_Key();
        // 查看分析结果
        System.out.println(tv_key.toString());;
    }

}