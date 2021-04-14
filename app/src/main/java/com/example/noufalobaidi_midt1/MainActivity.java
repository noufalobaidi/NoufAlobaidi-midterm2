package com.example.noufalobaidi_midt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper Mydb;
    EditText edt1, edt2, edt3;
    Button btninsert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText)findViewById(R.id.id);
        edt2 = (EditText)findViewById(R.id.PersonName);
        edt3 = (EditText)findViewById(R.id.EmailAddress);


        Mydb = new DatabaseHelper(this);


        btninsert = (Button)findViewById(R.id.buttonInsert);


        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mydb.AddUsers(edt1.getText().toString(),
                        edt2.getText().toString(),
                        Integer.parseInt(edt3.getText().toString()));
                Toast.makeText(MainActivity.this, "Successful Add", Toast.LENGTH_LONG).show();
                edt1.getText().clear();
                edt2.getText().clear();
                edt3.getText().clear(); }

        });

        Button go2=(Button)findViewById(R.id.goto2);
        Button go3=(Button)findViewById(R.id.goto3);

        go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Activity2.class));
            }
        });
        go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Activity3.class));
            }
        });

    }
}