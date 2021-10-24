package com.ndt.appstudentmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ndt.appstudentmanagement.adapter.AdapterSubject;
import com.ndt.appstudentmanagement.database.Database;
import com.ndt.appstudentmanagement.model.Subject;

import java.util.ArrayList;

public class ActivitySubject extends AppCompatActivity {

    Toolbar toolbar;
    ListView listViewSubject;
    ArrayList<Subject> ArrayListSubjects;
    Database database;
    AdapterSubject adapterSubject;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        toolbar = findViewById(R.id.toolbarSubject);
        listViewSubject = findViewById(R.id.listviewSubject);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        database = new Database(this);
        ArrayListSubjects = new ArrayList<>();
        Cursor cursor = database.getDataSubject();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            int credit = cursor.getInt(2);
            String time = cursor.getString(3);
            String place = cursor.getString(4);

            ArrayListSubjects.add(new Subject(id, title, credit, time, place));
        }
        adapterSubject = new AdapterSubject(ActivitySubject.this, ArrayListSubjects);
        listViewSubject.setAdapter(adapterSubject);
        cursor.moveToFirst();
        cursor.close();

        //tao su kien click vao item subject
        listViewSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ActivitySubject.this, ActivityStudent.class);
                int id_subject = ArrayListSubjects.get(i).getId();

                //truyen du lieu id subject qua activity student
                intent.putExtra("id_subject", id_subject);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuadd, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            //neu click vao add thi chuyen sang man hinh add subject
            case R.id.menuAdd:
                Intent intent1 = new Intent(ActivitySubject.this, ActivityAddSubject.class);
                startActivity(intent1);
                break;
            //neu click vao nut con lai la nut back thi quay lai main
            default:
                Intent intent = new Intent(ActivitySubject.this, MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //neu click back quay ve main activity
    @Override
    public void onBackPressed() {
        count++;
        if (count >= 1) {
            Intent intent = new Intent(ActivitySubject.this, ActivitySubject.class);
            startActivity(intent);
            finish();
        }
    }
}
