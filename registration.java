package com.example.r151873;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.DateFormat;
import java.util.Calendar;

public class registration extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    String sport,dob,name,phno,mail,gender,country,accept,time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        EditText et = findViewById(R.id.editText4);
        registerForContextMenu(et);

        Spinner s = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.sports,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(this);



        final ToggleButton tb = findViewById(R.id.toggleButton);
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tb.isChecked())
                    accept="yes";
                else
                    accept="No";
            }
        });
        final RadioButton rb = findViewById(R.id.radioButton2);
        final RadioButton rb1 = findViewById(R.id.radioButton3);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rb.isChecked())
                    gender="male";
            }
        });

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rb1.isChecked())
                    gender="female";
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            sport = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this,"Please Select a sport",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.country,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        EditText et = findViewById(R.id.editText4);
        switch (item.getItemId()){
            case R.id.c1:
                country="India";
                et.setText(country);break;
            case R.id.c2 :
                country="America";
                et.setText(country);break;
            case R.id.c3 :
                country="Australia";
                et.setText(country);break;
        }
        return true;
    }

    public void pickdate(View view) {
        DialogFragment df = new datepicker();
        df.show(getSupportFragmentManager(),"datepicker");
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        dob = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        TextView tv = findViewById(R.id.textView2);
        tv.setText(dob);
    }

    public void picktime(View view) {
        DialogFragment tf = new timepicker();
        tf.show(getSupportFragmentManager(),"timepicker");
    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        time = hourOfDay+":"+minute;
        TextView tv = findViewById(R.id.textView3);
        tv.setText(time);
    }

    public void submit(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("register");
        alert.setMessage("Confirm to register");
        alert.setPositiveButton("submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent gotolast = new Intent(getApplicationContext(),DataActivity.class);
                EditText n = findViewById(R.id.editText);
                EditText ph = findViewById(R.id.editText2);
                EditText ml = findViewById(R.id.editText3);
                name=n.getText().toString();
                phno = ph.getText().toString();
                mail = ml.getText().toString();
                Bundle b = new Bundle();
                b.putString("Name",name);
                b.putString("Phone",phno);
                b.putString("Mail",mail);
                b.putString("Gender",gender);
                b.putString("Sport",sport);
                b.putString("Country",country);
                b.putString("Terms",accept);
                b.putString("Dob",dob);
                b.putString("Time",time);
                gotolast.putExtras(b);
                startActivity(gotolast);
            }
        });
        alert.setNegativeButton("I am not done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.setCancelable(false);
        alert.show();
    }
}
