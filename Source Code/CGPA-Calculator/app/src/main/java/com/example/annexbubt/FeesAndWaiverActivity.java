package com.example.annexbubt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FeesAndWaiverActivity extends AppCompatActivity {








    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference childreference;
    private TextView fessaandwaivertv;
    private ProgressDialog progressDialog;
    PhotoView photoView ;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fees_and_waiver);
        getSupportActionBar().hide();



        fessaandwaivertv = (TextView)findViewById(R.id.tvFeesAndWaivers);


        firebaseAuth = FirebaseAuth.getInstance();

        childreference =  firebaseDatabase.getReference(firebaseAuth.getUid()).child("FeesAndWaiver");

        progressDialog = new ProgressDialog(this);

         photoView = (PhotoView) findViewById(R.id.pvfeesandwaivers);







    }





    @Override
    protected void onStart() {

        super.onStart();
        progressDialog.setMessage("Loading...!!!");
        progressDialog.show();
        childreference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                String message = dataSnapshot.getValue(String.class);


                fessaandwaivertv.setText(message);

                Picasso.get()
                        .load(message)
                        .into(photoView);

                progressDialog.dismiss();

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss();

                Toast.makeText(FeesAndWaiverActivity.this,"Loading Error..!!!",Toast.LENGTH_SHORT).show();

            }
        }

        );


    }

    }

