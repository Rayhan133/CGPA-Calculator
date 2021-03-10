package com.example.annexbubt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class NumPoint_1_Activity extends AppCompatActivity {

    private int Keycourseselect=0;
    private int Keypointselect=0;
    Spinner NP_Coursespinner_1_1,NP_Pointspinner_1_1;
    private TextView tvTotalSGPA;
    private Button calculatecgpa,reset_1;
    private double point=0.00;
    private Button cancelcalculatecgpa_1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_point_1_);
        NP_Coursespinner_1_1 = (Spinner)findViewById(R.id.spnr_course_NP_1_1);
        NP_Pointspinner_1_1= (Spinner)findViewById(R.id.spnr_point_NP_1_1);
        tvTotalSGPA = (TextView)findViewById(R.id.tv_Total_NP_1);
        calculatecgpa =(Button)findViewById(R.id.btncalculateCGPA_1);
         cancelcalculatecgpa_1 = (Button)findViewById(R.id.btncalculateCGPAcancel_1);
         reset_1 = (Button)findViewById(R.id.btnreset_1) ;


        getSupportActionBar().setTitle("CGPA Calculation");



        reset_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Toast.makeText(NumPoint_1_Activity.this, "Reset", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(NumPoint_1_Activity.this,NumPoint_1_Activity.class));
            }
        });

        //cancel part from activite................
        cancelcalculatecgpa_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(NumPoint_1_Activity.this,CGPACalculatorActivity.class));
            }
        });



