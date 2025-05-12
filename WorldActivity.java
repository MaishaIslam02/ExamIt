package com.example.examit;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class WorldActivity extends AppCompatActivity {

    ImageView imageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world);
        imageView = findViewById(R.id.imageview1 );

        // Adding the gif here using glide library
        Glide.with(this).load(R.drawable.globe).into(imageView);
    }
}
