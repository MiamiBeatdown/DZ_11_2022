package com.example.dz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tv = findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            tv.setText("Hello, " + bundle.getString(MainActivity.KEY) + "!");
        }
    }
}