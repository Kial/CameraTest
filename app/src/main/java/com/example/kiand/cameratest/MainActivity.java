package com.example.kiand.cameratest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void takePicture(View view) {
        Intent takePictureIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }

    }
    static final String[] messages = new String[] {"Lookin' Good", "Sharp as a Tack", "Error: Icebreaker.exe Not Found"};
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int i = 1;
        ImageView img = findViewById(R.id.imageView3);
        TextView textView = findViewById(R.id.textView);
        Random rand = new Random();
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img.setImageBitmap(imageBitmap);
            textView.setText(messages[rand.nextInt(3)]);
            i++;
        }
    }
}
