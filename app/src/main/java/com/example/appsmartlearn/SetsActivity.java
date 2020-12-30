package com.example.appsmartlearn;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;


public class SetsActivity extends AppCompatActivity {
        private GridView sets_grid;
        public static int category_id;
        //public List<String> catlist;
       // private FirebaseFirestore firestore;
       private FirebaseDatabase database;
       private DatabaseReference mReference;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sets);

            Toolbar toolbar = findViewById(R.id.set_toolbar);
            setSupportActionBar(toolbar);

            String title = getIntent().getStringExtra("CATEGORY");
             category_id=getIntent().getIntExtra("CATEGORY_ID",1);
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            sets_grid = findViewById(R.id.sets_gridview);

//
//            new Thread() {
//                public void run() {
//                    loadSets();
//                }
//            }.start();

            // firestore =FirebaseFirestore.getInstance();
            SetsAdapter adapter = new SetsAdapter(6);
            sets_grid.setAdapter(adapter);

        }
//       public void loadSets()
//        {
//            database=FirebaseDatabase.getInstance();
//           // catlist =null;
//
//                    mReference = database.getReference("Category").child("Cat" + Integer.valueOf(category_id));
//
//                    mReference.child("SETS").addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//                            for(DataSnapshot set :snapshot.getChildren())
//                            {
//                                String sets =set.getValue().toString();
//                                SetsAdapter adapter = new SetsAdapter(6);
//                                sets_grid.setAdapter(adapter);
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//
//                        }
//                    });
//                }



        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(item.getItemId() == android.R.id.home)
            {
                SetsActivity.this.finish();
            }
            return super.onOptionsItemSelected(item);
        }
}
//Toast.makeText(SetsActivity.this, "" + set, Toast.LENGTH_SHORT).show();
//    int t =0;
//                    for(int i =0; i<20;i++)
//        {
//
//        String k = String.valueOf(i);
//
//        if(k.equals(set))
//        {
//        t=i;
//
//        }
//        }