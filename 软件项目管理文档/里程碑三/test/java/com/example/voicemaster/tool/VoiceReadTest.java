package com.example.voicemaster.tool;

import static org.junit.Assert.*;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.util.ResourceUtil;

import org.junit.Test;

import java.io.IOException;

public class VoiceReadTest {

    /*
     * 获取资源路径
     */
    @Test
    public void getResourcePath() {
        StringBuffer tempBuffer = new StringBuffer();
        // 声明类型
        String type = "tts";
        //
        String mEngineType = "";
        if(mEngineType.equals(SpeechConstant.TYPE_XTTS)){
            type="xtts";
        }
        //合成通用资源
        tempBuffer.append(ResourceUtil.generateResourcePath(null, ResourceUtil.RESOURCE_TYPE.assets, type+"/common.jet"));
        tempBuffer.append(";");
        //发音人资源
        if(mEngineType.equals(SpeechConstant.TYPE_XTTS)){
            tempBuffer.append(ResourceUtil.generateResourcePath(null, ResourceUtil.RESOURCE_TYPE.assets, type+"/"+ VoiceRead.voicerXtts+".jet"));
        }else {
            tempBuffer.append(ResourceUtil.generateResourcePath(null, ResourceUtil.RESOURCE_TYPE.assets, type + "/" + VoiceRead.voicerLocal + ".jet"));
        }

        // 输出结果
        System.out.println(tempBuffer.toString());
    }

    /*
     * 测试写入功能
     */
    @Test
    public void writeToFile() {
        VoiceRead voiceRead = new VoiceRead();
        byte[] bytes = new byte[1024];
        try {
            voiceRead.writeToFile(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}