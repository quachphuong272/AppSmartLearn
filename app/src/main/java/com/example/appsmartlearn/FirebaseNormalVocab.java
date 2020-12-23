package com.example.appsmartlearn;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseNormalVocab {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private List<ModelNormalVocab> vocabs = new ArrayList<>();

    public interface DataStatus {
        void DataIsLoaded(List<ModelNormalVocab> vocabs, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseNormalVocab() {
        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("Normal_Vocab");
    }

    public void readNormalVocab (final DataStatus dataStatus){
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                vocabs.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : snapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    ModelNormalVocab vocab = keyNode.getValue(ModelNormalVocab.class);
                    vocabs.add(vocab);
                }
                dataStatus.DataIsLoaded(vocabs,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}