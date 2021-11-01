package com.ndt.appstudentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ActivitySubjectInformation extends AppCompatActivity {

    TextView tvTitle, tvCredit, tvTime, tvPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_information);
        tvCredit = findViewById(R.id.tvSubjectCredit);
        tvPlace = findViewById(R.id.tvSubjectPlace);
        tvTime = findViewById(R.id.tvSubjectTime);
        tvTitle = findViewById(R.id.tvSubjectTitle);

        //lay du lieu
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int credit = intent.getIntExtra("credit", 0);
        String time = intent.getStringExtra("time");
        String place = intent.getStringExtra("place");

        //gan gia tri len
        tvTitle.setText(title);
        tvTime.setText(time);
        tvCredit.setText(credit + "");
        tvPlace.setText(place);
    }
}