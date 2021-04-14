package com.example.noufalobaidi_midt1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
    Button printbttn, deletebttn;
    EditText p;
    DatabaseHelper Mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        printbttn = (Button)findViewById(R.id.printbttn);
        deletebttn = (Button)findViewById(R.id.deletebttn);
        p = (EditText)findViewById(R.id.editText);
        Mydb = new DatabaseHelper(this);
        printbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = Mydb.ViewUsers();
                StringBuffer buffer = new StringBuffer();
                Toast.makeText(Activity3.this, "Successful View", Toast.LENGTH_LONG).show();
                while (cursor.moveToNext()) {

                    buffer.append("id: " + cursor.getString(0) + "\n");
                    buffer.append("name: " + cursor.getString(1) + "\n");
                    buffer.append("salary: " + cursor.getString(2) + "\n\n");
                }


                AlertDialog.Builder builder = new AlertDialog.Builder(Activity3.this);
                builder.setCancelable(true);
                builder.setTitle("All Employees");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

        deletebttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mydb.DeleteUsers(p.getText().toString());
                Toast.makeText(Activity3.this,"Successfully deleted entry",Toast.LENGTH_SHORT).show();
            }
        });


        Button go1=(Button)findViewById(R.id.goto1);

        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity3.this,MainActivity.class));
            }
        });

    }
}
