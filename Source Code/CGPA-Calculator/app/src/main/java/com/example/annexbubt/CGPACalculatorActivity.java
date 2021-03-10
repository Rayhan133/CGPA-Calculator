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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CGPACalculatorActivity extends AppCompatActivity {

    private Spinner subnoslt;
    private Button subnoandgrdpntOK;
    public int valueofsubjectNumber_i=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpacalculator);


        getSupportActionBar().setTitle("CGPA Calculation");



        subnoslt = (Spinner) findViewById(R.id.spinner3);
        subnoandgrdpntOK = (Button)findViewById(R.id.btn_OK);


        List<String> SubjectNumber = new ArrayList<String>();
        SubjectNumber.add("Select Subject No.");
        SubjectNumber.add("01");
        SubjectNumber.add("02");
        SubjectNumber.add("03");
        SubjectNumber.add("04");
        SubjectNumber.add("05");
        SubjectNumber.add("06");
        SubjectNumber.add("07");
        SubjectNumber.add("08");
        SubjectNumber.add("09");
        SubjectNumber.add("10");

        ArrayAdapter<String> SubjectNumber_Adepter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,SubjectNumber);
        SubjectNumber_Adepter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subnoslt.setAdapter(SubjectNumber_Adepter);

        subnoslt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                subnoslt.setSelection(i);
                valueofsubjectNumber_i=i;


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        subnoandgrdpntOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCGPACalculatePage(valueofsubjectNumber_i);

            }
        });












    }

    private void viewCGPACalculatePage(int i){

        if(i==1) {startActivity(new Intent(CGPACalculatorActivity.this,NumPoint_1_Activity.class)); }
        else if(i==2){startActivity(new Intent(CGPACalculatorActivity.this,NumPoint_2_Activity.class));}
        else if(i==3 ){startActivity(new Intent(CGPACalculatorActivity.this,NumPoint_3_Activity.class));}
        else if(i==4 ){startActivity(new Intent(CGPACalculatorActivity.this,NumPoint_4_Activity.class));}
        else if(i==5){startActivity(new Intent(CGPACalculatorActivity.this,NumPoint_5_Activity.class));}
        else if(i==6){startActivity(new Intent(CGPACalculatorActivity.this,NumPoint_6_Activity.class));}
        else if(i==7){startActivity(new Intent(CGPACalculatorActivity.this,NumPoint_7_Activity.class));}
        else if(i==8){startActivity(new Intent(CGPACalculatorActivity.this,NumPoint_8_Activity.class));}
        else if(i==9 ){startActivity(new Intent(CGPACalculatorActivity.this,NumPoint_9_Activity.class));}
        else if(i==10 ){startActivity(new Intent(CGPACalculatorActivity.this,NumPoint_10_Activity.class));}
        else if(i==0) {
            finish();
            Toast.makeText(CGPACalculatorActivity.this, "Please Select Number of Subject", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(CGPACalculatorActivity.this,CGPACalculatorActivity.class));
        }
        else {
            finish();
            Toast.makeText(CGPACalculatorActivity.this, "Selected failed reloading page!!!", Toast.LENGTH_SHORT).show();

        }






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
                startActivity(new Intent(CGPACalculatorActivity.this,SecondActivity.class));
                break;
            }




        }
        return super.onOptionsItemSelected(item);
    }


}
