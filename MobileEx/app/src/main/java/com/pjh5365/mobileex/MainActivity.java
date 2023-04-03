package com.pjh5365.mobileex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "버튼을 눌렀어요", Toast.LENGTH_SHORT).show();
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setBackgroundColor(Color.GRAY);
        button2.setTextColor(Color.BLACK);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent url = new Intent(Intent.ACTION_VIEW, Uri.parse("http://nate.com"));
                startActivity(url);
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setBackgroundColor(Color.GREEN);
        button3.setTextColor(Color.BLACK);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent url = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:911"));
                startActivity(url);
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setBackgroundColor(Color.RED);
        button4.setTextColor(Color.BLACK);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent url = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                startActivity(url);
            }
        });

        button5 = (Button) findViewById(R.id.button5);
        button5.setBackgroundColor(Color.YELLOW);
        button5.setTextColor(Color.BLACK);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}