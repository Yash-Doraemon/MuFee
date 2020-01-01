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
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class found extends AppCompatActivity {
    // Create a reference to the cities collection
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db;
 //   CollectionReference citiesRef = db.collection("Mufee Accounts");
    String Name,Dob,dept,year,email,aoi1,aoi2,aoi3,aoi4,smdept,dfdept;
    TextView tname,tdob,tdept,tyear,temail,matchno,taoi1,taoi2,taoi3,taoi4,te;
    // Create a query against the collection.
    Query query;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found);

        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        tname=findViewById(R.id.tname);
        tdob=findViewById(R.id.tdob);
        tdept=findViewById(R.id.tdept);
        tyear=findViewById(R.id.tyear);
        temail=findViewById(R.id.temail);
        taoi1=findViewById(R.id.taoi1);
        taoi2=findViewById(R.id.taoi2);
        taoi3=findViewById(R.id.taoi3);
        taoi4=findViewById(R.id.taoi4);
        matchno=findViewById(R.id.matchno);
        te=findViewById(R.id.te);


        final DocumentReference docRef = db.collection("Mufee Accounts").document(firebaseAuth.getUid());
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                Name = documentSnapshot.get("Name").toString();
                Dob = documentSnapshot.get("Dob").toString();
                dept = documentSnapshot.get("Dept").toString();
                year = documentSnapshot.get("Year").toString();
                email = documentSnapshot.get("Email").toString();
                aoi1 = documentSnapshot.get("Aoi1").toString();
                aoi2 = documentSnapshot.get("Aoi2").toString();
                aoi3 = documentSnapshot.get("Aoi3").toString();
                aoi4 = documentSnapshot.get("Aoi4").toString();
                smdept = documentSnapshot.get("Samedpt").toString();
                dfdept = documentSnapshot.get("Diffdpt").toString();
                findfrnd();

            }

        });

    }

    private void findfrnd() {


        if (smdept.equals("true") && dfdept.equals("false")) {
            db.collection("Mufee Accounts")
                    .whereEqualTo("Dept", dept)
                    .whereEqualTo("Aoi1", aoi1)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if(!document.getId().equals(firebaseAuth.getUid())) {
                                        te.setText("Found A Person");
                                        tname.setText(document.get("Name").toString().toUpperCase());
                                        tname.setText(document.get("Name").toString());
                                        tdob.setText(document.get("Dob").toString());
                                        tdept.setText(document.get("Dept").toString());
                                        tyear.setText(document.get("Year").toString() + " Year");
                                        temail.setText(document.get("Email").toString());
                                        taoi1.setText("  Area of Interest 1 : " + document.get("Aoi1").toString());
                                        taoi2.setText("  Area of Interest 2 : " + document.get("Aoi2").toString());
                                        taoi3.setText("  Area of Interest 3 : " + document.get("Aoi3").toString());
                                        taoi4.setText("  Area of Interest 4 : " + document.get("Aoi4").toString());
                                        matchno.setText("It's a First Interest Match");
                                        return;
                                    }
                                }
                            }
                        }
                    });


                
                findtwosmdept();


        } else if (smdept.equals("false") && dfdept.equals("true")) {

            db.collection("Mufee Accounts")

                    .whereEqualTo("Aoi1", aoi1)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if (!dept.equals(document.get("Dept").toString()))
                                    {   te.setText("Found A Person");
                                        tname.setText(document.get("Name").toString().toUpperCase());
                                        tname.setText(document.get("Name").toString());
                                        tdob.setText(document.get("Dob").toString());
                                        tdept.setText(document.get("Dept").toString());
                                        tyear.setText(document.get("Year").toString() + " Year");
                                        temail.setText(document.get("Email").toString());
                                        taoi1.setText("  Area of Interest 1 : " + document.get("Aoi1").toString());
                                        taoi2.setText("  Area of Interest 2 : " + document.get("Aoi2").toString());
                                        taoi3.setText("  Area of Interest 3 : " + document.get("Aoi3").toString());
                                        taoi4.setText("  Area of Interest 4 : " + document.get("Aoi4").toString());
                                        matchno.setText("It's a First Interest Match");
                                        return;
                                    }
                                }
                            }



                        }
                    });

            
            findtwosmdept();
        } else if (smdept.equals("true") && dfdept.equals("true")) {

            db.collection("Mufee Accounts")

                    .whereEqualTo("Aoi1", aoi1)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if(!document.getId().equals(firebaseAuth.getUid())) {
                                        te.setText("Found A Person");
                                        tname.setText(document.get("Name").toString().toUpperCase());
                                        tname.setText(document.get("Name").toString());
                                        tdob.setText(document.get("Dob").toString());
                                        tdept.setText(document.get("Dept").toString());
                                        tyear.setText(document.get("Year").toString() + " Year");
                                        temail.setText(document.get("Email").toString());
                                        taoi1.setText("  Area of Interest 1 : " + document.get("Aoi1").toString());
                                        taoi2.setText("  Area of Interest 2 : " + document.get("Aoi2").toString());
                                        taoi3.setText("  Area of Interest 3 : " + document.get("Aoi3").toString());
                                        taoi4.setText("  Area of Interest 4 : " + document.get("Aoi4").toString());
                                        matchno.setText("It's a First Interest Match");
                                        return;

                                    }
                                }
                            }
                        }
                    });

                
                findtwosmdept();

        }

    }

    private void findtwosmdept(){


        if (smdept.equals("true") && dfdept.equals("false")) {
            db.collection("Mufee Accounts")
                    .whereEqualTo("Dept", dept)
                    .whereEqualTo("Aoi2", aoi1)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if(!document.getId().equals(firebaseAuth.getUid())) {
                                        te.setText("Found A Person");
                                        tname.setText(document.get("Name").toString().toUpperCase());
                                        tname.setText(document.get("Name").toString());
                                        tdob.setText(document.get("Dob").toString());
                                        tdept.setText(document.get("Dept").toString());
                                        tyear.setText(document.get("Year").toString() + " Year");
                                        temail.setText(document.get("Email").toString());
                                        taoi1.setText("  Area of Interest 1 : " + document.get("Aoi1").toString());
                                        taoi2.setText("  Area of Interest 2 : " + document.get("Aoi2").toString());
                                        taoi3.setText("  Area of Interest 3 : " + document.get("Aoi3").toString());
                                        taoi4.setText("  Area of Interest 4 : " + document.get("Aoi4").toString());
                                        matchno.setText("It's a Second Interest Match");
                                        te.setText("Found A Person");
                                        return;
                                    }
                                }
                            }
                        }
                    });
           
            findthreesmdept();
        } else if (smdept.equals("false") && dfdept.equals("true")) {

            db.collection("Mufee Accounts")

                    .whereEqualTo("Aoi2", aoi1)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if (!dept.equals(document.get("Dept").toString()))
                                    {
                                        te.setText("Found A Person");
                                        tname.setText(document.get("Name").toString().toUpperCase());
                                        tname.setText(document.get("Name").toString());
                                        tdob.setText(document.get("Dob").toString());
                                        tdept.setText(document.get("Dept").toString());
                                        tyear.setText(document.get("Year").toString() + " Year");
                                        temail.setText(document.get("Email").toString());
                                        taoi1.setText("  Area of Interest 1 : " + document.get("Aoi1").toString());
                                        taoi2.setText("  Area of Interest 2 : " + document.get("Aoi2").toString());
                                        taoi3.setText("  Area of Interest 3 : " + document.get("Aoi3").toString());
                                        taoi4.setText("  Area of Interest 4 : " + document.get("Aoi4").toString());
                                        matchno.setText("It's a Second Interest Match");
                                        return;
                                    }
                                }
                            }
                        }
                    });

           
            findthreesmdept();
        } else if (smdept.equals("true") && dfdept.equals("true")) {

            db.collection("Mufee Accounts")

                    .whereEqualTo("Aoi2", aoi1)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if(!document.getId().equals(firebaseAuth.getUid())) {
                                        te.setText("Found A Person");
                                        tname.setText(document.get("Name").toString().toUpperCase());
                                        tname.setText(document.get("Name").toString());
                                        tdob.setText(document.get("Dob").toString());
                                        tdept.setText(document.get("Dept").toString());
                                        tyear.setText(document.get("Year").toString() + " Year");
                                        temail.setText(document.get("Email").toString());
                                        taoi1.setText("  Area of Interest 1 : " + document.get("Aoi1").toString());
                                        taoi2.setText("  Area of Interest 2 : " + document.get("Aoi2").toString());
                                        taoi3.setText("  Area of Interest 3 : " + document.get("Aoi3").toString());
                                        taoi4.setText("  Area of Interest 4 : " + document.get("Aoi4").toString());
                                        matchno.setText("It's a Second Interest Match");
                                        return;
                                    }
                                }
                            }
                        }
                    });

           
            findthreesmdept();
        }

    }

    private void findthreesmdept() {
        if (smdept.equals("true") && dfdept.equals("false")) {
            db.collection("Mufee Accounts")
                    .whereEqualTo("Dept", dept)
                    .whereEqualTo("Aoi3", aoi1)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if(!document.getId().equals(firebaseAuth.getUid())) {
                                        te.setText("Found A Person");
                                        tname.setText(document.get("Name").toString().toUpperCase());
                                        tname.setText(document.get("Name").toString());
                                        tdob.setText(document.get("Dob").toString());
                                        tdept.setText(document.get("Dept").toString());
                                        tyear.setText(document.get("Year").toString() + " Year");
                                        temail.setText(document.get("Email").toString());
                                        taoi1.setText("  Area of Interest 1 : " + document.get("Aoi1").toString());
                                        taoi2.setText("  Area of Interest 2 : " + document.get("Aoi2").toString());
                                        taoi3.setText("  Area of Interest 3 : " + document.get("Aoi3").toString());
                                        taoi4.setText("  Area of Interest 4 : " + document.get("Aoi4").toString());
                                        matchno.setText("It's a Third Interest Match");
                                        return;
                                    }
                                }
                            }
                        }
                    });
            tname.setText(null);
            tdob.setText(null);
            tdept.setText(null);
            tyear.setText(null);
            temail.setText(null);
            taoi1.setText(null);
            taoi2.setText(null);
            taoi3.setText(null);
            taoi4.setText(null);
            
           

        } else if (smdept.equals("false") && dfdept.equals("true")) {

            db.collection("Mufee Accounts")

                    .whereEqualTo("Aoi3", aoi1)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if (!dept.equals(document.get("Dept").toString()))
                                    {   te.setText("Found A Person");
                                        tname.setText(document.get("Name").toString().toUpperCase());
                                        tname.setText(document.get("Name").toString());
                                        tdob.setText(document.get("Dob").toString());
                                        tdept.setText(document.get("Dept").toString());
                                        tyear.setText(document.get("Year").toString() + " Year");
                                        temail.setText(document.get("Email").toString());
                                        taoi1.setText("  Area of Interest 1 : " + document.get("Aoi1").toString());
                                        taoi2.setText("  Area of Interest 2 : " + document.get("Aoi2").toString());
                                        taoi3.setText("  Area of Interest 3 : " + document.get("Aoi3").toString());
                                        taoi4.setText("  Area of Interest 4 : " + document.get("Aoi4").toString());
                                        matchno.setText("It's a Third Interest Match");
                                        return;
                                    }
                                }
                            }


                        }
                    });
            tname.setText(null);
            tdob.setText(null);
            tdept.setText(null);
            tyear.setText(null);
            temail.setText(null);
            taoi1.setText(null);
            taoi2.setText(null);
            taoi3.setText(null);
            taoi4.setText(null);
           
           


        } else if (smdept.equals("true") && dfdept.equals("true")) {

            db.collection("Mufee Accounts")

                    .whereEqualTo("Aoi3", aoi1)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if(!document.getId().equals(firebaseAuth.getUid())) {
                                        te.setText("Found A Person");
                                        tname.setText(document.get("Name").toString().toUpperCase());

                                        tdob.setText(document.get("Dob").toString());
                                        tdept.setText(document.get("Dept").toString());
                                        tyear.setText(document.get("Year").toString() + " Year");
                                        temail.setText(document.get("Email").toString());
                                        taoi1.setText("  Area of Interest 1 : " + document.get("Aoi1").toString());
                                        taoi2.setText("  Area of Interest 2 : " + document.get("Aoi2").toString());
                                        taoi3.setText("  Area of Interest 3 : " + document.get("Aoi3").toString());
                                        taoi4.setText("  Area of Interest 4 : " + document.get("Aoi4").toString());
                                        matchno.setText("It's a Third Interest Match");
                                        return;
                                    }
                                }
                            }
                        }
                    });
            tname.setText(null);
            tdob.setText(null);
            tdept.setText(null);
            tyear.setText(null);
            temail.setText(null);
            taoi1.setText(null);
            taoi2.setText(null);
            taoi3.setText(null);
            taoi4.setText(null);
            
         


        }

    }

    public void about(View view) {
        Intent abt=new Intent(this,mufeewidget.class);
        startActivity(abt);
    }


}
