package com.example.voicemaster.tool;

import static org.junit.Assert.*;

import android.net.Uri;

import org.junit.Test;

public class VoiceToWordTest {

    /*
     *
     */
    @Test
    public void isExternalStorageDocument() {
        // 测试
        VoiceToWord voiceToWord = new VoiceToWord();
        voiceToWord.isExternalStorageDocument(null);
    }

    /*
     *
     */
    @Test
    public void isDownloadsDocument() {
        // todo
    }

    /*
     *
     */
    @Test
    public void isMediaDocument() {
        // todo
    }

    /*
     *
     */
    @Test
    public void getFileName() {
        // todo
    }

    /*
     *
     */
    @Test
    public void verifyStoragePermissions() {
        // todo
    }
}