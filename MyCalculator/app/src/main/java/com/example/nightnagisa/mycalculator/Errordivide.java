package com.example.nightnagisa.mycalculator;

/**
 * Created by Nagisa on 2014/11/27.
 */
public class Errordivide {
    private Errordivide(){

    }
    public static boolean errorDivide(String string){
        //被除数为零时发出错误提示
        if (string.length()>=2&&string.charAt(string.length()-1)=='0'&&string.charAt(string.length()-2)=='/'||string.length()>=3&&string.charAt(string.length()-1)=='.'&&string.charAt(string.length()-2)=='0'&&string.charAt(string.length()-3)=='/') {
            return true;
        }else {
            return false;
        }
    }
}
