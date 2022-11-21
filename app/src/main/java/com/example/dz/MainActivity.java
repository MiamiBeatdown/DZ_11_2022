package com.example.dz;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private String countStrEmail;
    private String countStrPass;
    public static final String KEY = "555";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pattern patternEmail = Pattern.compile("(([A-Za-z0-9_\\.-]+)@([A-Za-z]+)\\.[a-z]{2,6})");
        Pattern patternPass = Pattern.compile("(.{6,15})");
        Button btn = findViewById(R.id.button);
        EditText txtEmail = findViewById(R.id.email);
        EditText txtPass = findViewById(R.id.pass);
        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                countStrEmail = editable.toString();
            }
        });
        txtPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                countStrPass = editable.toString();
            }
        });
        btn.setOnClickListener(view -> {
            if(countStrEmail == null || countStrPass == null){
                Toast toast = Toast.makeText(this, "Email or Pass is empty", LENGTH_LONG);
                toast.show();
            }
            else {
                Matcher matcherEmail = patternEmail.matcher(countStrEmail);
                Matcher matcherPass = patternPass.matcher(countStrPass);
                if (matcherEmail.matches() && matcherPass.matches()) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra(KEY, countStrEmail);
                    startActivity(intent);
                }
                else if(matcherEmail.matches()){
                    Toast toastPass = Toast.makeText(this, "Ivalid pass", LENGTH_LONG);
                    toastPass.show();
                }
                else {
                    Toast toastEmail = Toast.makeText(this, "Invalid email", LENGTH_LONG);
                    toastEmail.show();
                }
            }
        });

    }
}