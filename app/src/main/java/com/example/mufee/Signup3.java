package com.example.mufee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Signup3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String aoistr1,aoistr2,aoistr3,aoistr4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup3);

        Spinner aoi1= findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.aoi, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aoi1.setAdapter(adapter);
        aoi1.setOnItemSelectedListener(this);
       // aoistr1=aoi1.getSelectedItem().toString();

        Spinner aoi2= findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.aoi, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aoi2.setAdapter(adapter2);
        aoi2.setOnItemSelectedListener(this);
        //aoistr2=aoi2.getSelectedItem().toString();

        Spinner aoi3= findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(this,R.array.aoi, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aoi3.setAdapter(adapter3);
        aoi3.setOnItemSelectedListener(this);
       // aoistr3=aoi3.getSelectedItem().toString();

        Spinner aoi4= findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapter4=ArrayAdapter.createFromResource(this,R.array.aoi, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aoi4.setAdapter(adapter4);
        aoi4.setOnItemSelectedListener(this);
        //aoistr4=aoi4.getSelectedItem().toString();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
        switch (parent.getId())
        {
            case R.id.spinner1:
                aoistr1=parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinner2:
                aoistr2=parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinner3:
                aoistr3=parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinner4:
                aoistr4=parent.getItemAtPosition(position).toString();
                break;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void signup4(View view) {
        Intent su4=new Intent(this,Signup4.class);
        Intent su1=getIntent();
        String user_name = su1.getStringExtra("NAME");
        String email = su1.getStringExtra("EMAIL");
        String dob = su1.getStringExtra("DOB");
        String dept = su1.getStringExtra("DEPT");
        String year = su1.getStringExtra("YEAR");
        if(TextUtils.isEmpty(aoistr1))
        {
            Toast.makeText(this, "Select Area of Interest 1", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(aoistr2))
        {
            Toast.makeText(this, "Select Area of Interest 2", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(aoistr3))
        {
            Toast.makeText(this, "Select Area of Interest 3", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(aoistr4))
        {
            Toast.makeText(this, "Select Area of Interest 4", Toast.LENGTH_SHORT).show();
            return;
        }



        su4.putExtra("NAME",user_name);
        su4.putExtra("EMAIL",email);
        su4.putExtra("DOB",dob);
        su4.putExtra("DEPT",dept);
        su4.putExtra("YEAR",year);
        su4.putExtra("AOI1",aoistr1);
        su4.putExtra("AOI2",aoistr2);
        su4.putExtra("AOI3",aoistr3);
        su4.putExtra("AOI4",aoistr4);
        finish();
        startActivity(su4);
    }

    public void about(View view) { Intent abt=new Intent(this,mufeewidget.class);
        startActivity(abt);
    }
}
