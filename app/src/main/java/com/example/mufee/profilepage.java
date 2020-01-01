package com.example.mufee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class profilepage extends AppCompatActivity {

    TextView pname,dob,dept,year,email,aoi1,aoi2,aoi3,aoi4,samedpt,diffdpt;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage);
        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        pname=findViewById(R.id.pname);
        dob=findViewById(R.id.dob);
        dept=findViewById(R.id.dept);
        year=findViewById(R.id.year);
        email=findViewById(R.id.email);
        aoi1=findViewById(R.id.aoi1);
        aoi2=findViewById(R.id.aoi2);
        aoi3=findViewById(R.id.aoi3);
        aoi4=findViewById(R.id.aoi4);
        samedpt=findViewById(R.id.samedpt);
        diffdpt=findViewById(R.id.diffdpt);

        final DocumentReference docRef = db.collection("Mufee Accounts").document(firebaseAuth.getUid());
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                       pname.setText(document.get("Name").toString());
                        dob.setText(document.get("Dob").toString());
                        dept.setText(document.get("Dept").toString());
                        year.setText(document.get("Year").toString()+" Year");
                        email.setText(document.get("Email").toString());
                        aoi1.setText("  Area of Interest 1 : "+document.get("Aoi1").toString());
                        aoi2.setText("  Area of Interest 2 : "+document.get("Aoi2").toString());
                        aoi3.setText("  Area of Interest 3 : "+document.get("Aoi3").toString());
                        aoi4.setText("  Area of Interest 4 : "+document.get("Aoi4").toString());
                        samedpt.setText("  Choose from Same Dept : "+document.get("Samedpt").toString());
                        diffdpt.setText("  Choose from Different Dept : "+document.get("Diffdpt").toString());

                    } else {
                        Toast.makeText(profilepage.this, "No such doc", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(profilepage.this, "couldn't connect", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }



    public void about(View view) {
        Intent abt=new Intent(this,mufeewidget.class);
        startActivity(abt);
    }



}
