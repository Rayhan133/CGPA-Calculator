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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class NumPoint_3_Activity extends AppCompatActivity {

    private Spinner NP_Coursespinner_3_1,NP_Pointspinner_3_1,NP_Coursespinner_3_2,NP_Pointspinner_3_2,NP_Coursespinner_3_3,NP_Pointspinner_3_3;
    private TextView tvTotalSGPA;
    private int Keycourseselect1=0,Keycourseselect2=0,Keycourseselect3=0;
    private int Keypointselect1=0,Keypointselect2=0,Keypointselect3=0;


    private Button calculatecgpa,reset_3;
    private double  credit1=0,credit2=0,credit3=0;
    private double point1=0,point2=0,point3=0;
    private double sum=0;
    private double total_credit=0;
    private double multicreditpoint1=0;
    private double multicreditpoint2=0;
    private double multicreditpoint3=0;
    private double Finaltotalpoint=0;
    private Button cancelcalculatecgpa_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_point_3_);

        getSupportActionBar().setTitle("CGPA Calculation");




        final DecimalFormat number = new DecimalFormat("0.00");


        NP_Coursespinner_3_1 = (Spinner)findViewById(R.id.spnr_course_NP_3_1);
        NP_Pointspinner_3_1= (Spinner)findViewById(R.id.spnr_point_NP_3_1);
        NP_Coursespinner_3_2 = (Spinner)findViewById(R.id.spnr_course_NP_3_2);
        NP_Pointspinner_3_2= (Spinner)findViewById(R.id.spnr_point_NP_3_2);
        NP_Coursespinner_3_3 = (Spinner)findViewById(R.id.spnr_course_NP_3_3);
        NP_Pointspinner_3_3= (Spinner)findViewById(R.id.spnr_point_NP_3_3);
        tvTotalSGPA = (TextView)findViewById(R.id.tv_Total_NP_3);
        calculatecgpa =(Button)findViewById(R.id.btncalculateCGPA_3);
        cancelcalculatecgpa_3 = (Button)findViewById(R.id.btncalculateCGPAcancel_3);

        reset_3 = (Button)findViewById(R.id.btnreset_3) ;


        reset_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Toast.makeText(NumPoint_3_Activity.this, "Reset", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(NumPoint_3_Activity.this,NumPoint_3_Activity.class));
            }
        });


        //cancel part from activite................
        cancelcalculatecgpa_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(NumPoint_3_Activity.this,CGPACalculatorActivity.class));
            }
        });




        //..............................Course and Point Parts............................................
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

//...................................End of Course and Point part.................................



        ArrayAdapter<String> NP_Course_3_1_Adepter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,NP_Course);
        ArrayAdapter<String> NP_point_3_1_Adepter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,NP_Point);

        ArrayAdapter<String> NP_Course_3_2_Adepter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,NP_Course);
        ArrayAdapter<String> NP_point_3_2_Adepter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,NP_Point);

        ArrayAdapter<String> NP_Course_3_3_Adepter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,NP_Course);
        ArrayAdapter<String> NP_point_3_3_Adepter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,NP_Point);

        NP_Course_3_1_Adepter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        NP_point_3_1_Adepter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        NP_Course_3_2_Adepter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        NP_point_3_2_Adepter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        NP_Course_3_3_Adepter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        NP_point_3_3_Adepter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

       NP_Coursespinner_3_1.setAdapter(NP_Course_3_1_Adepter);
        NP_Pointspinner_3_1.setAdapter(NP_point_3_1_Adepter);

        NP_Coursespinner_3_2.setAdapter(NP_Course_3_2_Adepter);
        NP_Pointspinner_3_2.setAdapter(NP_point_3_2_Adepter);
        NP_Coursespinner_3_3.setAdapter(NP_Course_3_3_Adepter);
        NP_Pointspinner_3_3.setAdapter(NP_point_3_3_Adepter);


        if(Finaltotalpoint==0){
            tvTotalSGPA.setText("SGPA:"+ Finaltotalpoint );
        }


        //...............................................................................

        NP_Coursespinner_3_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                NP_Coursespinner_3_1.setSelection(i);

                if(i==0) Keycourseselect1=0;
                else Keycourseselect1=1;

                credit1=0;
                total_credit=0;
                if(i==122 || i==121 || i==120 || i==118 || i==117 || i==116 || i==114 || i==113 || i==112 || i==109 || i==108 || i==107 || i==105 || i==104 || i==102 || i==101 || i==99 || i==97 || i==96 || i==95 || i==93 || i==92 || i==91 || i==88 || i==87 || i==84 || i==83 || i==80 || i==79 || i==77 || i==76 || i==74 || i==72 || i==70 || i==67 || i==66 || i==62 || i==60 || i==58 || i==54 || i==53 || i==52 || i==50 || i==49 || i==47 || i==45 || i==42 || i==41 || i==40 || i==39 || i==36 || i==32 || i==31 || i==29 || i==28 || i==1 || i==2 || i==4 || i==5 || i==6 || i==7 || i==8 || i==9 || i==10 || i==11 || i==13 || i==17 || i==19 || i==20 || i==19 || i==25|| i==26 ){
                    credit1=3;
                   // total_credit+=credit;
                }
                else if(i==123 || i==119 || i==111 || i==106 || i==103 || i==100 || i==98 || i==94 || i==89 || i==86 || i==85 || i==82 || i==81 || i==78 || i==75 || i==73 || i==71 || i==69 || i==68 || i==65 || i==64 || i==63 || i==56 || i==55 || i==51 || i==48 || i==46 || i==44 || i==35 || i==34 || i==30 || i==3 || i==12 || i==14 || i==15 || i==18 || i==21 || i==23 || i==24 || i==27){
                    credit1=1.5;
                   // total_credit+=credit;
                }
                else if(i==115 || i==90 || i==59 || i==57 || i==43 || i==33 || i==16 || i==22){
                    credit1=0.75;
                    //total_credit+=credit;
                }
                else if(i==110 || i==38 || i==37){
                    credit1=2;
                    //total_credit+=credit;
                }
                //else if(i==61)
                else {
                    credit1=4;
                    //total_credit+=credit;
                }
                toastCalculteButtonpressmassage();

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(NumPoint_3_Activity.this, "Please Select 1st Course", Toast.LENGTH_SHORT).show();
            }
        });
        NP_Pointspinner_3_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                NP_Pointspinner_3_1.setSelection(i);
                if(i==0) Keypointselect1=0; else Keypointselect1=1;

                sum=0;
                Finaltotalpoint=0;
                multicreditpoint2=0;
                multicreditpoint1=0;
                //Totalpoint=0;
                //total_credit=0;
                if(i==1){ point1=4; }
                else if(i==2){ point1=3.75; }
                else if(i==3){ point1=3.50; }
                else if(i==4){ point1=3.25; }
                else if(i==5){ point1=3.00; }
                else if(i==6){ point1=2.75; }
                else if(i==7){ point1=2.50; }
                else if(i==8){ point1=2.25; }
                else if(i==9){ point1=2.00; }
                else { point1=0.00; }
                toastCalculteButtonpressmassage();
