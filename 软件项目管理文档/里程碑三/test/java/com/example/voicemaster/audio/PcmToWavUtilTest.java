package com.example.voicemaster.audio;

import org.junit.Test;

public class PcmToWavUtilTest {

    /*
     * 录音文件格式转换
     */
    @Test
    public void test1() {
        // 源文件路径
        String resourceFile = "src/main/res/file1";
        String targetFile = "src/main/res/file2";
        // 调用接口
        PcmToWavUtil pcmToWavUtil = new PcmToWavUtil();
        pcmToWavUtil.pcmToWav(resourceFile, targetFile);
    }

    /*
     * 录音文件格式转换，输入错误用例
     */
    @Test
    public void test2() {
        // 源文件路径
        String resourceFile = "src/main/res/file1.txt";
        // 目标文件路径
        String targetFile = "src/main/res/file2";
        // 调用接口
        PcmToWavUtil pcmToWavUtil = new PcmToWavUtil();
        pcmToWavUtil.pcmToWav(resourceFile, targetFile);
    }
}