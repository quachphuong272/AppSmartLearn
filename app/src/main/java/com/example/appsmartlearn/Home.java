package com.example.appsmartlearn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    private DrawerLayout drawer;
    private GridView catGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        catGrid = findViewById(R.id.catGridView);

        List<String> catList = new ArrayList<>();
        catList.add("Cat 1");
        catList.add("Cat 2");
        catList.add("Cat 3");
        catList.add("Cat 4");
        catList.add("Cat 5");
        catList.add("Cat 6");
        catList.add("Cat 7");
        catList.add("Cat 8");

        HomeAdapter adapter = new HomeAdapter(catList);
        catGrid.setAdapter(adapter);
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
            Home.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}