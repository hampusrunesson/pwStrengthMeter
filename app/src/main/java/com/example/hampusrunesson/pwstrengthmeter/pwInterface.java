package com.example.hampusrunesson.pwstrengthmeter;

/**
 * Created by hampusrunesson on 11/12/17.
 */

/**
 * Here you can put in requirements that the calculator needs to have
 */
public interface pwInterface {

    int score (String pw);

    int judge(int score);

    void setWordComparator();

}
