package com.example.annexbubt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button logout;
    private FirebaseAuth auth;

    private Button CGPAcalculator;
    private Button FeesAndWaiver;
    private Button AcademicInfo;
    private Button Routine;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        firebaseAuth = FirebaseAuth.getInstance();

        logout = (Button) findViewById(R.id.btnLogout);

        getSupportActionBar().setTitle("Home");


        CGPAcalculator = (Button)findViewById(R.id.btnCGPACalculat);
        FeesAndWaiver = (Button)findViewById(R.id.btnFeesAndWavier);
        AcademicInfo = (Button)findViewById(R.id.btnAcademicinfo);
        Routine = (Button)findViewById(R.id.btnRtn);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Logout();
            }
        });
        CGPAcalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this,CGPACalculatorActivity.class));

            }
        });

        FeesAndWaiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this,FeesAndWaiverActivity.class));

            }
        });

        Routine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   startActivity(new Intent(SecondActivity.this,RoutineActivity.class));
            }
        });
         AcademicInfo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(SecondActivity.this,AcademicInformationActivity.class));
             }
         });



    }

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(SecondActivity.this,MainActivity.class));


    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.LogoutMenu:{
                Logout();
                 break;
            }
            case R.id.AboutMenu:{
                startActivity(new Intent(SecondActivity.this,AboutActivity.class));
                break;
            }

            case R.id.refreshMenu:{
                startActivity(new Intent(SecondActivity.this,SecondActivity.class));
                break;
            }



        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
        builder.setTitle("Exit?")
                .setMessage("Are you sure?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      SecondActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("Cancel",null).setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();



    }
}
