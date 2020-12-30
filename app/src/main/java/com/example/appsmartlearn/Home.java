package com.example.appsmartlearn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.appsmartlearn.SetsActivity.category_id;

public class Home extends AppCompatActivity {

    private DrawerLayout drawer;
    private GridView catGrid;
    private int setNo;
    private Button backhomepage;

    private FirebaseDatabase database;
    private DatabaseReference mReference;

    // private FirebaseFirestore firestore;

    public static List<String> catlist = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        backhomepage =findViewById(R.id.backhomePage);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        catGrid = findViewById(R.id.catGridView);

        new Thread() {
            public void run() {
                loadData();
            }
        }.start();


//        backhomepage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent =new Intent(Home.this,HomePage.class);
//                Home.this.startActivity(intent);
//               Home.this.finish();
//            }
//        });


    }

    private void loadData()
    {       database=FirebaseDatabase.getInstance();
            catlist.clear();

        mReference= database.getReference("Category").child("CA");
        mReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot catS :snapshot.getChildren())
                {
                    String categoryModel =catS.getValue().toString();
                    catlist.add(categoryModel);
                    HomeAdapter adapter = new HomeAdapter(catlist);
                    catGrid.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Home.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}


    