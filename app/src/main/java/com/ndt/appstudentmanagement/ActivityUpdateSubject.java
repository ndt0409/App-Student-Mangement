package com.ndt.appstudentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ndt.appstudentmanagement.database.Database;
import com.ndt.appstudentmanagement.model.Subject;

public class ActivityUpdateSubject extends AppCompatActivity {
    EditText edtUpdateTitle, edtUpdateCredit, edtUpdateTime, edtUpdatePlace;
    Button btnUpdate;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_subject);

        edtUpdateCredit = findViewById(R.id.edtUpdateSubjectCredit);
        edtUpdateTime = findViewById(R.id.edtUpdateSubjectTime);
        edtUpdatePlace = findViewById(R.id.edtUpdateSubjectPlace);
        edtUpdateTitle = findViewById(R.id.edtUpdateSubjectTitle);

        btnUpdate = findViewById(R.id.btnUpdate);

        //lay du lieu intent
        Intent intent = getIntent();

        int id = intent.getIntExtra("id", 0);
        String title = intent.getStringExtra("title");
        int credit = intent.getIntExtra("credit", 0);
        String time = intent.getStringExtra("time");
        String place = intent.getStringExtra("place");

        edtUpdateTitle.setText(title);
        edtUpdateTime.setText(time);
        edtUpdatePlace.setText(place);
        edtUpdateCredit.setText(credit + "");

        database = new Database(this);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUpdate(id);
            }
        });
    }

    private void DialogUpdate(int id) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_update);
        dialog.setCanceledOnTouchOutside(false);
        Button btnYes = dialog.findViewById(R.id.btnYesUpdate);
        Button btnNo = dialog.findViewById(R.id.btnNoUpdate);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subjectTitle = edtUpdateTitle.getText().toString().trim();
                String credit = edtUpdateCredit.getText().toString().trim();
                String time = edtUpdateTime.getText().toString().trim();
                String place = edtUpdatePlace.getText().toString().trim();

                if (subjectTitle.equals("") || credit.equals("") || time.equals("") || place.equals("")) {
                    Toast.makeText(ActivityUpdateSubject.this, "Did you enter enought information", Toast.LENGTH_SHORT).show();
                } else {
                    Subject subject = updateSubject();
                    database.UpdateSubject(subject, id);

                    //update thanh cong thi qua activitySubject
                    Intent intent = new Intent(ActivityUpdateSubject.this, ActivitySubject.class);
                    startActivity(intent);
                    Toast.makeText(ActivityUpdateSubject.this, "more success", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.show();
    }


    //luu tru du lieu edittext
    private Subject updateSubject() {
        String subjectTitle = edtUpdateTitle.getText().toString().trim();
        int credit = Integer.parseInt(edtUpdateCredit.getText().toString().trim());
        String time = edtUpdateTime.getText().toString().trim();
        String place = edtUpdatePlace.getText().toString().trim();

        Subject subject = new Subject(subjectTitle, credit, time, place);
        return subject;
    }
}