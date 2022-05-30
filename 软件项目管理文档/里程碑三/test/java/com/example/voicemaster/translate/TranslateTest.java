package com.example.voicemaster.translate;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Map;

public class TranslateTest {

    private Translate translate = new Translate();

    /*
     *
     */
    @Test
    public void resolve() {
        translate.resolve(new String("test"));
    }

    /*
     * 测试翻译功能
     */
    @Test
    public void runTranslate() throws Exception {
        String body = translate.buildHttpBody();
        String resultStr = null;
        Map<String, String> header = translate.buildHttpHeader(body);

        try {
            translate.runTranslate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}