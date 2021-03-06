package com.example.voicemaster;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.example.voicemaster.audio.SoundRecord;
import com.example.voicemaster.audio.LongVoice;
import com.example.voicemaster.keyword.KeyWordFind;
import com.example.voicemaster.tool.VocalVerify;
import com.example.voicemaster.tool.VoiceRead;
import com.example.voicemaster.tool.VoiceToWord;
import com.example.voicemaster.tool.VoiceTest;
import com.example.voicemaster.tool.VoiceAwake;
import com.example.voicemaster.translate.Translate;
import com.example.voicemaster.ui.AboutActivity;
import com.example.voicemaster.ui.SettingActivity;
import com.example.voicemaster.voicechange.ChangeVoive;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "cypress";
    private AppBarConfiguration mAppBarConfiguration;
    private NavigationView navigationView;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestPermissions();

        // 请勿在“=”与appid之间添加任何空字符或者转义符
        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=f7ea5ed4");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_voicetoword)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        //导航栏选择
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_voicetoword:
                        Log.d(TAG, " 打开声音转文字");
                        startActivity(new Intent(MainActivity.this, VoiceToWord.class));
                        break;
                    case R.id.nav_voicesyn:
                        Log.d(TAG, "onNavigationItemSelected: 打开语音阅读");
                        startActivity(new Intent(MainActivity.this, VoiceRead.class));
                        break;
                    case R.id.nav_voicetest:
                        Log.d(TAG, "onNavigationItemSelected: 打开朗读打分");
                        startActivity(new Intent(MainActivity.this, VoiceTest.class));
                        break;
                    case R.id.nav_voiceawake:
                        Log.d(TAG, "onNavigationItemSelected: 打开语音响应");
                        startActivity(new Intent(MainActivity.this, VoiceAwake.class));
                        break;
                    case R.id.nav_VoicalID:
                        Log.d(TAG, "onNavigationItemSelected: 打开声纹管理");
                        startActivity(new Intent(MainActivity.this, VocalVerify.class));
                        break;
                    case R.id.nav_KeyWord:
                        Log.d(TAG, "onNavigationItemSelected: 打开关键词提取");
                        startActivity(new Intent(MainActivity.this, KeyWordFind.class));
                        break;
                    case R.id.nav_Translation:
                        Log.d(TAG, "onNavigationItemSelected: 打开翻译");
                        startActivity(new Intent(MainActivity.this, Translate.class));
                        break;
                    case R.id.nav_sound_record:
                        Log.d(TAG, "onNavigationItemSelected: 打开录音功能");
                        startActivity(new Intent(MainActivity.this, SoundRecord.class));
                        break;
                    case R.id.nav_long:
                        Log.d(TAG, "onNavigationItemSelected: 打开会议语音功能");
                        startActivity(new Intent(MainActivity.this, LongVoice.class));
                        break;
                    case R.id.nav_voice_change:
                        Log.d(TAG, "onNavigationItemSelected: 打开声音处理功能");
                        startActivity(new Intent(MainActivity.this, ChangeVoive.class));
                        break;
                    case R.id.nav_else_setting:
                        Log.d(TAG, "onNavigationItemSelected: 打开声设置");
                        startActivity(new Intent(MainActivity.this, SettingActivity.class));
                        break;
                    case R.id.nav_else_about:
                        Log.d(TAG, "onNavigationItemSelected: 打开关于");
                        startActivity(new Intent(MainActivity.this, AboutActivity.class));
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //为菜单充气；这会将项目添加到操作栏（如果有）。
        getMenuInflater().inflate(R.menu.main, menu);
//        Log.d(TAG, "onCreateOptionsMenu: ");
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.d(TAG, "onSupportNavigateUp: ");
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    //动态权限申请
    private void requestPermissions() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                int permission = ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (permission != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.LOCATION_HARDWARE,
                            Manifest.permission.READ_PHONE_STATE,
                            Manifest.permission.WRITE_SETTINGS,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.RECORD_AUDIO,
                            Manifest.permission.READ_CONTACTS}, 0x0010);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


}
