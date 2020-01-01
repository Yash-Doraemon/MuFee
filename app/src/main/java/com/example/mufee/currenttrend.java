package com.example.mufee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

public class currenttrend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currenttrend);

        TextView tv= (TextView) findViewById(R.id.aiml);
        tv.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv1= (TextView) findViewById(R.id.iot);
        tv1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv2= (TextView) findViewById(R.id.arvr);
        tv2.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv3= (TextView) findViewById(R.id.mun);
        tv3.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv4= (TextView) findViewById(R.id.uni);
        tv4.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv5= (TextView) findViewById(R.id.tesla);
        tv5.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv6= (TextView) findViewById(R.id.web);
        tv6.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv7= (TextView) findViewById(R.id.block);
        tv7.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv8= (TextView) findViewById(R.id.aut);
        tv8.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv9= (TextView) findViewById(R.id.design);
        tv9.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv10= (TextView) findViewById(R.id.psycho);
        tv10.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv11= (TextView) findViewById(R.id.nano);
        tv11.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv12= (TextView) findViewById(R.id.quan);
        tv12.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv13= (TextView) findViewById(R.id.robo);
        tv7.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv14= (TextView) findViewById(R.id.net);
        tv14.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv15= (TextView) findViewById(R.id.auto1);
        tv15.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv16= (TextView) findViewById(R.id.entre);
        tv16.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv17= (TextView) findViewById(R.id.com);
        tv17.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv18= (TextView) findViewById(R.id.sale);
        tv18.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tv19= (TextView) findViewById(R.id.fin);
        tv19.setMovementMethod(LinkMovementMethod.getInstance());

    }


    public void about(View view) {
        Intent abt=new Intent(this,mufeewidget.class);
        startActivity(abt);
    }
}