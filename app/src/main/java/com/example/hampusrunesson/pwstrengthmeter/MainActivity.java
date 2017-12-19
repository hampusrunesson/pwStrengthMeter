package com.example.hampusrunesson.pwstrengthmeter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    pwStrength passWordStrengthMeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        passWordStrengthMeter = findViewById(R.id.strengthmeter);

        //A tester that uses the setAlgorithm-method to change the
        //algorithm for calculating the score of a password
        Tester tester = new Tester(8, 4);
        passWordStrengthMeter.setAlgorithm(tester);

        passWordStrengthMeter.pwCalc.setPwStrength(new PwListener() {
            @Override
            public int onPwStateChange(int state) {
                if(state == passWordStrengthMeter.pwCalc.STRONG_PW)
                {
                    Toast message = Toast.makeText(MainActivity.this, "Gratulerar, det lösenord är mycket starkt!",Toast.LENGTH_LONG);
                    message.setGravity(Gravity.CENTER,0,0);
                    message.show();
                }
                return 0;
            }
        });
    }
}
