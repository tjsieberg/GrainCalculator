package com.example.graincalculator;

import java.text.NumberFormat;
import java.text.ParseException;

import android.widget.Spinner;
import android.widget.TextView;

class Utils {
    public static double GetDouble(TextView textView) {
        return GetDouble(textView, 0);
    }

    public static double GetDouble(TextView textView, double defaultValue) {

        if (textView == null)
            return defaultValue;
        else
        {
            try {
                String stringValue =  textView.getText().toString();
                if (stringValue.length() > 0)
                    return Double.parseDouble(stringValue);
                else {
                    if (textView.getHint() == null)
                        return defaultValue;

                    stringValue = textView.getHint().toString();
                    if (stringValue.length() > 0)
                        return Double.parseDouble(stringValue);
                    else
                        return defaultValue;
                }
            } catch (NumberFormatException e) {
                return defaultValue;
            }

        }
    }

    public static double GetFeet(TextView textView, Spinner unitsSpinner) {

        double value = GetDouble(textView);
        if (unitsSpinner.getSelectedItem().toString().equals("Inches")) {
            return value / 12;
        } else if (unitsSpinner.getSelectedItem().toString().equals("Meters")) {
            return value * 3.28084;
        }
        return value;
    }

    public static double ConvertFeetTo(double feet, Spinner unitsSpinner) {

        if (unitsSpinner.getSelectedItem().toString().equals("Inches")) {
            return feet * 12;
        } else if (unitsSpinner.getSelectedItem().toString().equals("Meters")) {
            return feet / 3.28084;
        }
        return feet;
    }

    public static double Round(double value, int precision) {
        int precisionMultiplier = (int) Math.pow(10, precision);
        return (double)Math.round(value * precisionMultiplier) / precisionMultiplier;
    }

    public static String FormatNumber(String value) {
        if (value == null || value.length() == 0)
            return value;
        NumberFormat format = NumberFormat.getInstance();
        Number number;
        try {
            number = format.parse(value);
        } catch (ParseException e) {
            number = 0;
            e.printStackTrace();
        }
        return FormatNumber(number.doubleValue());
    }

    public static String FormatNumber(Double value) {
        if (value == null)
            return null;
        NumberFormat formatter = NumberFormat.getInstance();
        return formatter.format(value);
    }
}
