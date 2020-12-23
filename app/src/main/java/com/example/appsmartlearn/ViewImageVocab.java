package com.example.appsmartlearn;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewImageVocab extends RecyclerView.ViewHolder{
     ImageView imageView;
     //TextView textView;

    public ViewImageVocab(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.rImageView);
    }
}
