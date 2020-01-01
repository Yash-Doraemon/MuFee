package com.example.mufee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Signup4 extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    boolean s1tf=false;
    boolean s2tf=false;
    private FirebaseAuth firebaseAuth  = FirebaseAuth.getInstance();;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup4);
        Switch s1 = (Switch) findViewById(R.id.switch1);
        Switch s2 = (Switch) findViewById(R.id.switch2);


        s1.setOnCheckedChangeListener(this);
        s2.setOnCheckedChangeListener(this);
    }


    @Override
       public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        boolean a= isChecked;
//        //whatever you want
//        Toast.makeText(this, "State"+a, Toast.LENGTH_SHORT).show();
        switch (buttonView.getId())
        {
            case R.id.switch1:
                s1tf=isChecked;
                Toast.makeText(this, "Choose from same dept "+s1tf, Toast.LENGTH_SHORT).show();
                break;

            case R.id.switch2:
                s2tf=isChecked;
                Toast.makeText(this, "Choose from different dept "+s2tf, Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void feed(View view) {
        Intent feed=new Intent(this,feed.class);
        Intent su1=getIntent();
        String user_name = su1.getStringExtra("NAME");
        String email = su1.getStringExtra("EMAIL");
        String dob = su1.getStringExtra("DOB");
        String dept = su1.getStringExtra("DEPT");
        String year = su1.getStringExtra("YEAR");
        String aoi1 = su1.getStringExtra("AOI1");
        String aoi2 = su1.getStringExtra("AOI2");
        String aoi3 = su1.getStringExtra("AOI3");
        String aoi4 = su1.getStringExtra("AOI4");
        Toast.makeText(this, aoi1, Toast.LENGTH_SHORT).show();
        Map<String, Object> user = new HashMap<>();
            user.put("Name",user_name);
            user.put("Email",email);
            user.put("Dob",dob);
            user.put("Dept",dept);
            user.put("Year",year);
            user.put("Aoi1",aoi1);
            user.put("Aoi2",aoi2);
            user.put("Aoi3",aoi3);
            user.put("Aoi4",aoi4);
            user.put("Samedpt",s1tf);
            user.put("Diffdpt",s2tf);
        db.collection("/Mufee Accounts").document(firebaseAuth.getUid())
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Signup4.this,"Data successfully written!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(Signup4.this, "Error in writing data", Toast.LENGTH_SHORT).show();
                    }
                });


        finish();
        startActivity(feed);
    }

    public void about(View view) {
        Intent abt=new Intent(this,mufeewidget.class);
        startActivity(abt);
    }


}
