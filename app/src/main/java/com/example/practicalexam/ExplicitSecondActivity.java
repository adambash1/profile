package com.example.practicalexam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ExplicitSecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_second);

        Button backButton = findViewById(R.id.button_to_first);
        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, ExplicitFirstActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
