package com.example.annexbubt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Present_Course_Activity extends AppCompatActivity {


    private FirebaseAuth firebaseAuth;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    private DatabaseReference childreference;

    private TextView presentcoursetv;

    private ProgressDialog progressDialog;
    PhotoView photoView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_present__course_);
        getSupportActionBar().hide();



        firebaseAuth = FirebaseAuth.getInstance();

        childreference = firebaseDatabase.getReference(firebaseAuth.getUid()).child("AcademicInfo").child("Present_Courses");

        presentcoursetv = (TextView) findViewById(R.id.tvPresentcourse);
        photoView = (PhotoView) findViewById(R.id.pvpresentcourse);

        progressDialog = new ProgressDialog(this);


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

                                                     presentcoursetv.setText(message);

                                                     Picasso.get()
                                                             .load(message)
                                                             .into(photoView);

                                                     progressDialog.dismiss();

                                                 }


                                                 @Override
                                                 public void onCancelled(@NonNull DatabaseError databaseError) {
                                                     progressDialog.dismiss();

                                                     Toast.makeText(Present_Course_Activity.this, "Loading Error..!!!", Toast.LENGTH_SHORT).show();

                                                 }
                                             }

        );

    }
}
