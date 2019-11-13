package com.tester.DesignPatternTest;

import com.processing.FarmProcessingFactory;
import com.processing.MachineDisplayVisitor;
import com.processing.PastureProcessingFactory;

/**
 * @program: Test-For-HappyFarm
 * @description:
 * @author: Yimo Liu
 * @create: 2019/11/13
 **/
public class VisitorTest {
    static public void main(String[] args){
        System.out.println("\n\n-------------Visitor Test-------------");

        FarmProcessingFactory farmProcessingFactory = new FarmProcessingFactory();
        PastureProcessingFactory pastureProcessingFactory = new PastureProcessingFactory();
        System.out.println("No.0 Machine in FarmProcessingFactory is damaged");
        farmProcessingFactory.machines.get(0).setState(1);
        farmProcessingFactory.machines.get(0).accept(new MachineDisplayVisitor());
        System.out.println("No.13 Machine in PastureProcessingFactory is damaged");
        pastureProcessingFactory.machines.get(13).setState(1);
        pastureProcessingFactory.machines.get(13).accept(new MachineDisplayVisitor());
    }
}