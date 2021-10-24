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

public class ActivityAddSubject extends AppCompatActivity {
    Button btnAddSubject;
    EditText edtSubjectTitle, edtSubjectCredit, edtSubjectTime, edtSubjectPlace;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        btnAddSubject = findViewById(R.id.btnAdd);
        edtSubjectTitle = findViewById(R.id.edtSubjectTitle);
        edtSubjectCredit = findViewById(R.id.edtSubjectCredit);
        edtSubjectTime = findViewById(R.id.edtSubjectTime);
        edtSubjectPlace = findViewById(R.id.edtSubjectPlace);

        database = new Database(this);
        btnAddSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogAdd();
            }
        });
    }

    private void DialogAdd() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add);
        dialog.setCanceledOnTouchOutside(false);
        Button btnYes = dialog.findViewById(R.id.btnYes);
        Button btnNo = dialog.findViewById(R.id.btnNo);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subjecttitle = edtSubjectTitle.getText().toString().trim();
                String credit = edtSubjectCredit.getText().toString().trim();
                String time = edtSubjectTime.getText().toString().trim();
                String place = edtSubjectPlace.getText().toString().trim();

                if (subjecttitle.equals("") || credit.equals("") || time.equals("") || place.equals("")) {
                    Toast.makeText(ActivityAddSubject.this, "Did not enter enough information ", Toast.LENGTH_SHORT).show();
                } else {
                    //gan cho doi tuong subject gia tri duoc nhap vao
                    Subject subject = CreateSubject();

                    //add trong database
                    database.AddSubject(subject);

                    //add thanh cong thi chuyen qua giao dien subject
                    Intent intent = new Intent(ActivityAddSubject.this, ActivitySubject.class);
                    startActivity(intent);

                    Toast.makeText(ActivityAddSubject.this, "more success", Toast.LENGTH_SHORT).show();
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

    private Subject CreateSubject() {
        String subjecttitle = edtSubjectTitle.getText().toString().trim();
        int credit = Integer.parseInt(edtSubjectCredit.getText().toString().trim());
        String time = edtSubjectTime.getText().toString().trim();
        String place = edtSubjectPlace.getText().toString().trim();

        Subject subject = new Subject(subjecttitle, credit, time, place);
        return subject;
    }
}