package com.example.nightnagisa.mycalculator;

import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nagisa on 2014/11/28.
 */
public class Equal {
    //该类不可被实例化
    private Equal(){

    }
    //创建equal方法获取运算式的结果
    public static String equal(String input,double resultContinues) {
        //使用两个动态数组动态储存数字及运算符
        ArrayList<Double> listNum = new ArrayList<Double>();
        ArrayList<Character> listCommand = new ArrayList<Character>();
        boolean flagCommandCompute;//标记检索位置的字符为运算符
        int mark = 0;//标记数字起始处
        for (int search = 0; search < input.length(); search++) {
            flagCommandCompute = true;
            //检验当前字符是否为数字
            for (int number = 0; number < 10; number++) {
                if (String.valueOf(input.charAt(search)).equals(String.valueOf(number)) || String.valueOf(input.charAt(search)).equals(String.valueOf('.'))) {
                    flagCommandCompute = false;
                    break;
                }
            }
            //因将减号当作负号处理，若计算式末端之后出现减号则忽略
            if (search == input.length() - 1 && String.valueOf(input.charAt(search)).equals(String.valueOf('-'))) {
                flagCommandCompute = false;
                input = input.substring(0, input.length() - 1);
            }
            //若当前字符非数字，则强制转换两个运算符之间的字符串为浮点数，即获取被计算数
            if (flagCommandCompute) {
                if (mark == search) {//若标记数字开始的位置不为数字，即为负号，则不处理
                    
                } else {
                    listNum.add(Double.parseDouble(input.substring(mark, search)));//强制转化从标记为数字开始处至检索处的字符为double数据并存入动态数组
                    listCommand.add(input.charAt(search));//将运算符存入动态数组
                    mark = search + 1;//标记数字起始点为检索处下一个字符
                }
            }
        }
        if (mark != input.length()) {//获取计算式末端的最后一个计算数，若标记等于计算式字符串长度则表示计算式最末为计算符，将其忽略
            listNum.add(Double.parseDouble(input.substring(mark, input.length())));
        }
        //声明静态数组Copy动态数组中的元素，便于计算
        double[] num = new double[listNum.size()];
        for (int copy = 0; copy < listNum.size(); copy++) {
            num[copy] = listNum.get(copy);
        }
        Character[] command = new Character[listCommand.size()];
        for (int copy = 0; copy < listCommand.size(); copy++) {
            command[copy] = listCommand.get(copy);
        }
        //连加（减/乘）策略
        if (num.length == command.length && command.length == 1) {
            if (command[0].equals('+')) {
                resultContinues = Compute.add(resultContinues, num[0]);
            } else if (command[0].equals('-')) {
                resultContinues = Compute.sub(resultContinues, num[0]);
            } else if (command[0].equals('*')) {
                if (resultContinues == 0) {
                    resultContinues = 1;
                }
                resultContinues = Compute.mul(resultContinues, num[0]);
            }
            num[0] = resultContinues;
        } else {//以计算数作为基准，调用Compute类中的方法进行精确计算，并忽略多出的运算符
            for (int search = 0; search < num.length - 1; search++) {
                if (command[search].equals('+')) {
                    num[search + 1] = Compute.add(num[search], num[search + 1]);
                } else if (command[search].equals('-')) {
                    num[search + 1] = Compute.sub(num[search], num[search + 1]);
                } else if (command[search].equals('*')) {
                    num[search + 1] = Compute.mul(num[search], num[search + 1]);
                } else if (command[search].equals('/')) {
                    num[search + 1] = Compute.div(num[search], num[search + 1]);
                }
            }
        }
        //返回最终显示的结果
        String result;
        if (num[num.length - 1] % 1.0 == 0.0) {
            result = String.valueOf((long) num[num.length - 1]);
        } else {
            result = String.valueOf(num[num.length - 1]);
        }
        return result;
    }
}
