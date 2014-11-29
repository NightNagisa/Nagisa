package com.example.nightnagisa.mycalculator;

import java.math.BigDecimal;

/**
 * Created by Nagisa on 2014/11/27.
 */
public class Compute {
    private static final int DEF_DIV_SCALE = 10;
    private Compute(){

    }
    /**
     * 提供精确的加法运算。
     *
     * @param number1 被加数
     * @param number2 加数
     * @return 两个参数的和
     */
    public static double add(double number1, double number2) {
        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(number1));
        BigDecimal bigDecimal2 = new BigDecimal(Double.toString(number2));
        return bigDecimal1.add(bigDecimal2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param number1 被减数
     * @param number2 减数
     * @return 两个参数的差
     */
    public static double sub(double number1, double number2) {
        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(number1));
        BigDecimal bigDecimal2 = new BigDecimal(Double.toString(number2));
        return bigDecimal1.subtract(bigDecimal2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param number1 被乘数
     * @param number2 乘数
     * @return 两个参数的积
     */
    public static double mul(double number1, double number2) {
        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(number1));
        BigDecimal bigDecimal2 = new BigDecimal(Double.toString(number2));
        return bigDecimal1.multiply(bigDecimal2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
     *
     * @param number1 被除数
     * @param number2 除数
     * @return 两个参数的商
     */
    public static double div(double number1,double number2){
        return div(number1,number2,DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     * @param number1 被除数
     * @param number2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double number1,double number2,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(number1));
        BigDecimal bigDecimal2 = new BigDecimal(Double.toString(number2));
        return bigDecimal1.divide(bigDecimal2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     * @param number 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double number,int scale){

        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(number));
        BigDecimal bigDecimal2 = new BigDecimal("1");
        return bigDecimal1.divide(bigDecimal2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}