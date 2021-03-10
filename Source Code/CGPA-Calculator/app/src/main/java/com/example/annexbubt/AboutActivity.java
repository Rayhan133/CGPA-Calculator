package com.example.annexbubt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    private Button aboutcancel;
    private TextView tvAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        tvAbout = (TextView)findViewById(R.id.textView4);

        tvAbout.setText("CGPA Calculator with AnnexBUBT ( A New Nexus of Excellence) shortly known as BUBT-NX is an online portal for the students and teachers of BUBT.");


        aboutcancel = (Button)findViewById(R.id.btnaboutcancel);

        aboutcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AboutActivity.this,SecondActivity.class));
            }
        });


    }

}
