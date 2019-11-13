package com.tester.DesignPatternTest;

import com.pasture.Bridge.*;

/**
 * @program: Test-For-HappyFarm
 * @description: Add modified test for bridge pattern
 * @author: Yu Liu
 * @create: 2019/11/13
 **/
public class BridgeTest {

    public static void main(String[] args) {

        System.out.println("----------  Bridge Test----------");
        System.out.println("Let the cat to yell 3 times..");
        AnimalYell catYell = new CatYell();
        YellTimes yellThreeTimes = new YellThreeTimes();
        catYell.setYellTimes(yellThreeTimes);
        catYell.yell();

        System.out.println("Let the sheep to yell 2 times..");
        AnimalYell sheepYell = new SheepYell();
        YellTimes yellTwiceTimes = new YellTwiceTimes();
        sheepYell.setYellTimes(yellTwiceTimes);
        sheepYell.yell();

    }
}