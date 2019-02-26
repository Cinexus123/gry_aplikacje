package com.example.marcin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Glowna extends AppCompatActivity {
      Button button6,button7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glowna);
        button6=(Button) findViewById(R.id.button6);
        button7=(Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity6();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity7();
            }
        });
    }
    public void openActivity6()
    {
        Intent intent = new Intent(Glowna.this,Driver_choice.class);
        startActivity(intent);

    }
    public void openActivity7()
    {
       Intent intent = new Intent(Glowna.this,Passenger_choice.class);
       startActivity(intent);
    }


}
