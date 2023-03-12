package com.example.luckyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyActivity extends AppCompatActivity {

    TextView lucky_text;
    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky);

        lucky_text=findViewById(R.id.textView2);
        share_btn=findViewById(R.id.share_number_btn);

        //Username
        Intent i=getIntent();
        String userName=i.getStringExtra("name");

        //Random Number Generated
        int random_Num=generateRandomNumber();

        lucky_text.setText(""+random_Num);

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName,random_Num);
            }
        });

    }

    private void shareData(String username,int randomNum) {

            //Implicit Intents
           Intent i=new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");

            //convert the int to string
            String number=String.valueOf(randomNum);


            i.putExtra(Intent.EXTRA_SUBJECT,username+" got lucky today!");
            i.putExtra(Intent.EXTRA_TEXT,"His lucky number is: "+number);

            startActivity(Intent.createChooser(i,"Choose a platform"));


    }

    public int generateRandomNumber(){
        Random random=new Random();
        int upper_limit=1000;

        int randomNumberGenerated=random.nextInt(1000);
        return randomNumberGenerated;
    }


}