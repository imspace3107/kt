package com.example.kt2;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
import android.content.*;


import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {
    private  TextView ten;
    private ImageView hinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        product products=(product) intent.getSerializableExtra("product");
        this.ten=(TextView)findViewById(R.id.ten);
        this.ten.setText(products.getTen());
        this.hinh=(ImageView)findViewById(R.id.hinh);
        this.hinh.setImageResource(products.getHinh());

    }
}