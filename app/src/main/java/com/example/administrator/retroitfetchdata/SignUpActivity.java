package com.example.administrator.retroitfetchdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrator.retroitfetchdata.network.country.CountryApiService;
import com.example.administrator.retroitfetchdata.network.country.Provience;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    CountryApiService countryApiService;
    Spinner gender;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gender = (Spinner) findViewById(R.id.gender);
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_list_item_1);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(genderAdapter);
        gender.setOnItemSelectedListener(this);

        countryApiService = new CountryApiService(this);
        countryApiService.loadCountries();
    }


    public void onCountryLoaded(final List<Country> countries) {
        final List<String> countryNames = new ArrayList<>();
        for (Country country : countries) {
            countryNames.add(country.countryName);
        }
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myadapter = new ArrayAdapter<>(SignUpActivity.this, android.R.layout.simple_list_item_1, countryNames);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myadapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = spinner.getSelectedItem();
                Toast.makeText(getApplicationContext(), Integer.toString(position + 1), Toast.LENGTH_LONG).show();
                countryApiService.loadProviences(countries.get(position).countryId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void onProvinceLoaded(List<Provience> proviences) {
        final List<String> provienceNames = new ArrayList<>();
        for (Provience provience : proviences) {
            provienceNames.add(provience.getProvienceName());
        }
        Spinner provinceSpinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> mySpinnerAdapter = new ArrayAdapter<>(SignUpActivity.this, android.R.layout.simple_list_item_1, provienceNames);
        mySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provinceSpinner.setAdapter(mySpinnerAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(SignUpActivity.this, Integer.toString(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}




