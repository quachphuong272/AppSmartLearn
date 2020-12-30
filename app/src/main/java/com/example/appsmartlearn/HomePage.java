package com.example.appsmartlearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class HomePage extends AppCompatActivity {

        private DrawerLayout drawer;
        private Button btn_normal_vocab, btn_img_vocab, btn_quiz;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home_page);

            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            btn_quiz=findViewById(R.id.quiz_vocab);
            drawer = findViewById(R.id.drawer_layout);
            btn_normal_vocab = findViewById(R.id.normal_vocab);
            btn_img_vocab = findViewById(R.id.img_vocab);

            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            btn_normal_vocab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), ActivityNormalVocabList.class));
                }
            });

            btn_img_vocab.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    startActivity(new Intent(getApplicationContext(), ActivityImgVocab.class));
                }
            });
            btn_quiz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(),Home.class));
                }
            });
        }
        public void onBackPressed() {
            if(drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(item.getItemId() == android.R.id.home)
            {
                com.example.appsmartlearn.HomePage.this.finish();
            }
            return super.onOptionsItemSelected(item);
        }
    }

