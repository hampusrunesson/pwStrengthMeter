package com.example.hampusrunesson.pwstrengthmeter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    pwStrength passWordStrengthMeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        passWordStrengthMeter = findViewById(R.id.strengthmeter);

        //A tester that uses the setAlgorithm-method to change the
        //algorithm for calculating the score of a password
        Tester tester = new Tester(4, 8);
        //passWordStrengthMeter.setAlgorithm(tester);
    }
}
