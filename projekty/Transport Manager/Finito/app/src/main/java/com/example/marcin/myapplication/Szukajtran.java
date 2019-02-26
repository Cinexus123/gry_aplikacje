package com.example.marcin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Szukajtran extends AppCompatActivity {

    TextView tv,tv1,tv2,tv3,tv4,tv5;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szukajtran);
        tv = (TextView) findViewById(R.id.textView41);
        tv1 = (TextView) findViewById(R.id.textView42);
        tv2= (TextView) findViewById(R.id.textView49);
        tv3 = (TextView) findViewById(R.id.textView51);
        tv4 = (TextView) findViewById(R.id.textView52);
        tv5= (TextView) findViewById(R.id.textView50);
        button=(Button) findViewById(R.id.button10);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity300();
            }
        });

        tv.setText(getIntent().getStringExtra("Name"));
        tv1.setText(getIntent().getStringExtra("DESCRIPTION"));
        tv2.setText(getIntent().getStringExtra("cena"));
        tv3.setText(getIntent().getStringExtra("data"));
        tv4.setText(getIntent().getStringExtra("godzina"));
        tv5.setText(getIntent().getStringExtra("miejsca"));

    }

    public void openActivity300(){
        Intent intent = new Intent(this,Passenger_choice.class);
        startActivity(intent);
        Toast.makeText(Szukajtran.this, "Zapisałeś się na wyjazd", Toast.LENGTH_LONG).show();
    }
}
