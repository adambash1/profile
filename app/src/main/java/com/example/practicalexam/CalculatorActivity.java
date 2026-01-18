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

public class CalculatorActivity extends AppCompatActivity {
    private final DecimalFormat decimalFormat =
            new DecimalFormat("0.##", new DecimalFormatSymbols(Locale.US));
    private Operation selectedOperation;

    private enum Operation {
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("x"),
        DIVIDE("/");

        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        EditText firstInput = findViewById(R.id.input_number_one);
        EditText secondInput = findViewById(R.id.input_number_two);
        TextView selectedView = findViewById(R.id.text_selected_operation);
        TextView resultView = findViewById(R.id.text_calculator_result);
        Button addButton = findViewById(R.id.button_add);
        Button subtractButton = findViewById(R.id.button_subtract);
        Button multiplyButton = findViewById(R.id.button_multiply);
        Button divideButton = findViewById(R.id.button_divide);
        Button calculateButton = findViewById(R.id.button_calculate);

        addButton.setOnClickListener(view -> selectOperation(Operation.ADD, selectedView));
        subtractButton.setOnClickListener(view -> selectOperation(Operation.SUBTRACT, selectedView));
        multiplyButton.setOnClickListener(view -> selectOperation(Operation.MULTIPLY, selectedView));
        divideButton.setOnClickListener(view -> selectOperation(Operation.DIVIDE, selectedView));

        calculateButton.setOnClickListener(view -> {
            String firstValue = firstInput.getText().toString().trim();
            String secondValue = secondInput.getText().toString().trim();

            if (selectedOperation == null) {
                resultView.setText(getString(R.string.error_select_operation));
                return;
            }
            if (TextUtils.isEmpty(firstValue)) {
                firstInput.setError(getString(R.string.error_required));
                resultView.setText("");
                return;
            }
            if (TextUtils.isEmpty(secondValue)) {
                secondInput.setError(getString(R.string.error_required));
                resultView.setText("");
                return;
            }

            try {
                double first = Double.parseDouble(firstValue);
                double second = Double.parseDouble(secondValue);
                if (selectedOperation == Operation.DIVIDE && second == 0.0) {
                    resultView.setText(getString(R.string.error_divide_by_zero));
                    return;
                }
                double result = calculate(first, second, selectedOperation);
                resultView.setText(getString(R.string.calc_result, decimalFormat.format(result)));
            } catch (NumberFormatException exception) {
                resultView.setText(getString(R.string.error_invalid_number));
            }
        });
    }

    private void selectOperation(Operation operation, TextView selectedView) {
        selectedOperation = operation;
        selectedView.setText(getString(R.string.selected_operation, operation.symbol));
    }

    private double calculate(double first, double second, Operation operation) {
        switch (operation) {
            case ADD:
                return first + second;
            case SUBTRACT:
                return first - second;
            case MULTIPLY:
                return first * second;
            case DIVIDE:
                return first / second;
            default:
                return 0.0;
        }
    }
}
