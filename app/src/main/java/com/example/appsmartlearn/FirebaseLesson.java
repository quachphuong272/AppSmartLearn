package com.example.appsmartlearn;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseLesson {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceLessons;
    private List<ModelLesson> lessons = new ArrayList<>();

    public interface DataStatus {
        void DataIsLoaded(List<ModelLesson> lessons, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseLesson() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceLessons = mDatabase.getReference("Lesson");
    }

    public void readLesson (final DataStatus dataStatus){
        mReferenceLessons.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lessons.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : snapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    ModelLesson lesson = keyNode.getValue(ModelLesson.class);
                    lessons.add(lesson);
                }
                dataStatus.DataIsLoaded(lessons,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
