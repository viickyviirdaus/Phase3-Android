package com.example.vickyvirdaus.bliblitraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LauncherActivity extends AppCompatActivity {
    private EditText username, password;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        send = findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LauncherActivity.this, DetailsActivity.class);
                intent.putExtra("username", username.getText());
                intent.putExtra("password", password.getText());
                startActivity(intent);
            }
        });
    }
}
