package com.example.annexbubt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {


    private EditText userName,userEmail,userPassword,userIntake,userSection,userId;
    private Button regBtn;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;
    private ImageView userProfilePic;
    String name,email,password,section,intake,Routine="Edit Url",FessandWaiver="Edit Url",AcademicInfo="Edit Url",id;
    String previous_course="Edit url",present_course="Edit url",future_course="Edit url";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        SetupUIVwies();

        firebaseAuth = FirebaseAuth.getInstance();

        getSupportActionBar().setTitle("SignUp");


        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    //database
                    String user_email = userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                               sendEmailVerification();

                            }
                            else
                            {
                                Toast.makeText(RegistrationActivity.this,"Registration Failed..!!!",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });


                }
            }
        });


        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
            }
        });



    }
    private void SetupUIVwies(){

        userName = (EditText)findViewById(R.id.etUserName);
        userEmail = (EditText)findViewById(R.id.etUserEmail);
        userPassword = (EditText)findViewById(R.id.etUserPassword);
        userIntake = (EditText)findViewById(R.id.etUserIntake);
        userSection = (EditText)findViewById(R.id.etUserSection);
        userId = (EditText)findViewById(R.id.etUserId);

        regBtn = (Button)findViewById(R.id.btnRegister);
        userLogin = (TextView)findViewById(R.id.tvUserLogin);

       userProfilePic= (ImageView)findViewById(R.id.ivUserProfile);

    }

    private Boolean validate(){

        Boolean result= false;

         name = userName.getText().toString();
         password = userPassword.getText().toString();
         email = userEmail.getText().toString();
        intake = userIntake.getText().toString();
         section = userSection.getText().toString();
         id = userId.getText().toString();

        if(name.isEmpty() || password.isEmpty() || email.isEmpty() || intake.isEmpty() || section.isEmpty() || id.isEmpty()){

            Toast.makeText(RegistrationActivity.this,"Please enter all the details",Toast.LENGTH_SHORT).show();
        }
        else{
            result = true;
        }

        return result;




    }

    private void sendEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if(firebaseUser!=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                  if(task.isSuccessful())
                  {   sendUserData();
                      Toast.makeText(RegistrationActivity.this,"Sucessfully Register and verification mail has been sent",Toast.LENGTH_SHORT).show();
                      firebaseAuth.signOut();
                      finish();
                      startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
                  }
                  else
                  {
                      Toast.makeText(RegistrationActivity.this,"Sucessfully Register and verification mail has been sent",Toast.LENGTH_SHORT).show();
                  }
                }
            });
        }



    }
   private void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());


        UserProfile userProfile = new UserProfile(name,id,intake,section,email,Routine,FessandWaiver,AcademicInfo);
        myRef.setValue(userProfile);


       DatabaseReference AcademicRef = firebaseDatabase.getReference(firebaseAuth.getUid()).child("AcademicInfo");
       UserAcademicInfo userAcademicInfo = new UserAcademicInfo(previous_course,present_course,future_course);
           AcademicRef.setValue(userAcademicInfo);


    }




}
