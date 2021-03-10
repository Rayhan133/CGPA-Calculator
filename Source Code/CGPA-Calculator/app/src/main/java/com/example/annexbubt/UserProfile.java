package com.example.annexbubt;

class UserProfile {
    public  String Name;
    public  String ID;
    public  String Intake;
    public  String Section;
    public  String Email;
    public  String Routine;
    public  String FeesAndWaiver;
    public String AcademicInfo;


    public UserProfile(String name, String ID, String intake, String section, String email, String routine, String feesAndWaiver, String academicInfo) {
        Name = name;
        this.ID = ID;
        Intake = intake;
        Section = section;
        Email = email;
        Routine = routine;
        FeesAndWaiver = feesAndWaiver;
        AcademicInfo = academicInfo;
    }
}
