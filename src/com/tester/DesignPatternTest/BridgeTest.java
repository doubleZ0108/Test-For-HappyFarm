package com.tester.DesignPatternTest;

import com.pasture.Bridge.*;

/**
 * @program: Test-For-HappyFarm
 * @description: Add modified test for bridge pattern
 * @author: Group for testing HappyFarm
 * @create: 2019/11/13
 **/
public class BridgeTest {

    public static void main(String[] args) {

        System.out.println("—————————————-------------------------------------———— Test[Bridge]Pattern —————————————-------------------------------------————");
        System.out.println("AnimalYell : setYellTimes(YellTimes yellTimes) :  Set animal yell times.");
        System.out.println("AnimalYell : yell() :  Execute yell action.");
        System.out.println("");


        System.out.println("=== Create a cat:");
        AnimalYell catYell = new CatYell();
        System.out.println("=== Create yell three times:");
        YellTimes yellThreeTimes = new YellThreeTimes();
        System.out.println("=== Set cat yell times:");
        catYell.setYellTimes(yellThreeTimes);
        System.out.println("===Let the cat to yell 3 times..");
        catYell.yell();


        System.out.println("=== Create a sheep:");
        AnimalYell sheepYell = new SheepYell();
        System.out.println("=== Create yell two times:");
        YellTimes yellTwiceTimes = new YellTwiceTimes();
        System.out.println("=== Set cat yell times:");
        sheepYell.setYellTimes(yellTwiceTimes);
        System.out.println("===Let the sheep to yell 2 times..");
        sheepYell.yell();

        System.out.println("—————————————---------------------------------------------- End ————------—————————-------------------------------------————");


    }
}