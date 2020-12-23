package com.example.appsmartlearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NormalVocabRecycleView {
    private Context mContext;
    private  NormalVocabAdapter normalVocabAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<ModelNormalVocab> vocabs, List<String> keys){
        mContext = context;
        normalVocabAdapter = new NormalVocabAdapter(vocabs, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(normalVocabAdapter);
    }

    class NormalVocabItemView extends RecyclerView.ViewHolder{
        private TextView mEng;
        private TextView mVie;
        private CheckBox mStatus;

        private  String key;

        public NormalVocabItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.normal_vocab_list_item, parent, false));

            mEng = (TextView) itemView.findViewById(R.id.id_nameLesson);
            mStatus = (CheckBox) itemView.findViewById(R.id.checkbox_Status);
            mVie = (TextView) itemView.findViewById(R.id.id_mean);

        }

        public void bind(ModelNormalVocab vocab, String key){
            mEng.setText(vocab.getEng());
            mVie.setText(vocab.getVie());
            mStatus.setText(vocab.getStatus());
            this.key = key;
        }
    }
    class NormalVocabAdapter extends RecyclerView.Adapter<NormalVocabItemView>{
        private List<ModelNormalVocab> mNormalVocabs;
        private List<String> mKeys;

        public NormalVocabAdapter(List<ModelNormalVocab> mNormalVocabs, List<String> mKeys) {
            this.mNormalVocabs = mNormalVocabs;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public NormalVocabItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new NormalVocabItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull NormalVocabItemView holder, int position) {
        holder.bind(mNormalVocabs.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mNormalVocabs.size();
        }
    }
}
