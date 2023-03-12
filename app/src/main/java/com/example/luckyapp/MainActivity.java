package com.example.luckyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText1);
        btn=findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name=editText.getText().toString();

                //Explicit Intent
               Intent i=new Intent(getApplicationContext(),LuckyActivity.class);

                //Passing name to second activity
                i.putExtra("name",user_name);

                startActivity(i);


            }
        });
    }
}