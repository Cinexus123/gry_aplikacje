package com.example.marcin.myapplication;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Pasek5 extends android.support.v4.app.Fragment {


    EditText editText;
    Button button;
@Nullable

    @Override
    public View onCreateView(@Nullable LayoutInflater inflater,@Nullable  ViewGroup container,@Nullable Bundle savedInstanceState) {
    View rootView= inflater.inflate(R.layout.activity_pasek5,container,false);
    final EditText editText = (EditText) rootView.findViewById(R.id.editText100);
    final EditText editText1 = (EditText) rootView.findViewById(R.id.editText101);
    final EditText editText2 = (EditText) rootView.findViewById(R.id.editText202);
    final EditText editText3 = (EditText) rootView.findViewById(R.id.editText102);
    final EditText editText4 = (EditText) rootView.findViewById(R.id.editText200);
    final EditText editText5 = (EditText) rootView.findViewById(R.id.editText201);

    Button button = (Button) rootView.findViewById(R.id.wwe);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final String text1 = editText.getText().toString();
            final String text2 =editText1.getText().toString();
            String namevalue = editText.getText().toString();
            String namevalue1 = editText1.getText().toString();
            String namevalue2 = editText2.getText().toString();
            String namevalue3 = editText3.getText().toString();
            String namevalue4 = editText4.getText().toString();
            String namevalue5 = editText5.getText().toString();



            if(!text1.isEmpty() && (!text2.isEmpty()))
            {
                //there a no password
                Intent myIntent = new Intent(view.getContext(), Szukajtran.class);
                myIntent.putExtra("Name", namevalue);
                myIntent.putExtra("DESCRIPTION", namevalue1);
                myIntent.putExtra("cena", namevalue2);
                myIntent.putExtra("data", namevalue3);
                myIntent.putExtra("godzina", namevalue4);
                myIntent.putExtra("miejsca","Liczba wolnych miejsc : " + namevalue5);
                startActivity(myIntent);
            } else {
                Toast.makeText(view.getContext(),"Nie podano wszystkich danych",Toast.LENGTH_SHORT).show();
            }

        }
    });
    return rootView;

}
}
