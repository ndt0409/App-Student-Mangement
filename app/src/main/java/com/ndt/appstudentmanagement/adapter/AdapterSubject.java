package com.ndt.appstudentmanagement.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ndt.appstudentmanagement.ActivitySubject;
import com.ndt.appstudentmanagement.R;
import com.ndt.appstudentmanagement.model.Subject;

import java.util.ArrayList;

public class AdapterSubject extends BaseAdapter {
    private ActivitySubject context;

    private ArrayList<Subject> ArrayListSubject;

    public AdapterSubject(ActivitySubject context, ArrayList<Subject> arrayListSubject) {
        this.context = context;
        ArrayListSubject = arrayListSubject;
    }

    @Override
    public int getCount() {
        return ArrayListSubject.size();
    }

    @Override
    public Object getItem(int i) {
        return ArrayListSubject.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.listsubject, null);
        TextView tvSubjectTitle = view.findViewById(R.id.tvSubjectTitle);
        TextView tvCredit = view.findViewById(R.id.tvCredit);
        ImageButton imgDelete = view.findViewById(R.id.subjectDelete);
        ImageButton imgUpdate = view.findViewById(R.id.subjectUpdate);
        ImageButton imgInformation = view.findViewById(R.id.subjectInformation);
        Subject subject = ArrayListSubject.get(i);
        tvCredit.setText(subject.getNumber_of_credit());
        tvSubjectTitle.setText(subject.getSubject_title());

        int id = subject.getId();
        imgInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        imgUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return null;
    }
}
