package com.example.vickyvirdaus.bliblitraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class DetailsActivity extends AppCompatActivity {

    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        Intent intent = getIntent();
        username.setText(intent.getStringExtra("username"));
        password.setText(intent.getStringExtra("password"));
    }
}
