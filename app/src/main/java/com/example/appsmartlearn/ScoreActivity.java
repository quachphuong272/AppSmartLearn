package com.example.appsmartlearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {
    private TextView score;
    private Button done ,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        score = findViewById(R.id.sa_score);
        done = findViewById(R.id.sa_done);
        back=findViewById(R.id.backhome);

        String score_str = getIntent().getStringExtra("SCORE");
        score.setText(score_str);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this,SetsActivity.class);
                ScoreActivity.this.startActivity(intent);
                ScoreActivity.this.finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ScoreActivity.this,Home.class);
                ScoreActivity.this.startActivity(intent);
                ScoreActivity.this.finish();
            }
        });

    }
}