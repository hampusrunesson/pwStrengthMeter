package com.example.hampusrunesson.pwstrengthmeter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hampusrunesson on 11/12/17.
 */

/**
 * This class builds the component and use PwCalculator to
 * calculate the strength of the users password
 */
public class pwStrength extends LinearLayout {

    //the field where the user inputs its password to check the strength of
    private EditText passWordText;

    //the star bar that shows the quality of the password
    private RatingBar ratingBar;

    //the calculator that is used for calculation
    public PwCalculator pwCalc;

    //the textView that describes the password quality (in words and colors)
    private TextView ratingTitle;

    Context context;




    /**
     * The constructor of the component which is called by MainActivity to initialize the Password component
     * @param context
     * @param attrs
     */
    public pwStrength(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public void init()
    {
        pwCalc = new PwCalculator(8, 4);
        LinearLayout layout = (LinearLayout) inflate(context, R.layout.pwlayout, null);
        setOrientation(VERTICAL);
        ratingBar = layout.findViewById(R.id.pwProgress);
        ratingTitle = layout.findViewById(R.id.ratingText);
        passWordText = layout.findViewById(R.id.pwinput);
        addView(layout);

        passWordText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {

                String tempPw = editable.toString();
                ratingBar.setRating(pwCalc.judge(pwCalc.score(tempPw)));
                ratingTitle.setTextColor(pwCalc.getColor());
                ratingTitle.setText(pwCalc.getComment());


            }
        });
    }

    /**
     * if you want to change the algorithm in any way that is being used to
     * compute the qualilty of the password you can call this method with your
     * own implementation of our calculator
     * @param pwCalc the calculator that the user has initialized
     */
    public void setAlgorithm(PwCalculator pwCalc)
    {
        this.pwCalc = pwCalc;
    }
}
