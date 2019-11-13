package com.tester.DesignPatternTest;

import com.pasture.Interpreter.Expression;
import com.pasture.Interpreter.Interpreter;

/**
 * @program: Test-For-HappyFarm
 * @description: Test the interpreter pattern.
 * @author: Yifan Ye
 * @create: 2019/11/11
 **/
public class InterpreterTest
{
    public static void main(String[] args)
    {
        System.out.println("\n\n-------------Interpreter Test-------------");
        Expression oneLivestock = Interpreter.getLivestockExpression();
        Expression allLivestock = Interpreter.getAllLivestockExpression();

        System.out.println("Chicken is livestock? " + oneLivestock.interpret("Chicken"));
        System.out.println("Sheep and chicken are all the livestock in com.pasture? "
                + allLivestock.interpret("Sheep Chicken"));

    }
}