package com.example.marcin.myapplication;

import android.app.ActionBar;
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

public class Rejestracja extends AppCompatActivity {

    private static final String FILE_NAME= "example.txt";
    EditText mEditText,mEditText5,mEditText6;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestracja);
        mEditText= (EditText) findViewById(R.id.editText2);
        mEditText5 = (EditText) findViewById(R.id.editText5);
        mEditText6 = (EditText) findViewById(R.id.editText6);
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text1 = mEditText5.getText().toString();
                String text2 =mEditText6.getText().toString();

                if(text1.equals("") || text2.equals(""))
                {
                    //there a no password
                    Toast.makeText(Rejestracja.this,"Nie podano wszystkich danych",Toast.LENGTH_SHORT).show();
                } else
                {
                    if(text1.equals(text2))
                    {
                        SharedPreferences settings =getSharedPreferences("PREFS",0);
                        SharedPreferences.Editor editor =  settings.edit();
                        editor.putString("password",text1);
                        editor.apply();

                        //enter the app
                        String namevalue = mEditText.getText().toString();
                        Intent intent = new Intent(getApplicationContext(),Logowanie.class);
                        intent.putExtra("NAME",namevalue);


                        startActivity(intent);
                        String text =mEditText.getText().toString();
                        FileOutputStream fos = null;

                        try{
                            fos =openFileOutput(FILE_NAME,MODE_PRIVATE);
                            fos.write(text.getBytes());


                            Toast.makeText(Rejestracja.this, "Pomyślnie zapisano do bazy danych,zaloguj się :)"    /*FILE_NAME*/, Toast.LENGTH_LONG).show();


                        }
                        catch(FileNotFoundException e){
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        finally{
                            if(fos != null)
                            {
                                try {
                                    fos.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        finish();
                    } else
                    {
                        Toast.makeText(Rejestracja.this,"Hasła nie są identyczne",Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });





        }



    }

