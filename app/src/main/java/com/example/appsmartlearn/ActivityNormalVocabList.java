package com.example.appsmartlearn;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ActivityNormalVocabList extends AppCompatActivity {
    private RecyclerView mRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_vocab_list);
        mRecycleView = (RecyclerView) findViewById(R.id.recycleview_Lesson);

        new FirebaseNormalVocab().readNormalVocab(new FirebaseNormalVocab.DataStatus() {
            @Override
            public void DataIsLoaded(List<ModelNormalVocab> vocabs, List<String> keys) {
                new NormalVocabRecycleView().setConfig(mRecycleView, ActivityNormalVocabList.this, vocabs, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }

        });

    }

}
