package com.example.r151873;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        TextView tv = findViewById(R.id.textView4);
        Bundle b = getIntent().getExtras();
        tv.setText("Name : "+b.getString("Name")+
                   "\nPhone no : "+b.getString("Phone")+
                "\nEmail id : "+b.getString("Mail")+
                "\nGender : "+b.getString("Gender")+
                "\nSport : "+b.getString("Sport")+
                "\nCountry : "+b.getString("Country")+
                "\nAccept terms and conditions : "+b.getString("Terms")+
                "\nDate of Birth : "+b.getString("Dob")+
                "\nTime : "+b.getString("Time")
        );
    }
}
