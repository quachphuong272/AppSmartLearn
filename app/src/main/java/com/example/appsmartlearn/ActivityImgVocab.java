package com.example.appsmartlearn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


public class ActivityImgVocab extends AppCompatActivity {

    RecyclerView mRecycleView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    FirebaseRecyclerOptions<ModelImageVocab> options;
    FirebaseRecyclerAdapter<ModelImageVocab, ViewImageVocab> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_vocab);

        mRecycleView = findViewById(R.id.recycleview_word);
        mRecycleView.setHasFixedSize(true);

        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Image_Vocab");
        onStart();
    }
        @Override
        protected void onStart() {
        super.onStart();
            options= new FirebaseRecyclerOptions.Builder<ModelImageVocab>().setQuery(reference, ModelImageVocab.class).build();
            adapter = new FirebaseRecyclerAdapter<ModelImageVocab, ViewImageVocab>(options) {
                @Override
                protected void onBindViewHolder(@NonNull ViewImageVocab viewImageVocab, int i, @NonNull ModelImageVocab image_vocab) {
                    Picasso.get().load(image_vocab.getImg()).into(viewImageVocab.imageView);
                }

                @NonNull
                @Override
                public ViewImageVocab onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.img_vocab_item, parent, false);
                    return new ViewImageVocab(v);
                }
            };

            adapter.startListening();
            mRecycleView.setAdapter(adapter);


        }

}
