package com.example.marcin.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.os.SystemClock.sleep;

public class Logowanie extends AppCompatActivity {
    private Button button;
    EditText editText10,editText7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logowanie);
        button = (Button)findViewById(R.id.button5);
        editText7=(EditText) findViewById(R.id.editText7);
        editText10 = (EditText) findViewById(R.id.editText10);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1=getIntent().getStringExtra("NAME");
                String text2 =editText10.getText().toString();


                if(editText7.equals("") || text2.equals("") )
                {
                    //there a no password
                    Toast.makeText(Logowanie.this,"Nie podano danych",Toast.LENGTH_SHORT).show();
                } else
                {
                    if(text2.equals(text1))
                    {

                        Toast.makeText(Logowanie.this, "Pomyślnie zalogowano"    /*FILE_NAME*/, Toast.LENGTH_LONG).show();
                        openActivity5();


                    } else
                    {
                        Toast.makeText(Logowanie.this,"Błędny login lub hasło",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
    public void openActivity5(){
        Intent intent = new Intent(this,Profil.class);
        startActivity(intent);
        Toast.makeText(Logowanie.this, "Zanim dodasz nowe ogloszenie musisz uzupełnić swój profil", Toast.LENGTH_LONG).show();
    }
}
