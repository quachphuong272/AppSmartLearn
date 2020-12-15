package com.example.appsmartlearn;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LessonListActivity extends AppCompatActivity {
    private RecyclerView mRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_list);
        mRecycleView = (RecyclerView) findViewById(R.id.recycleview_Lesson);
        new FirebaseLesson().readLesson(new FirebaseLesson.DataStatus() {
            @Override
            public void DataIsLoaded(List<ModelLesson> lessons, List<String> keys) {
                new LessonRecycleView().setConfig(mRecycleView, LessonListActivity.this, lessons, keys);
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
