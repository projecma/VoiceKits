package com.example.voicemaster.audio;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.File;

public class SoundRecordTest {

    /*
     * 测试录音功能
     */
    @Test
    public void startRecord() {
        // 创建 SoundRecord 对象
        SoundRecord soundRecord = new SoundRecord();
        // 调用方法
        soundRecord.StartRecord();
        // 查看文件路径中是否已生成录音文件
    }

    /*
     * 测试播放录音文件的功能
     */
    @Test
    public void playRecord() {
        // 文件名
        String fileName = "src/main/res/audio.pcm";
        // String fileName = " ";
        // 创建对象
        SoundRecord soundRecord = new SoundRecord();
        // 导入文件
        soundRecord.setFile(new File(fileName));
        // 调用接口
        soundRecord.PlayRecord();
        // 查看接口是否调用成功
    }

    /*
     * 测试播放录音文件的功能
     */
    @Test
    public void playRecord2() {
        // 文件名
        String fileName = " ";
        // 创建对象
        SoundRecord soundRecord = new SoundRecord();
        // 导入文件
        soundRecord.setFile(new File(fileName));
        // 调用接口
        soundRecord.PlayRecord();
        // 查看接口是否调用成功
    }

    /*
     * 测试删除文件功能，异常输入：空文件
     */
    @Test
    public void deleteFile() {
        // 文件名
        String fileName = " ";
        // 创建对象
        SoundRecord soundRecord = new SoundRecord();
        // 导入文件
        soundRecord.setFile(new File(fileName));
        // 调用接口
        boolean result = soundRecord.deleteFile(fileName);
        // 查看接口是否调用成功
        System.out.println(result);
    }

    /*
     * 正常输入
     */
    @Test
    public void deleteFile2() {
        // 文件名
        String fileName = "src/main/res/audio.pcm";
        // 创建对象
        SoundRecord soundRecord = new SoundRecord();
        // 导入文件
        soundRecord.setFile(new File(fileName));
        // 调用接口
        boolean result = soundRecord.deleteFile(fileName);
        // 查看接口是否调用成功
        System.out.println(result);
    }

    /*
     * 该方法已在 PcmToWavUtilTest 中测试
     */
    @Test
    public void pcmToWav() {

    }
}