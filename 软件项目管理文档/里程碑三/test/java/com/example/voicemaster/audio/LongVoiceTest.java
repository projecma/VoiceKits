package com.example.voicemaster.audio;

import static org.junit.Assert.*;

import com.example.voicemaster.keyword.KeyWordFind;
import com.example.voicemaster.translate.Translate;

import org.junit.Test;

public class LongVoiceTest {

    /*
     * 测试页面跳转到关键词功能，并携带数据
     */
    @Test
    public void jumpKeyWord() {
        LongVoice longVoice = new LongVoice();
        longVoice.jumpKeyWord();
        // 查看页面是否跳转，消息是否传输到新的页面
        System.out.println(new KeyWordFind().toString());
    }

    /*
     * 测试页面跳转到翻译界面功能，并携带数据
     */
    @Test
    public void jumpTranslation() {
        LongVoice longVoice = new LongVoice();
        longVoice.jumpKeyWord();
        // 查看页面是否跳转，消息是否传输到新的页面
        System.out.println(new Translate().toString());
    }
}