package com.example.practicalexam;

/*
Problem 4:
Exercise Objective: Build a simple Android app that allows users to navigate to other
activities using Explicit Intents.
Problem Statement: The app should have two activities each having a separate button.
Upon clicking on the button of first activity, second activity should open and upon
clicking on the button of second activity, first activity should be displayed.
Expected Output: Navigation between activities using explicit intent.
*/

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ExplicitSecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_second);

        // Button that opens the first activity using an explicit intent.
        Button backButton = findViewById(R.id.button_to_first);
        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, ExplicitFirstActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
