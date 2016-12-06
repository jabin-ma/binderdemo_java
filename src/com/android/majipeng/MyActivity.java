package com.android.majipeng;


import android.annotation.Nullable;
import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ServiceManager;
import android.util.Log;
import android.widget.Toast;

public class MyActivity extends Activity {
    IMyService service;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if(service==null){
        try {
            IBinder binder=ServiceManager.getService("com.android.majipeng.IMyService");
            Log.d("mjp","c++ binder:"+binder);
            service=IMyService.Stub.asInterface(binder);
            int say=service.say();
            Toast.makeText(this,"Say:"+say,Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Log.e("mjp","MydemoError",e);
        }
        }
    }
}