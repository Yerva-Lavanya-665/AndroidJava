package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import static com.example.recyclerview.R.id.recycler;

public class MainActivity extends AppCompatActivity {

    String data[];
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = getResources().getStringArray(R.array.mail);
        recycler = findViewById(R.id.recycler);
        myadapter adapter = new myadapter(this,data);
    }
}
