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

public class LessonRecycleView {
    private Context mContext;
    private  LessonAdapter mLessonAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<ModelLesson> lessons, List<String> keys){
        mContext = context;
        mLessonAdapter = new LessonAdapter(lessons, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mLessonAdapter);
    }

    class LessonItemView extends RecyclerView.ViewHolder{
        private TextView mName;
        private TextView mDesc;
        private CheckBox mStatus;

        private  String key;

        public LessonItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.lesson_list_item, parent, false));

            mName = (TextView) itemView.findViewById(R.id.id_nameLesson);
            mDesc = (TextView) itemView.findViewById(R.id.textView4);
            mStatus = (CheckBox) itemView.findViewById(R.id.checkbox_Status);

        }

        public void bind(ModelLesson lesson, String key){
            mName.setText(lesson.getName());
            mDesc.setText(lesson.getDesc());
            mStatus.setText(lesson.getStatus());
            this.key = key;
        }
    }
    class LessonAdapter extends RecyclerView.Adapter<LessonItemView>{
        private List<ModelLesson> mLessonList;
        private List<String> mKeys;

        public LessonAdapter(List<ModelLesson> mLessonList, List<String> mKeys) {
            this.mLessonList = mLessonList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public LessonItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new LessonItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull LessonItemView holder, int position) {
        holder.bind(mLessonList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mLessonList.size();
        }
    }
}
