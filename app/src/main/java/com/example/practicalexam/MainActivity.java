package com.example.practicalexam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button inchesButton = findViewById(R.id.button_inches_to_cm);
        Button tapButton = findViewById(R.id.button_tap_counter);
        Button bmiButton = findViewById(R.id.button_bmi);
        Button intentButton = findViewById(R.id.button_explicit_intent);
        Button calcButton = findViewById(R.id.button_calculator);

        inchesButton.setOnClickListener(view -> openActivity(InchesToCmActivity.class));
        tapButton.setOnClickListener(view -> openActivity(TapCounterActivity.class));
        bmiButton.setOnClickListener(view -> openActivity(BmiActivity.class));
        intentButton.setOnClickListener(view -> openActivity(ExplicitFirstActivity.class));
        calcButton.setOnClickListener(view -> openActivity(CalculatorActivity.class));
    }

    private void openActivity(Class<?> target) {
        Intent intent = new Intent(this, target);
        startActivity(intent);
    }
}
