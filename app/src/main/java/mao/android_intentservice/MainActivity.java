package mao.android_intentservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{

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


        startService(intent1);
        startService(intent2);
        startService(intent3);
    }
}