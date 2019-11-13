package com.tester.DesignPatternTest;

import com.processing.*;

/**
 * @program: Test-For-HappyFarm
 * @description: test propotype pattern
 * @author: Xuefei Lv
 * @create: 2019/11/13
 **/

public class PrototypeTest {
    public static void main(String[] args) {
        FarmProcessingFactory farmProcessingFactory = new FarmProcessingFactory();
        PastureProcessingFactory pastureProcessingFactory = new PastureProcessingFactory();
        for(int i = 0;i<10;i++) {
            farmProcessingFactory.addMachine();
            pastureProcessingFactory.addMachine();
        }
        System.out.println("\n\n-------------Observer/Prototype Test-------------");
        System.out.println("Check the State of FarmProcessingFactory's Machines:");
        farmProcessingFactory.getMachinesState();
        System.out.println("Check the State of PastureProcessingFactory's Machines:");
        pastureProcessingFactory.getMachinesState();
    }
}
