package com.example.mufee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class feed extends AppCompatActivity implements View.OnClickListener  {


    private FirebaseAuth firebaseAuth;

    //view objects
    private TextView textViewUserEmail;
    private TextView buttonLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity

            Toast.makeText(this, "Sign IN to continue", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, Login.class));
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views

        buttonLogout = (TextView) findViewById(R.id.SignOut);
        buttonLogout.setOnClickListener(this);
    }

    public void about(View view) {
        Intent in = new Intent(this, mufeewidget.class);
        startActivity(in);
    }

    public void current(View view) {
        Intent ct=new Intent(this,currenttrend.class);
        startActivity(ct);
    }


    @Override
    public void onClick(View v) {
        //if logout is pressed
        if(v == buttonLogout){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, Login.class));

    }
}

    public void profile(View view) {
        Intent pp=new Intent(this,profilepage.class);
        startActivity(pp);
    }



    public void home(View view) {
        Intent hm=new Intent(this,feed.class);
        finish();
        startActivity(hm);

    }

    public void find(View view) {
        Intent fd=new Intent(this,found.class);
        startActivity(fd);
    }
}