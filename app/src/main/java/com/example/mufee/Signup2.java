package com.example.mufee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class Signup2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener {

   TextView tb;
    ImageButton B;
    String dept,year,str;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_signup2);
        B=findViewById(R.id.imageButton);

        tb=findViewById(R.id.dob);

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment df=new DatePICKER();
                df.show(getSupportFragmentManager(),"date picker");
            }
        });

        Spinner spinner1= findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.branch, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);
        String dept=spinner1.getSelectedItem().toString();
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinnertext,R.array.branch);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinnertext,R.array.branch);
        Spinner spinner2= findViewById(R.id.spinner5);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);
        String year=spinner2.getSelectedItem().toString();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text= parent.getItemAtPosition(position).toString();
       // Toast.makeText(parent.getContext(), text, Toast.LENGTH_LONG).show();
        switch (parent.getId())
        {
            case R.id.spinner4:
                     dept=text;
                     //Toast.makeText(parent.getContext(), dept, Toast.LENGTH_LONG).show();
                     break;
            case R.id.spinner5:
                    year=text;
                    // Toast.makeText(parent.getContext(), year, Toast.LENGTH_LONG).show();
                    break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void signup3(View view) {
        Intent su1=getIntent();
            String user_name = su1.getStringExtra("NAME");
            String email = su1.getStringExtra("EMAIL");
            Intent su3=new Intent(this,Signup3.class);
            su3.putExtra("NAME",user_name);
            su3.putExtra("EMAIL",email);
            if(TextUtils.isEmpty(str))
            {
                Toast.makeText(this, "Select a Dob", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(dept))
            {
                Toast.makeText(this, "Select a Dept", Toast.LENGTH_SHORT).show();
                return;
            }
        if(TextUtils.isEmpty(year))
        {
            Toast.makeText(this, "Select a Year you study in", Toast.LENGTH_SHORT).show();
            return;
        }
            su3.putExtra("DOB",str);
            su3.putExtra("DEPT",dept);
            su3.putExtra("YEAR",year);
            finish();
            startActivity(su3);
    }

    public void about(View view) { Intent abt=new Intent(this,mufeewidget.class);
        startActivity(abt);
    }



    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c=Calendar.getInstance();
       c.set(Calendar.YEAR,year);
       c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
       c.set(Calendar.MONTH,month);
        str= DateFormat.getDateInstance().format(c.getTime());
        tb.setText(str);
    }
}








