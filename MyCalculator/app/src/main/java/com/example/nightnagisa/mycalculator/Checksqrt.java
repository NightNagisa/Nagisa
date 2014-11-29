package com.example.nightnagisa.mycalculator;

/**
 * Created by Nagisa on 2014/11/28.
 */
public class Checksqrt {
    private Checksqrt(){

    }
    public static int checkSqrt(String input){
        int search;
        for (search = input.length() - 1; search >= 0; search--) {
            if (input.charAt(search)=='='){
                break;
            }
        }
        return search+1;
    }
}
