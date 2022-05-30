package com.example.voicemaster.tool;

import static org.junit.Assert.*;

import android.speech.tts.Voice;

import org.junit.Test;

import java.io.File;

public class VoiceAwakeTest {

    @Test
    public void queryResource() {
        // 调用接口
        VoiceAwake voiceAwake = new VoiceAwake();
        voiceAwake.queryResource();
        // 查看结果
        System.out.println(voiceAwake.getResources());
    }

    @Test
    public void getByetsFromFile() {
        // 文件名
        String fileName = "src/main/res/file/1.txt";
        byte[] bytesFromFile = VoiceAwake.getByetsFromFile(new File(fileName));
        System.out.println(bytesFromFile);
    }
}