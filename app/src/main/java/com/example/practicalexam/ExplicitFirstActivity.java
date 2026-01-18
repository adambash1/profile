package com.example.practicalexam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ExplicitFirstActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_first);

        Button nextButton = findViewById(R.id.button_to_second);
        nextButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, ExplicitSecondActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
