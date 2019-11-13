package com.tester.DesignPatternTest;

import com.processing.FarmProcessingFactory;
import com.processing.InitialEnvironment;
import com.processing.PastureProcessingFactory;

/**
 * @program: 10
 * @description: Add modified test for AbstractFactory.
 * @author: Zhe Zhang
 * @create: 2019/11/11
 **/
public class AbstractFactoryTest {
    public static void main(String[] args) {
        System.out.println("—————————————-------------------------------------———— Test[Abstract Factory]Pattern —————————————-------------------------------------————");
        System.out.println("FarmProcessingFactory : addMachine() :  Add a machine for farm processing factory which inherit from abstract processing factory.");
        System.out.println("FarmProcessingFactory : getMachinesState() :  Output state of all machines from processing factory.");
        System.out.println("FarmProcessingFactory : setEnvironment() :  Set environment for farm processing factory.");
        System.out.println("PastureProcessingFactory : addMachine() :  Add a machine for pasture processing factory which inherit from abstract processing factory.");
        System.out.println("PastureProcessingFactory : getMachinesState() :  Output state of all machines pasture processing factory..");
        System.out.println("PastureProcessingFactory : setEnvironment() :  Set environment for pasture processing factory.");
        System.out.println("");

        System.out.println("=== Create a farm processing factory:");
        FarmProcessingFactory farmProcessingFactory = new FarmProcessingFactory();
        System.out.println("=== Create a pasture processing factory:");
        PastureProcessingFactory pastureProcessingFactory = new PastureProcessingFactory();
        System.out.println("");
        System.out.println("=== Add machines for each processing factory:");
        for(int i = 0;i<15;i++) {
            farmProcessingFactory.addMachine();
            pastureProcessingFactory.addMachine();
        }

        System.out.println("");
        System.out.println("=== Get machines state from farm processing factory:");
        farmProcessingFactory.getMachinesState();
        System.out.println("=== Get machines state from pasture processing factory:");
        pastureProcessingFactory.getMachinesState();

        System.out.println("");
        System.out.println("=== Set environment for farm processing factory:");
        farmProcessingFactory.setEnvironment(new InitialEnvironment(15, 15));
        farmProcessingFactory.handle();
        System.out.println("=== Set environment for pasture processing factory:");
        pastureProcessingFactory.setEnvironment(new InitialEnvironment(15, 15));
        pastureProcessingFactory.handle();
    }
}
