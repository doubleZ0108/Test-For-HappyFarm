package com.tester.DesignPatternTest;

import com.processing.FarmProcessingFactory;
import com.processing.InitialEnvironment;
import com.processing.MachineDisplayVisitor;
import com.processing.PastureProcessingFactory;

/**
 * @program: Test-For-HappyFarm
 * @description: Add modified test for visitor pattern
 * @author: Group for testing HappyFarm
 * @create: 2019/11/13
 **/
public class VisitorTest {
    static public void main(String[] args){
        System.out.println("—————————————-------------------------------------———— Test[Visitor]Pattern —————————————-------------------------------------————");
        System.out.println("Machine : setState() :  Set an the state of this machine.");
        System.out.println("Machine : accept() :  Accept the visit of a visitor and function accordingly.");
        System.out.println("");

        FarmProcessingFactory farmProcessingFactory = new FarmProcessingFactory();
        PastureProcessingFactory pastureProcessingFactory = new PastureProcessingFactory();
        for(int i = 0;i<15;i++) {
            farmProcessingFactory.addMachine();
            pastureProcessingFactory.addMachine();
        }
        farmProcessingFactory.setEnvironment(new InitialEnvironment(15, 15));
        farmProcessingFactory.handle();
        pastureProcessingFactory.setEnvironment(new InitialEnvironment(15, 15));
        pastureProcessingFactory.handle();

        System.out.println("No.0 Machine in FarmProcessingFactory is damaged");
        farmProcessingFactory.machines.get(0).setState(1);
        farmProcessingFactory.machines.get(0).accept(new MachineDisplayVisitor());
        System.out.println("No.13 Machine in PastureProcessingFactory is damaged");
        pastureProcessingFactory.machines.get(13).setState(1);
        pastureProcessingFactory.machines.get(13).accept(new MachineDisplayVisitor());
        System.out.println("—————————————---------------------------------------------- End ————------—————————-------------------------------------————");
    }
}