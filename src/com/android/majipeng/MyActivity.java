package com.android.majipeng;


import android.annotation.Nullable;
import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ServiceManager;
import android.util.Log;
import android.widget.Toast;
import htzx.INativeService;
import htzx.INativeSession;
public class MyActivity extends Activity {
    INativeService service;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if(service==null){
        try {
            IBinder binder=ServiceManager.getService("com.android.majipeng.IMyService");
            Log.d("mjp","c++ binder:"+binder);
            service=INativeService.Stub.asInterface(binder);
            INativeSession session = service.createSession();
            session.sayMyName();
        }catch (Exception e){
            Log.e("mjp","MydemoError",e);
        }
        }
    }
}