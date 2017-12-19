package com.example.hampusrunesson.pwstrengthmeter;

/**
 * Created by hampusrunesson on 12/12/17.
 */

public class Tester extends PwCalculator {

    public Tester(int passwordRequirementLength, int minPwLength) {
        super(passwordRequirementLength, minPwLength);


    }

    @Override
    public int score(String pw) {

        int score = 0;

        if(pw.contains("..."))
        {
            score = 2;
        }

        return super.score(pw) + score;
    }
}
