package com.ndt.appstudentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSubject, btnAuthor, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAuthor = findViewById(R.id.btnAuthor);
        btnExit = findViewById(R.id.btnExit);
        btnSubject = findViewById(R.id.btnSubject);

        btnAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogAuthor();
            }
        });
        btnSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivitySubject.class);
                startActivity(intent);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogExit();
            }
        });
    }

    private void DialogExit() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_exit);
        //tắt click ngoài là thoát
        dialog.setCanceledOnTouchOutside(false);
        Button btnYes = dialog.findViewById(R.id.btnYes);
        Button btnNo = dialog.findViewById(R.id.btnNo);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
//thoát
                Intent intent1 = new Intent(Intent.ACTION_MAIN);
                intent1.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent1);
            }
        });
        //click no đóng cửa sổ
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    //hiển thị thông tin tác giả
    private void DialogAuthor() {
        //tạo đối tượng cửa sổ dialog
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_information);
        dialog.show();
    }
}