package com.example.practicalexam;

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

        TextView countView = findViewById(R.id.text_tap_count);
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