// point1=0;
//credit=0;



            }




            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(NumPoint_3_Activity.this, "Please Select 1st Point", Toast.LENGTH_SHORT).show();

            }
        });
        //...........................................................................................................

        NP_Coursespinner_3_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                NP_Coursespinner_3_2.setSelection(i);
                if(i==0) Keycourseselect2=0;
                else Keycourseselect2=1;

                credit2=0;
                if(i==122 || i==121 || i==120 || i==118 || i==117 || i==116 || i==114 || i==113 || i==112 || i==109 || i==108 || i==107 || i==105 || i==104 || i==102 || i==101 || i==99 || i==97 || i==96 || i==95 || i==93 || i==92 || i==91 || i==88 || i==87 || i==84 || i==83 || i==80 || i==79 || i==77 || i==76 || i==74 || i==72 || i==70 || i==67 || i==66 || i==62 || i==60 || i==58 || i==54 || i==53 || i==52 || i==50 || i==49 || i==47 || i==45 || i==42 || i==41 || i==40 || i==39 || i==36 || i==32 || i==31 || i==29 || i==28 || i==1 || i==2 || i==4 || i==5 || i==6 || i==7 || i==8 || i==9 || i==10 || i==11 || i==13 || i==17 || i==19 || i==20 || i==19 || i==25|| i==26 ){
                    credit2=3;
                }
                else if(i==123 || i==119 || i==111 || i==106 || i==103 || i==100 || i==98 || i==94 || i==89 || i==86 || i==85 || i==82 || i==81 || i==78 || i==75 || i==73 || i==71 || i==69 || i==68 || i==65 || i==64 || i==63 || i==56 || i==55 || i==51 || i==48 || i==46 || i==44 || i==35 || i==34 || i==30 || i==3 || i==12 || i==14 || i==15 || i==18 || i==21 || i==23 || i==24 || i==27){
                    credit2=1.5;
                    //total_credit+=credit;
                }
                else if(i==115 || i==90 || i==59 || i==57 || i==43 || i==33 || i==16 || i==22){
                    credit2=0.75;
                    //total_credit+=credit;
                }
                else if(i==110 || i==38 || i==37){
                    credit2=2;
                    //total_credit+=credit;
                }
                //else if(i==61)
                else {
                    credit2=4;
                   // total_credit+=credit;
                }
                toastCalculteButtonpressmassage();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(NumPoint_3_Activity.this, "Please Select 2nd Course", Toast.LENGTH_SHORT).show();
            }
        });
        NP_Pointspinner_3_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                NP_Pointspinner_3_2.setSelection(i);
                if(i==0) Keypointselect2=0; else Keypointselect2=1;
                if(i==1){ point2=4; }
                else if(i==2){ point2=3.75; }
                else if(i==3){ point2=3.50; }
                else if(i==4){ point2=3.25; }
                else if(i==5){ point2=3.00; }
                else if(i==6){ point2=2.75; }
                else if(i==7){ point2=2.50; }
                else if(i==8){ point2=2.25; }
                else if(i==9){ point2=2.00; }
                else { point2=0.00; }
                toastCalculteButtonpressmassage();
