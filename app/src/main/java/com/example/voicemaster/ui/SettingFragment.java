package com.example.voicemaster.ui;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.voicemaster.R;

/**
 * 描述： 应用设置的Fragment
 *
 * @author CoderPig on 2018/02/28 13:56.
 */

public class SettingFragment extends Fragment {

    private TextView tv_app_version;

    public static SettingFragment newInstance() {
        SettingFragment fragment = new SettingFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        tv_app_version = view.findViewById(R.id.tv_app_version);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String version = "1.0";
        if(version != null) {
            tv_app_version.setText("1.0");
        }
    }
}
