package com.example.bailey.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btncalulate;
    private EditText ettotalcost, ettaxpercentage, ettippercentage, etmealcost;
    private TextView tvtotalcost, tvtaxpercentage, tvtippercentage, tvmealcost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    @Override
    public void onClick(View v) {
        DecimalFormat precision = new DecimalFormat("0.00");
        String smealcost = etmealcost.getText().toString();
        String stippercentage = ettippercentage.getText().toString();
        String staxpercentage = ettaxpercentage.getText().toString();

        double valmealcost = Double.parseDouble(smealcost);
        double valtippercentage = Double.parseDouble(stippercentage);
        double valtaxpercentage = Double.parseDouble(staxpercentage);
        switch (v.getId()) {
            case R.id.btnCalculate:
               double taxed =(valmealcost + (valmealcost*(valtaxpercentage/100))); //111.69
                double tipped = (taxed*(valtippercentage/100));
                valmealcost = tipped + taxed;
                String formattedmeal = precision.format(valmealcost);
                ettotalcost.setText(formattedmeal);
        }
    }


    private void init() {
        btncalulate = (Button)findViewById(R.id.btnCalculate);
        ettotalcost = (EditText)findViewById(R.id.etTotalCost);
        ettaxpercentage = (EditText)findViewById(R.id.etTaxPercentage);
        ettippercentage = (EditText)findViewById(R.id.etTipPercentage);
        etmealcost = (EditText)findViewById(R.id.etMealCost);
        tvtotalcost = (TextView)findViewById(R.id.tvTotalCost);
        tvtaxpercentage = (TextView)findViewById(R.id.tvTaxPercentage);
        tvtippercentage = (TextView)findViewById(R.id.tvTaxPercentage);
        tvmealcost = (TextView)findViewById(R.id.tvMealCost);

        btncalulate.setOnClickListener(this);


    }
    }