// point2=0;
//credit=0;


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //........................................................................................................

        NP_Coursespinner_3_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                NP_Coursespinner_3_3.setSelection(i);
                if(i==0) Keycourseselect3=0;
                else Keycourseselect3=1;

                credit3=0;
                if(i==122 || i==121 || i==120 || i==118 || i==117 || i==116 || i==114 || i==113 || i==112 || i==109 || i==108 || i==107 || i==105 || i==104 || i==102 || i==101 || i==99 || i==97 || i==96 || i==95 || i==93 || i==92 || i==91 || i==88 || i==87 || i==84 || i==83 || i==80 || i==79 || i==77 || i==76 || i==74 || i==72 || i==70 || i==67 || i==66 || i==62 || i==60 || i==58 || i==54 || i==53 || i==52 || i==50 || i==49 || i==47 || i==45 || i==42 || i==41 || i==40 || i==39 || i==36 || i==32 || i==31 || i==29 || i==28 || i==1 || i==2 || i==4 || i==5 || i==6 || i==7 || i==8 || i==9 || i==10 || i==11 || i==13 || i==17 || i==19 || i==20 || i==19 || i==25|| i==26 ){
                    credit3=3;
                    //total_credit+=credit;
                }
                else if(i==123 || i==119 || i==111 || i==106 || i==103 || i==100 || i==98 || i==94 || i==89 || i==86 || i==85 || i==82 || i==81 || i==78 || i==75 || i==73 || i==71 || i==69 || i==68 || i==65 || i==64 || i==63 || i==56 || i==55 || i==51 || i==48 || i==46 || i==44 || i==35 || i==34 || i==30 || i==3 || i==12 || i==14 || i==15 || i==18 || i==21 || i==23 || i==24 || i==27){
                    credit3=1.5;
                    //total_credit+=credit;
                }
                else if(i==115 || i==90 || i==59 || i==57 || i==43 || i==33 || i==16 || i==22){
                    credit3=0.75;
                    //total_credit+=credit;
                }
                else if(i==110 || i==38 || i==37){
                    credit3=2;
                    //total_credit+=credit;
                }
                //else if(i==61)
                else {
                    credit3=4;
                    //total_credit+=credit;
                }
                toastCalculteButtonpressmassage();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(NumPoint_3_Activity.this, "Please Select 3rd Course", Toast.LENGTH_SHORT).show();
            }
        });
        NP_Pointspinner_3_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                NP_Pointspinner_3_3.setSelection(i);
                if(i==0) Keypointselect3=0; else Keypointselect3=1;

                if(i==1){ point3=4; }
                else if(i==2){ point3=3.75; }
                else if(i==3){ point3=3.50; }
                else if(i==4){ point3=3.25; }
                else if(i==5){ point3=3.00; }
                else if(i==6){ point3=2.75; }
                else if(i==7){ point3=2.50; }
                else if(i==8){ point3=2.25; }
                else if(i==9){ point3=2.00; }
                else { point3=0.00; }
                toastCalculteButtonpressmassage();
// point3=0;
//credit=0;


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        calculatecgpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                multicreditpoint1= credit1*point1;
                multicreditpoint2= credit2*point2;
                multicreditpoint3= credit3*point3;

                total_credit= credit1+credit2+credit3;


                Finaltotalpoint=multicreditpoint1+multicreditpoint2+multicreditpoint3;
                sum = Finaltotalpoint/total_credit;
                if(Keycourseselect1==1 && Keypointselect1==1 && Keycourseselect2==1 && Keypointselect2==1 && Keycourseselect3==1 ){

                    tvTotalSGPA.setText("SGPA:"+ number.format(sum));


                }
                else{
                    toastmassage();
                }


            }
        });




    }

    private void toastmassage(){
        Toast.makeText(NumPoint_3_Activity.this, "Please Select All Courses and Points", Toast.LENGTH_SHORT).show();
    }
    private void toastCalculteButtonpressmassage(){

        if(Keycourseselect1==1 && Keypointselect1==1 && Keycourseselect2==1 && Keypointselect2==1 && Keycourseselect3==1 && Keypointselect3==1 )
            Toast.makeText(NumPoint_3_Activity.this, "Press Calculate CGPA Button", Toast.LENGTH_SHORT).show();
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
                startActivity(new Intent(NumPoint_3_Activity.this,SecondActivity.class));
                break;
            }




        }
        return super.onOptionsItemSelected(item);
    }


}
