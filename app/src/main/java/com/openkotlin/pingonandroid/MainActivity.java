package com.openkotlin.pingonandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.openkotlin.pingonandroid.netease.LDNetDiagnoService.LDNetDiagnoListener;
import com.openkotlin.pingonandroid.netease.LDNetDiagnoService.LDNetDiagnoService;
import com.openkotlin.pingonandroid.netease.LDNetDiagnoService.LDNetTraceRoute;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LDNetDiagnoService _netDiagnoService = new LDNetDiagnoService(this.getApplicationContext(),
                "NetworkDiagnosis", "网络诊断应用", "", "",
                "", "www.baidu.com", "", "",
                "", "", new LDNetDiagnoListener() {
            @Override
            public void OnNetDiagnoFinished(String log) {
                Log.d("Tanck", "OnNetDiagnoFinished:" + log);
            }

            @Override
            public void OnNetDiagnoUpdated(String log) {
                Log.d("Tanck", "OnNetDiagnoUpdated:" + log);
            }
        });
        // 设置是否使用JNIC 完成traceroute
        _netDiagnoService.setIfUseJNICTrace(false);
        _netDiagnoService.execute();
    }
}
