package com.example.practicalexam;

/*
Problem 2:
Exercise Objective: Develop an Android application that counts the number of taps on a
button and displays the count.
Problem Statement: Create an app with a button labelled "Tap me!" and a TextView to
display the count of taps. Each time the button is tapped, the count should increase
by one.
Expected Output: The app displays the number of times the button has been tapped.
*/

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TapCounterActivity extends AppCompatActivity {
    private int tapCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_counter);

        // Output label for the tap count.
        TextView countView = findViewById(R.id.text_tap_count);
        // Button that increments the counter.
        Button tapButton = findViewById(R.id.button_tap_me);

        updateCount(countView);
        tapButton.setOnClickListener(view -> {
            tapCount += 1;
            updateCount(countView);
        });
    }

    private void updateCount(TextView countView) {
        countView.setText(getString(R.string.tap_count, tapCount));
    }
}
