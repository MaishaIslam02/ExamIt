package com.example.examit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examit.databinding.ActivityResultBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

public class ResultActivity extends AppCompatActivity {
    int POINTS = 1;
    ActivityResultBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.StopBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this,StopWatchActivity.class));
            }
        } );


        int correctAnswers = getIntent().getIntExtra("correct",0);
        int totalQuestions = getIntent().getIntExtra("total",0);

        int points = correctAnswers * POINTS ;
        binding.score.setText(String.format("%d/%d",correctAnswers,totalQuestions));
        binding.earnedCoins.setText(String.valueOf(points));
        FirebaseFirestore database = FirebaseFirestore.getInstance();

        database.collection("Users")
                        .document(FirebaseAuth.getInstance().getUid())
                                .update("coins", FieldValue.increment(points));
        database.collection("Users")
                .document(FirebaseAuth.getInstance().getUid())
                .update("POINTS", FieldValue.increment(POINTS));
                binding.restartBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this,MainActivity.class));

            }
        });
        binding.gicon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this,WorldActivity.class));

            }
        });


    }

}