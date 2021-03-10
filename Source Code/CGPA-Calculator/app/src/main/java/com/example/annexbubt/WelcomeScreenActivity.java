package com.example.annexbubt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class WelcomeScreenActivity extends AppCompatActivity {


    private int SLEEP_TIMER=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome_screen);
        getSupportActionBar().hide();

        LogoLuncher logoLuncher = new LogoLuncher();
        logoLuncher.start();


    }

    private class LogoLuncher extends Thread{

        public void run(){
            try{
                sleep(1000 *SLEEP_TIMER);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            Intent intent = new Intent(WelcomeScreenActivity.this,MainActivity.class);
            startActivity(intent);
            WelcomeScreenActivity.this.finish();

        }

    }


}
