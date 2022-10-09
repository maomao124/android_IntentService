package mao.android_intentservice.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;


public class MyIntentService extends IntentService
{

    public interface OnServiceCompleteListener
    {
        void OnServiceComplete();
    }

    private static final String TAG = "MyIntentService";

    private int count = 0;

    private final MyBinder myBinder = new MyBinder();

    public class MyBinder extends Binder
    {
        public int getCount()
        {
            return count;
        }


        public void start(OnServiceCompleteListener l)
        {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    Log.d(TAG, "run: " + Thread.currentThread().getName());
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    l.OnServiceComplete();
                }
            }).start();
        }

    }


    public MyIntentService()
    {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent)
    {
        //Intent是从Activity发过来的，携带识别参数，根据参数不同执行不同的任务
        if (intent == null)
        {
            return;
        }
        String action = intent.getExtras().getString("param");

        if (action.equals("s1"))
        {
            Log.i(TAG, "启动service1");
        }
        else if (action.equals("s2"))
        {
            Log.i(TAG, "启动service2");
        }
        else if (action.equals("s3"))
        {
            Log.i(TAG, "启动service3");
        }

        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        Log.d(TAG, "onBind: ");
        return myBinder;
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId)
    {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void setIntentRedelivery(boolean enabled)
    {
        super.setIntentRedelivery(enabled);
        Log.d(TAG, "setIntentRedelivery: ");
    }


    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}