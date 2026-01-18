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

public class InchesToCmActivity extends AppCompatActivity {
    private static final double INCH_TO_CM = 2.54;
    private final DecimalFormat decimalFormat =
            new DecimalFormat("0.##", new DecimalFormatSymbols(Locale.US));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inches_to_cm);

        EditText inputInches = findViewById(R.id.input_inches);
        TextView resultView = findViewById(R.id.text_cm_result);
        Button convertButton = findViewById(R.id.button_convert);

        convertButton.setOnClickListener(view -> {
            String value = inputInches.getText().toString().trim();
            if (TextUtils.isEmpty(value)) {
                inputInches.setError(getString(R.string.error_required));
                resultView.setText("");
                return;
            }
            try {
                double inches = Double.parseDouble(value);
                if (inches < 0) {
                    inputInches.setError(getString(R.string.error_non_negative));
                    resultView.setText("");
                    return;
                }
                double cm = inches * INCH_TO_CM;
                String formatted = decimalFormat.format(cm);
                resultView.setText(getString(R.string.inches_to_cm_result, formatted));
            } catch (NumberFormatException exception) {
                inputInches.setError(getString(R.string.error_invalid_number));
                resultView.setText("");
            }
        });
    }
}
