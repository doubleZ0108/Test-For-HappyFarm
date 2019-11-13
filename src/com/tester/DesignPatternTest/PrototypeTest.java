package com.tester.DesignPatternTest;

import com.processing.*;

/**
 * @program: Test-For-HappyFarm
 * @description: Add modified test propotype pattern
 * @author: Xuefei Lv
 * @create: 2019/11/13
 **/

public class PrototypeTest {
    public static void main(String[] args) {
        System.out.println("—————————————-------------------------------------———— Test[Prototype]Pattern —————————————-------------------------------------————");
        System.out.println("FarmProcessingFactory : addMachine() : Creating a machine");
        System.out.println("FarmProcessingFactory : getMachinesState() : Check the status of all machines, and if a machine is damaged, destroy it and clone another machine");
        System.out.println("PastureProcessingFactory : addMachine() : Creating a machine\"");
        System.out.println("PastureProcessingFactory : getMachinesState() : Check the status of all machines, and if a machine is damaged, destroy it and clone another machine");        System.out.println("");

        FarmProcessingFactory farmProcessingFactory = new FarmProcessingFactory();
        PastureProcessingFactory pastureProcessingFactory = new PastureProcessingFactory();
        for(int i = 0;i<10;i++) {
            farmProcessingFactory.addMachine();
            pastureProcessingFactory.addMachine();
        }
        System.out.println("Check the State of FarmProcessingFactory's Machines:");
        farmProcessingFactory.getMachinesState();
        System.out.println("Check the State of PastureProcessingFactory's Machines:");
        pastureProcessingFactory.getMachinesState();
        System.out.println("—————————————---------------------------------------------- End ————------—————————-------------------------------------————");
    }
}
