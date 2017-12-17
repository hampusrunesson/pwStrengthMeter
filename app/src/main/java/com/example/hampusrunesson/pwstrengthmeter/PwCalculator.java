package com.example.hampusrunesson.pwstrengthmeter;

import android.graphics.Color;

import java.util.ArrayList;

/**
 * Created by hampusrunesson on 12/12/17.
 */


/**
 * This class calculates the score of the password and return
 * the right rating of the score
 */
public class PwCalculator implements pwInterface {

    private int passwordRequirementLength;
    private int minPwLength;
    private pwInterface pw;

    //an arraylist that contains the words that a password is not allowed to contain
    private ArrayList<String> wordComparator = new ArrayList<>();

    private int color;
    private String comment;

    /**
     * The contructor of the calculator
     * @param passwordRequirementLength an int that set the required length of the password to get good score
     * @param minPwLength minimum length of password to get a valid password
     */
    public PwCalculator(int passwordRequirementLength, int minPwLength) {
        this.passwordRequirementLength = passwordRequirementLength;
        this.minPwLength = minPwLength;
        setWordComparator();
    }


    /**
     * This method calculate the score of the password that the user has typed in by checking multiple criterion
     * @param pw the password that the user type in
     * @return the score
     */
    @Override
    public int score(String pw) {

        int score = 0;
        //wordComparator.add(pw);

        if(pw.length() >= minPwLength) {

            if (pw.length() >= passwordRequirementLength) {
                score += 2;
            } else if (pw.length() >= passwordRequirementLength / 2) {
                score += 1;
            }
            if (!pw.equals(pw.toLowerCase())) {
                score += 1;
            }
            if (!pw.equals(pw.toUpperCase())) {
                score += 1;
            }
            if (!pw.matches("[A-Za-z0-9 ]*")) {
                score += 2;
            }
            if (pw.matches(".*\\d+.*")) {
                score += 1;
            }
            for (String word : wordComparator) {
                if (pw.toLowerCase().contains(word)) {
                    score -= 1;
                }
            }
        }
        else
        {
            setColor(Color.RED);
            setComment("Lösenordet måste vara minst 4 tecken långt...");
        }

        return score;
    }


    /**
     * Calculates the rating based on what score the password got from the score method and
     * set number of start, writes out a sentence based on the how good the password is and
     * sets the sentence to a color based on how good the password is.
     * @param score the scored that the password got from the score metod
     * @return how good the password is, in terms of number of stars
     */
    @Override
    public int judge(int score) {

        int rating = 0;
        if(score <= 7) {
            switch (score) {
                case 1:
                    rating = 1;
                    setColor(Color.RED);
                    setComment("Svagt lösenord...");
                    break;
                case 2:
                    rating = 2;
                    setColor(Color.RED);
                    setComment("Svagt lösenord...");
                    break;
                case 3:
                    rating = 3;
                    setColor(Color.YELLOW);
                    setComment("Okej lösenord...");
                    break;
                case 4:
                    rating = 4;
                    setColor(Color.BLUE);
                    setComment("Helt okej lösenord...");
                    break;
                case 5:
                    rating = 5;
                    setColor(Color.BLUE);
                    setComment("Ganska bra lösenord...");
                    break;
                case 6:
                    rating = 6;
                    setColor(Color.GREEN);
                    setComment("Bra lösenord!");
                    break;
                case 7:
                    rating = 7;
                    setColor(Color.GREEN);
                    setComment("Utmärkt lösenord!");
                    break;
            }
        }
        else
        {
            rating = 7;
        }
        return rating;
    }

    /**
     * Adds some common passwords to the ArrayList "wordComparator"
     * which contains some characters/numbers that the user should
     * not contain in the password
     */
    public void setWordComparator()
    {
        wordComparator.add("hej");
        wordComparator.add("qwerty");
        wordComparator.add("katt");
        wordComparator.add("hund");
        wordComparator.add("jag");
        wordComparator.add("lösenord");
        wordComparator.add("mitt");
        wordComparator.add("12345");
        wordComparator.add("123");
        wordComparator.add("000");
    }

    public int getColor() {

        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
