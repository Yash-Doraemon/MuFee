package com.example.mufee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup1 extends AppCompatActivity{
    private TextView name;
    private TextView email;
    private TextView password;
    private TextView cnfpasss;
    private ProgressBar pb;
    private FirebaseAuth firebaseAuth;
    private Button login;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);
        name= (EditText) findViewById(R.id.NameEditText);
        email= (EditText) findViewById(R.id.USNeditText2);
        password=(EditText)findViewById(R.id.PasswordeditText3);
        cnfpasss=(EditText) findViewById(R.id.cnfpass);
        pb=(ProgressBar) findViewById(R.id.progressBar);
        progressDialog = new ProgressDialog(this);
        login=(Button)findViewById(R.id.nextbutton);

        firebaseAuth= FirebaseAuth.getInstance();

            login.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    final String emailstr = email.getText().toString().trim();
                    final String pname = name.getText().toString().trim();
                    String passwordstr = password.getText().toString().trim();
                    String cnfpasswordstr = cnfpasss.getText().toString().trim();
                    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                    if (TextUtils.isEmpty(emailstr))
                    {Toast.makeText(Signup1.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                    if (!(emailstr.matches(emailPattern)))
                    {
                        Toast.makeText(Signup1.this, "Enter a Valid Email address", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(passwordstr))
                    { Toast.makeText(Signup1.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;

                }
                    if(TextUtils.isEmpty(cnfpasswordstr))
                    {Toast.makeText(Signup1.this, "Enter Confirm Passwordl", Toast.LENGTH_SHORT).show();
                    return;
                }

                    if(passwordstr.length()<6){
                        Toast.makeText(Signup1.this, "Password too short", Toast.LENGTH_SHORT).show();
                    }
                    if(passwordstr.equals(cnfpasswordstr)){
                        progressDialog.setMessage("Signing Up");

                    progressDialog.show();




                    pb.setVisibility(View.VISIBLE);
                        {

                            firebaseAuth.createUserWithEmailAndPassword(emailstr, passwordstr)
                                    .addOnCompleteListener(Signup1.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {

                                           pb.setVisibility(View.GONE);
                                            if (task.isSuccessful()) {
                                                finish();

                                                // Sign in success, update UI with the signed-in user's information
                                                Intent su2 = new Intent(Signup1.this, Signup2.class);

                                                su2.putExtra("NAME", pname);
                                                 su2.putExtra("EMAIL", emailstr);

                                                    finish();
                                                startActivity(su2);
                                            } else {
                                                // If sign in fails, display a message to the user.
                                                progressDialog.dismiss();
                                                Toast.makeText(Signup1.this, "FireBase Authentication Failed", Toast.LENGTH_SHORT).show();
                                            }

                                            // ...
                                        }
                                    });
                        }






                    }

                }

            });




    }



    public void about(View view) { Intent abt=new Intent(this,mufeewidget.class);
        startActivity(abt);
    }


}
