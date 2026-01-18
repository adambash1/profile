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

        // Menu button to open the inches to centimetres converter.
        Button inchesButton = findViewById(R.id.button_inches_to_cm);
        // Menu button to open the tap counter.
        Button tapButton = findViewById(R.id.button_tap_counter);
        // Menu button to open the BMI calculator.
        Button bmiButton = findViewById(R.id.button_bmi);
        // Menu button to open the explicit intent exercise.
        Button intentButton = findViewById(R.id.button_explicit_intent);
        // Menu button to open the basic calculator.
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
