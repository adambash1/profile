package com.example.practicalexam;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class BmiActivity extends AppCompatActivity {
    private final DecimalFormat decimalFormat =
            new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        EditText weightInput = findViewById(R.id.input_weight);
        EditText heightInput = findViewById(R.id.input_height);
        TextView resultView = findViewById(R.id.text_bmi_result);
        Button calculateButton = findViewById(R.id.button_calculate_bmi);

        calculateButton.setOnClickListener(view -> {
            String weightValue = weightInput.getText().toString().trim();
            String heightValue = heightInput.getText().toString().trim();

            if (TextUtils.isEmpty(weightValue)) {
                weightInput.setError(getString(R.string.error_required));
                resultView.setText("");
                return;
            }
            if (TextUtils.isEmpty(heightValue)) {
                heightInput.setError(getString(R.string.error_required));
                resultView.setText("");
                return;
            }

            try {
                double weight = Double.parseDouble(weightValue);
                double height = Double.parseDouble(heightValue);
                if (weight <= 0 || height <= 0) {
                    resultView.setText(getString(R.string.error_positive_values));
                    return;
                }
                double bmi = weight / (height * height);
                String category = getBmiCategory(bmi);
                String formattedBmi = decimalFormat.format(bmi);
                resultView.setText(getString(R.string.bmi_result, formattedBmi, category));
            } catch (NumberFormatException exception) {
                resultView.setText(getString(R.string.error_invalid_number));
            }
        });
    }

    private String getBmiCategory(double bmi) {
        if (bmi < 18.5) {
            return getString(R.string.bmi_underweight);
        }
        if (bmi < 25.0) {
            return getString(R.string.bmi_normal);
        }
        if (bmi < 30.0) {
            return getString(R.string.bmi_overweight);
        }
        return getString(R.string.bmi_obese);
    }
}
