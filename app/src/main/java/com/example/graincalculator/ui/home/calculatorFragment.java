package com.example.graincalculator.ui.home;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.graincalculator.Grains;
import com.example.graincalculator.Calculator;
import com.example.graincalculator.MainActivity;
import com.example.graincalculator.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;


public class calculatorFragment extends Fragment implements AdapterView.OnItemSelectedListener, TextWatcher {

    private HomeViewModel homeViewModel;
    public Spinner grainTypeSpinner;
    public Spinner diameterMeasurementSpinner;
    public Spinner wallHeightMeasurementsSpinner;
    public Spinner peakHeightMeasurementsSpinner;

    private EditText mDiameterText;
    private EditText mHeightText;
    private EditText mPeakHeightText;
    private EditText mMoistureText;
    private EditText mTestWeightText;
    private TextView mNetBushelsText;

    private Grains.GrainTypes mGrainTypeSelected;
    public FloatingActionButton mSaveButton;

    private boolean mCalculatePeakHeight = true;
    private float   mPeakHeightAdjustmentFactor = 1;
    private String  mDefaultUnitOfLength;
    private String  mVolumeUnit = "Bushels";

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.calculator_fragment, container, false);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        mDiameterText = root.findViewById(R.id.diameterInput);
        mHeightText = root.findViewById(R.id.wallHeightInput);
        mPeakHeightText = root.findViewById(R.id.peakHeightInput);
        mMoistureText = root.findViewById(R.id.moistureInput);
        mTestWeightText = root.findViewById(R.id.testWeightInput);
        mNetBushelsText = root.findViewById(R.id.bushelsOutput);
        mSaveButton = root.findViewById(R.id.saveButton);
        grainTypeSpinner = root.findViewById(R.id.grainSpinner);
        diameterMeasurementSpinner = root.findViewById(R.id.diameterMeasurementSpinner);
        wallHeightMeasurementsSpinner = root.findViewById(R.id.wallHeightMeasurementsSpinner);
        peakHeightMeasurementsSpinner = root.findViewById(R.id.peakHeightMeasurementsSpinner);
        displaySpinners();
        EnableListeners();

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return root;
    }

    public void displaySpinners(){
        String[] grainTypes = {"Corn", "Soybeans", "Wheat", "Oats", "Barley"};
        String[] measurementUnits = {"Feet", "Inches", "Meter"};

        ArrayAdapter<String> grainArrayAdapter = new ArrayAdapter<String>(this.getActivity(), R.layout.spinner_item, grainTypes);
        grainArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        grainTypeSpinner.setAdapter(grainArrayAdapter);

        ArrayAdapter<String> measurementsArrayAdapter = new ArrayAdapter<String>(this.getActivity(), R.layout.spinner_item, measurementUnits);
        measurementsArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        diameterMeasurementSpinner.setAdapter(measurementsArrayAdapter);
        wallHeightMeasurementsSpinner.setAdapter(measurementsArrayAdapter);
        peakHeightMeasurementsSpinner.setAdapter(measurementsArrayAdapter);
    }

    public void EnableListeners() {
//        mDiameterText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                mNetBushelsText.setText("area");
//            }
//        });
        mDiameterText.addTextChangedListener(this);
        mHeightText.addTextChangedListener(this);
        mPeakHeightText.addTextChangedListener(this);
        mMoistureText.addTextChangedListener(this);
        mTestWeightText.addTextChangedListener(this);

        grainTypeSpinner.setOnItemSelectedListener(this);
        diameterMeasurementSpinner.setOnItemSelectedListener(this);
        wallHeightMeasurementsSpinner.setOnItemSelectedListener(this);
        peakHeightMeasurementsSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }


}