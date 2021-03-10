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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AcademicInformationActivity extends AppCompatActivity {



    private  Button previous,present,future;











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_information);

        previous = (Button)findViewById(R.id.btnpreviouscourse);
        present = (Button)findViewById(R.id.btnpresentcourse);
        future = (Button)findViewById(R.id.btnfuturecourse);




        getSupportActionBar().setTitle("Academic Information");


         previous.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(AcademicInformationActivity.this,Previous_Course_Activity.class));


             }
         });

        present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AcademicInformationActivity.this,Present_Course_Activity.class));


            }
        });

        future.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AcademicInformationActivity.this,Future_Course_Activity.class));

            }
        });



        //..........................................................................................................

















    }

    @Override
    public boolean onCreateOptionsMenu(Menu home) {
        getMenuInflater().inflate(R.menu.home,home);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.HomeMenu:{
                startActivity(new Intent(AcademicInformationActivity.this,SecondActivity.class));
                break;
            }




        }
        return super.onOptionsItemSelected(item);
    }


}
