package com.alperen.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        new CountDownTimer(10000,1000){
            @Override
            public void onTick(long l) {
                textView.setText("Left:"+ l/1000);
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "Done!", Toast.LENGTH_SHORT).show();
                textView.setText("disappear");
                new CountDownTimer(1000,100){

                    @Override
                    public void onTick(long l) {
                        //buraya bir şey yazmasam da olur mu?
                    }

                    @Override
                    public void onFinish() {
                        textView.setText("");
                        //bundan sonra textView objesinin yok olmasını istersem veya tamamen kullanıcının erişimine kapatmak istersem ne yapacağım?
                    }
                }.start();
            }


        }.start();
        }
}