//.................................................................................................


        List<String> NP_Course = new ArrayList<String>();
        NP_Course.add("Select Course");
        NP_Course.add("English Language-II(ENG 111)");
        NP_Course.add("English Language-I(ENG 101)");
        NP_Course.add("Computer and Programming Concepts Lab(CSE 102)");
        NP_Course.add("Electronic Devices and Circuits(EEE 211)");
        NP_Course.add("Physics(PHY 101)");
        NP_Course.add("Discrete Mathematics(CSE 103)");
        NP_Course.add("Microprocessor and Interfacing(CSE 315)");
        NP_Course.add("Structured Programming Language(CSE 111)");
        NP_Course.add("Database Systems(CSE 207)");
        NP_Course.add("Statistics(STA 231)");
        NP_Course.add("Co-Ordinate Geometry and Vector Calculus(MAT 111)");
        NP_Course.add("Electronic Devices and Circuits Lab (EEE 212)");
        NP_Course.add("Advanced Programming(CSE 331)");
        NP_Course.add("Microprocessor and Interfacing Lab(CSE 316)");
        NP_Course.add("Structured Programming Language Lab(CSE 112)");
        NP_Course.add("Numerical Analysis Lab(CSE 224)");
        NP_Course.add("Differential and Integral Calculus(MAT 101)");
        NP_Course.add("Database Systems Lab(CSE 208)");
        NP_Course.add("Digital Logic Design(CSE 205)");
        NP_Course.add("Theory of Computing & Automata Theory(CSE 213)");
        NP_Course.add("Object Oriented Programming Language Lab(CSE 122)");
        NP_Course.add("Software Development I(CSE 100)");
        NP_Course.add("System Analysis and Design Lab(CSE 318)");
        NP_Course.add("Electrical Technology Lab(EEE 102)");
        NP_Course.add("Numerical Analysis(CSE 223)");
        NP_Course.add("Data Communication(CSE 209)");
        NP_Course.add("Data Structures Lab(CSE 232)");
        NP_Course.add("Linear Algebras and Differential Equations(MAT 121)");
        NP_Course.add("Object Oriented Programming Language(CSE 121)");
        NP_Course.add("Advanced Programming Lab(CSE 332)");
        NP_Course.add("Computer and Programming Concepts(CSE 101)");
        NP_Course.add("Computer Architecture(CSE 215)");
        NP_Course.add("Software Development II(CSE 200)");
        NP_Course.add("Algorithms Lab(CSE 242)");
        NP_Course.add("Digital Logic Design Lab(CSE 206)");
        NP_Course.add("Data Structures(CSE 231)");
        NP_Course.add("Principles of Economics(ECO 101)");
        NP_Course.add("Accounting Fundamentals(ACT 201)");
        NP_Course.add("Algorithms(CSE 241)");
        NP_Course.add("Complex Variable and Fourier Analysis(MAT 231)");
        NP_Course.add("System Analysis and Design(CSE 317)");
        NP_Course.add("Electrical Technology(EEE 101)");
        NP_Course.add("Software Development III(CSE 300)");
        NP_Course.add("Switching and Routing Lab(CSE 442)");
        NP_Course.add("Decision Support System(CSE 481)");
        NP_Course.add("Object Oriented Programming Language(CSE 106)");
        NP_Course.add("Wireless Networking(CSE 439)");
        NP_Course.add("Neural Network and Fuzzy Systems Lab(CSE 478)");
        NP_Course.add("Network Security(CSE 435)");
        NP_Course.add("Data Minig(CSE 475)");
        NP_Course.add("Microcontroller and Embedded Systems Lab(CSE 426)");
        NP_Course.add("Computational Geometry(CSE 471)");
        NP_Course.add("Distributed Database Management Systems(CSE 417)");
        NP_Course.add("Machine Learning(CSE 465)");
        NP_Course.add("Digital Electronics and Pulse Technique Lab(CSE 412)");
        NP_Course.add("Software Architecture Lab(CSE 462)");
        NP_Course.add("Software Development IV(CSE 400)");
        NP_Course.add("Visual Programming(CSE 459)");
        NP_Course.add("Computer Graphics Lab(CSE 342)");
        NP_Course.add("Software Security & Authentication(CSE 455)");
        NP_Course.add("Project/Thesis(CSE 498)");
        NP_Course.add("Software Engineering(CSE 327)");
        NP_Course.add("Network Administration Lab(CSE 450)");
        NP_Course.add("Interfacing & Peripherals Lab(CSE 492)");
        NP_Course.add("Computer Network Lab(CSE 320)");
        NP_Course.add("Mobile Communication(CSE 447)");
        NP_Course.add("Robotics and Computer Vision(CSE 487)");
        NP_Course.add("Operating Systems Lab(CSE 310)");
        NP_Course.add("Delay Tollerant Network Lab(CSE 444)");
        NP_Course.add("Knowledge Engineering(CSE 483)");
        NP_Course.add("Electrical Technology Lab(CSE 108)");
        NP_Course.add("Switching and Routing(CSE 441)");
        NP_Course.add("VLSI Design Lab(CSE 480)");
        NP_Course.add("Object Oriented Programming Language(CSE 105)");
        NP_Course.add("Digital Signal Processing Lab(CSE 438)");
        NP_Course.add("Neural Network and Fuzzy Systems(CSE 477)");
        NP_Course.add("Fiber Optics Communication(CSE 433)");
        NP_Course.add("Simulation and Modeling Lab(CSE 474)");
        NP_Course.add("Microcontroller and Embedded Systems(CSE 425)");
        NP_Course.add("Basic Graph Theory(CSE 469)");
        NP_Course.add("Cyber Security and Digital Forensic Lab(CSE 414)");
        NP_Course.add("Software Design Pattern Lab(CSE 464)");
        NP_Course.add("Digital Electronics and Pulse Technique(CSE 411)");
        NP_Course.add("Software Architecture(CSE 461)");
        NP_Course.add("Artificial Intelligence and Expert System Lab(CSE 352)");
        NP_Course.add("Web Database Programming Lab(CSE 458)");
        NP_Course.add("Computer Graphics(CSE 341)");
        NP_Course.add("Software Testing & Quality Assurance(CSE 453)");
        NP_Course.add("Degital System Design Lab(CSE 494)");
        NP_Course.add("Compiler Design Lab(CSE 324)");
        NP_Course.add("Network Administration(CSE 449)");
        NP_Course.add("Interfacing & Peripherals(CSE 491)");
        NP_Course.add("Computer Network(CSE 319)");
        NP_Course.add("Introduction to Cryptography Lab(CSE 446)");
        NP_Course.add("Parallel Processing(CSE 485)");
        NP_Course.add("Operating Systems(CSE 309)");
        NP_Course.add("Delay Tollerant Network(CSE 443)");
        NP_Course.add("Decision Support System Lab(CSE 482)");
        NP_Course.add("Electrical Technology(CSE 107)");
        NP_Course.add("Wireless Networking Lab(CSE 440)");
        NP_Course.add("VLSI Design(CSE 479)");
        NP_Course.add("Digital Signal Processing(CSE 437)");
        NP_Course.add("Data Minig Lab(CSE 476)");
        NP_Course.add("Communication Engineering(CSE 431)");
        NP_Course.add("Simulation and Modeling(CSE 473)");
        NP_Course.add("Distributed Database Management Systems Lab(CSE 418)");
        NP_Course.add("Pattern Recognition(CSE 467)");
        NP_Course.add("Cyber Security and Digital Forensic(CSE 413)");
        NP_Course.add("Software Design Pattern(CSE 463)");
        NP_Course.add("Information System Management(CSE 407)");
        NP_Course.add("Visual Programming Lab(CSE 460)");
        NP_Course.add("Artificial Intelligence and Expert System(CSE 351)");
        NP_Course.add("Web Database Programming(CSE 457)");
        NP_Course.add("English Language-II(ENG 102)");
        NP_Course.add("Software Engineering Lab(CSE 328)");
        NP_Course.add("Software Project Management(CSE 451)");
        NP_Course.add("Digital System Design(CSE 493)");
        NP_Course.add("Compiler Design(CSE 323)");
        NP_Course.add("Mobile Communication Lab(CSE 448)");
        NP_Course.add("Fault Tolerant System(CSE 489)");
        NP_Course.add("Mathematical Analysis for Computer Science(CSE 313)");
        NP_Course.add("Introduction to Cryptography(CSE 445)");
        NP_Course.add("Knowledge Engineering Lab(CSE 484)");

















        List<String> NP_Point= new ArrayList<String>();
        NP_Point.add("Select Point");
        NP_Point.add("4.00(A+)");
        NP_Point.add("3.75(A)");
        NP_Point.add("3.50(A-)");
        NP_Point.add("3.25(B+)");
        NP_Point.add("3.00(B)");
        NP_Point.add("2.75(B-)");
        NP_Point.add("2.50(C+)");
        NP_Point.add("2.25(C)");
        NP_Point.add("2.00(D)");
        NP_Point.add("0.00(F)");



        ArrayAdapter<String> NP_Course_1_1_Adepter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,NP_Course);
        ArrayAdapter<String> NP_point_1_1_Adepter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,NP_Point);

        NP_Course_1_1_Adepter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        NP_point_1_1_Adepter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        NP_Coursespinner_1_1.setAdapter(NP_Course_1_1_Adepter);
        NP_Pointspinner_1_1.setAdapter(NP_point_1_1_Adepter);
        tvTotalSGPA.setText("SGPA:"+ point );

        if(point==0){
            tvTotalSGPA.setText("SGPA:"+ point );
        }

        NP_Coursespinner_1_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                NP_Coursespinner_1_1.setSelection(i);

                if(i==0) Keycourseselect=0;
                else Keycourseselect=1;

                toastCalculteButtonpressmassage();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {



            }
        });

        NP_Pointspinner_1_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                NP_Pointspinner_1_1.setSelection(i);
                //Totalpoint=0;
                //total_credit=0;
                if(i==0) Keypointselect=0; else Keypointselect=1;

                 if(i==1){ point=4;  }
                else if(i==2){ point=3.75; }
                else if(i==3){ point=3.50; }
                else if(i==4){ point=3.25; }
                else if(i==5){ point=3.00; }
                else if(i==6){ point=2.75; }
                else if(i==7){ point=2.50; }
                else if(i==8){ point=2.25; }
                else if(i==9){ point=2.00; }
                else { point=0.00;}
                toastCalculteButtonpressmassage();
               // point=0;





            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                toastmassage();



            }
        });

        calculatecgpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(Keycourseselect==1 && Keypointselect==1){


                   tvTotalSGPA.setText("SGPA:"+ point );

                   }
               else{
               toastmassage();
               }


            }
        });






    }

    private void toastmassage(){
        Toast.makeText(NumPoint_1_Activity.this, "Please Select Course and Point", Toast.LENGTH_SHORT).show();
    }
    private void toastCalculteButtonpressmassage(){

        if(Keycourseselect==1 && Keypointselect==1 )
            Toast.makeText(NumPoint_1_Activity.this, "Press Calculate CGPA Button", Toast.LENGTH_SHORT).show();
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
                startActivity(new Intent(NumPoint_1_Activity.this,SecondActivity.class));
                break;
            }




        }
        return super.onOptionsItemSelected(item);
    }
}
