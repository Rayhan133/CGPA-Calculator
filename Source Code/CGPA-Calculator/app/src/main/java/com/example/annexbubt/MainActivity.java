package com.example.annexbubt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private  int counter = 5;
    private TextView userRegistraton;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private  TextView forgotpassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Name = (EditText) findViewById(R.id.etName);
        Password= (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);
        userRegistraton = (TextView) findViewById(R.id.tvRegister);
        forgotpassword = (TextView)findViewById(R.id.tvForgotPassword);

        Info.setText("No. of attempts remaining: 5");

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();
         if(user != null) {
             finish();
             startActivity(new Intent(MainActivity.this,SecondActivity.class));

         }


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                validate(Name.getText().toString(),Password.getText().toString());


            }
        });
        userRegistraton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegistrationActivity.class));
            }
        });
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,PasswordActivity.class));
            }
        });


    }

    private void validate(String userName, String userPassword ){

        progressDialog.setMessage("If you face any problem,Please Contact Us...!!!");
        progressDialog.show();

          firebaseAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {

                  if(task.isSuccessful()){
                      progressDialog.dismiss();
                      checkEmailVerification();
                  }
                  else{
                      Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                      counter--;
                      Info.setText("No. of attempts remaining: "+ counter);

                      progressDialog.dismiss();
                      if(counter == 0){

                          Login.setEnabled(false);

                      }

                  }


              }
          });

        }

        private void checkEmailVerification(){

             FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
             Boolean emailflag = firebaseUser.isEmailVerified();
             if(emailflag){
                 finish();
                 Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
               startActivity(new Intent(MainActivity.this,SecondActivity.class));

             }
             else{
                 Toast.makeText(this,"Verify your email",Toast.LENGTH_SHORT).show();
                 firebaseAuth.signOut();
             }



        }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Exit?")
                .setMessage("Are you sure?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("Cancel",null).setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();



    }


    }

