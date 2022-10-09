package mao.android_intentservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.telecom.ConnectionService;
import android.util.Log;
import android.widget.Button;

import mao.android_intentservice.service.MyIntentService;

public class MainActivity extends AppCompatActivity
{

    private static final String TAG = "MainActivity";

    private MyIntentService.MyBinder binder;

    private final ServiceConnection serviceConnection = new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            Log.d(TAG, "onServiceConnected: ");
            binder = (MyIntentService.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name)
        {
            Log.d(TAG, "onServiceDisconnected: ");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent1 = new Intent();
        intent1.setAction("mao.android_intentservice.service.MyIntentService");
        intent1.setPackage("mao.android_intentservice");
        intent1.putExtra("param", "s1");

        Intent intent2 = new Intent();
        intent2.setAction("mao.android_intentservice.service.MyIntentService");
        intent2.setPackage("mao.android_intentservice");
        intent2.putExtra("param", "s2");

        Intent intent3 = new Intent();
        intent3.setAction("mao.android_intentservice.service.MyIntentService");
        intent3.setPackage("mao.android_intentservice");
        intent3.putExtra("param", "s3");


        bindService(intent1, serviceConnection, BIND_AUTO_CREATE);
        bindService(intent2, serviceConnection, BIND_AUTO_CREATE);
        bindService(intent3, serviceConnection, BIND_AUTO_CREATE);

    }
}