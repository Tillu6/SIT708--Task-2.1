package com.example.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner categorySpinner, sourceUnitSpinner, destUnitSpinner;
    private EditText inputValue;
    private Button convertButton;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link UI elements
        categorySpinner = findViewById(R.id.categorySpinner);
        sourceUnitSpinner = findViewById(R.id.sourceUnitSpinner);
        destUnitSpinner = findViewById(R.id.destUnitSpinner);
        inputValue = findViewById(R.id.inputValue);
        convertButton = findViewById(R.id.convertButton);
        resultView = findViewById(R.id.resultView);

        // Populate the Category Spinner using custom spinner_item layout for white text
        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.category_array,
                R.layout.spinner_item
        );
        categoryAdapter.setDropDownViewResource(R.layout.spinner_item);
        categorySpinner.setAdapter(categoryAdapter);
        categorySpinner.setOnItemSelectedListener(this);

        // Convert button logic
        convertButton.setOnClickListener(v -> {
            String inputStr = inputValue.getText().toString().trim();
            if (inputStr.isEmpty()) {
                resultView.setText("Please enter a valid number!");
                return;
            }
            double inputVal = Double.parseDouble(inputStr);
            String source = sourceUnitSpinner.getSelectedItem().toString();
            String dest = destUnitSpinner.getSelectedItem().toString();
            String category = categorySpinner.getSelectedItem().toString();

            if (source.equals(dest)) {
                resultView.setText("Source and destination units are the same!");
                return;
            }
            double convertedVal = performConversion(category, source, dest, inputVal);
            resultView.setText(String.format("%.2f %s", convertedVal, dest));
        });
    }

    // When a category is selected, load the corresponding units for the source/destination spinners
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String category = parent.getItemAtPosition(position).toString();
        ArrayAdapter<CharSequence> unitsAdapter;
        switch (category) {
            case "Length":
                unitsAdapter = ArrayAdapter.createFromResource(
                        this, R.array.length_units, R.layout.spinner_item
                );
                break;
            case "Weight":
                unitsAdapter = ArrayAdapter.createFromResource(
                        this, R.array.weight_units, R.layout.spinner_item
                );
                break;
            case "Temperature":
                unitsAdapter = ArrayAdapter.createFromResource(
                        this, R.array.temperature_units, R.layout.spinner_item
                );
                break;
            default:
                unitsAdapter = ArrayAdapter.createFromResource(
                        this, R.array.length_units, R.layout.spinner_item
                );
                break;
        }
        unitsAdapter.setDropDownViewResource(R.layout.spinner_item);
        sourceUnitSpinner.setAdapter(unitsAdapter);
        destUnitSpinner.setAdapter(unitsAdapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }

    /**
     * performConversion:
     *  Uses a base-unit approach for each category:
     *  - Length: base = meters
     *  - Weight: base = grams
     *  - Temperature: base = Celsius
     */
    private double performConversion(String category, String source, String dest, double value) {
        switch (category) {
            case "Length":
                double inMeters = lengthToMeters(source, value);
                return metersToLength(dest, inMeters);
            case "Weight":
                double inGrams = weightToGrams(source, value);
                return gramsToWeight(dest, inGrams);
            case "Temperature":
                double inCelsius = toCelsius(source, value);
                return fromCelsius(dest, inCelsius);
            default:
                return 0;
        }
    }

    // -------------------- LENGTH HELPERS (base = meters) --------------------
    private double lengthToMeters(String unit, double val) {
        switch (unit) {
            case "inch": return val * 0.0254;
            case "foot": return val * 0.3048;
            case "yard": return val * 0.9144;
            case "cm":   return val * 0.01;
            case "km":   return val * 1000.0;
            case "mile": return val * 1609.34;
            default:     return 0;
        }
    }
    private double metersToLength(String unit, double meters) {
        switch (unit) {
            case "inch": return meters / 0.0254;
            case "foot": return meters / 0.3048;
            case "yard": return meters / 0.9144;
            case "cm":   return meters / 0.01;
            case "km":   return meters / 1000.0;
            case "mile": return meters / 1609.34;
            default:     return 0;
        }
    }

    // -------------------- WEIGHT HELPERS (base = grams) --------------------
    private double weightToGrams(String unit, double val) {
        switch (unit) {
            case "pound": return val * 453.592;
            case "ounce": return val * 28.3495;
            case "kg":    return val * 1000.0;
            case "g":     return val;
            case "ton":   return val * 907185.0; // short ton
            default:      return 0;
        }
    }
    private double gramsToWeight(String unit, double grams) {
        switch (unit) {
            case "pound": return grams / 453.592;
            case "ounce": return grams / 28.3495;
            case "kg":    return grams / 1000.0;
            case "g":     return grams;
            case "ton":   return grams / 907185.0;
            default:      return 0;
        }
    }

    // -------------------- TEMPERATURE HELPERS (base = Celsius) --------------------
    private double toCelsius(String unit, double val) {
        switch (unit) {
            case "°C": return val;
            case "°F": return (val - 32.0) / 1.8;
            case "K":  return val - 273.15;
            default:   return 0;
        }
    }
    private double fromCelsius(String unit, double celsiusVal) {
        switch (unit) {
            case "°C": return celsiusVal;
            case "°F": return (celsiusVal * 1.8) + 32.0;
            case "K":  return celsiusVal + 273.15;
            default:   return 0;
        }
    }
}
