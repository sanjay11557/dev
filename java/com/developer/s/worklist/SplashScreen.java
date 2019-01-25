package com.developer.s.worklist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

public class SplashScreen extends Activity {
    private Handler handler = new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Intent i=new Intent(getApplicationContext(),WorklistLogin.class);
                    startActivity(i);
                    finish();
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        },2000);
    }
}
