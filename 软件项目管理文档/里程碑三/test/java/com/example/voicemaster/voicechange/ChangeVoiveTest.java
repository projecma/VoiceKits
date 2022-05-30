package com.example.voicemaster.voicechange;

import static org.junit.Assert.*;

import android.view.View;

import org.junit.Test;

import java.io.File;

public class ChangeVoiveTest {

    /*
     * 测试变声功能
     */
    @Test
    public void startChange() {
        ChangeVoive changeVoive = new ChangeVoive();

        String fileName = "src/main/res/file/originFile";
        File originFile = new File(fileName);

        if (originFile != null) {
            changeVoive.startChange(new View(null));
        } else {
            System.out.println("error");
        }

    }
}