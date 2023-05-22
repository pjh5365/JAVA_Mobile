package com.pjh5365.mobileex;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;

public class Ex8_2 extends AppCompatActivity {

    Button btnPrev, btnNext;
    myPictureView myPicture;
    int curNum = 1;
    File[] imageFiles;
    String imageFname;
    TextView curCount;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단한 이미지 뷰어");

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        myPicture = (myPictureView) findViewById(R.id.myPictureView1);
        curCount = (TextView) findViewById(R.id.curCount);

        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Pictures").listFiles();
        imageFname = imageFiles[curNum].toString();
        myPicture.imagePath = imageFname;

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curNum <= 1) {
                    curNum = 9;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    curCount.setText(curNum + "/" +(imageFiles.length-1));
                } else {
                    curNum--;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    curCount.setText(curNum + "/" +(imageFiles.length-1));
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curNum >= imageFiles.length-1) {
                    curNum = 1;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    curCount.setText(curNum + "/" + (imageFiles.length-1));
                } else  {
                    curNum++;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    curCount.setText(curNum + "/" + (imageFiles.length-1));
                }
            }
        });
    }
}


