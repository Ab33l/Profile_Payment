package com.example.android.profile_payment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewActivity extends AppCompatActivity {
    private TextView TextUsername, TextEmail, TextPhone;
    private Button buttonEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        TextUsername = findViewById(R.id.TextUsername);
        TextEmail = findViewById(R.id.TextEmail);
        TextPhone = findViewById(R.id.TextPhone);
        findViewById(R.id.buttonEdit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(ViewActivity.this, PersonalActivity.class));
            }
        });
    }
}
