package com.example.marcin.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Profil extends AppCompatActivity {

    EditText editText;
    Button button;
    CheckBox checkBox;

    private static final String TAG = "MainActivity";
    public DatePickerDialog.OnDateSetListener mDataSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        button = (Button) findViewById(R.id.button8);
        editText = (EditText) findViewById(R.id.editText17);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        button.setEnabled(false);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(Profil.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDataSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity10();
            }
        });
        mDataSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d(TAG, "OnDataSet : date: " + year + "/" + month + "/" + dayOfMonth);
                String date = dayOfMonth + "/" + month + "/" + year;
                editText.setText(date);
            }
        };

    }

    public void sprawdz(View view) {
        boolean bIsChecked = ((CheckBox) view).isChecked();//nazwa zmiennej bIsChecked typu boolean która spr czy checkbox jest wcisniety
        switch (view.getId()) {
            case R.id.checkBox://jezeli checkbox 1 jest właczony
                if (bIsChecked)
                    button.setEnabled(true);
                else
                    button.setEnabled(false);
                break;
        }
    }
    public void openActivity10()
    {
        Intent intent = new Intent(this,Glowna.class);
        startActivity(intent);
        Toast.makeText(Profil.this, "Pomyślnie zapisano", Toast.LENGTH_LONG).show();
    }

}
