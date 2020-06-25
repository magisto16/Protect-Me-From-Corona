package com.example.protectmefromcorona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class healthDetail extends AppCompatActivity {

    private int positionCountry;
    TextView tvCountry, tvCases, tvRecovered, tvCritical, tvActive, tvTodayCases, tvTotalDeaths, tvTodayDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_detail);

        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position", 0);

//        getSupportActionBar().setTitle("Rincian dari "+health.countryModelsList.get(positionCountry).getCountry());
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvCountry = findViewById(R.id.tvCountry);
        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvTotalDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);

        tvCountry.setText(health.countryModelsList.get(positionCountry).getCountry());
        tvCases.setText(health.countryModelsList.get(positionCountry).getCases());
        tvRecovered.setText(health.countryModelsList.get(positionCountry).getRecovered());
        tvCritical.setText(health.countryModelsList.get(positionCountry).getCritical());
        tvActive.setText(health.countryModelsList.get(positionCountry).getActive());
        tvTodayCases.setText(health.countryModelsList.get(positionCountry).getTodayCases());
        tvTotalDeaths.setText(health.countryModelsList.get(positionCountry).getDeaths());
        tvTodayDeaths.setText(health.countryModelsList.get(positionCountry).getTodayDeaths());
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        if(item.getItemId() == android.R.id.home) {
//            finish();
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
