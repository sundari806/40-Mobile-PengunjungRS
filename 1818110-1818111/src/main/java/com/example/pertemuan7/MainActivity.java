package com.example.pertemuan7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btn_create(View view){
        Intent a = new Intent(com.example.pertemuan7.MainActivity.this, com.example.pertemuan7.MainCreate.class);
        startActivity(a);
    }
    public void btn_read(View view) {
        Intent b = new Intent(com.example.pertemuan7.MainActivity.this, MainRead.class);
        startActivity(b);
    }
}
