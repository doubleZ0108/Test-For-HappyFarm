package com.tester.DesignPatternTest;

import com.processing.FarmProcessingFactory;
import com.processing.PastureProcessingFactory;

/**
 * @program: Test-For-HappyFarm
 * @description: To test this goup's template method
 * @author: Zijian Zhang
 * @create: 2019/11/13
 **/
public class TemplateMethodTest {
  public static void main(String[] args){
    System.out.println("—————————————-------------------------------------———— Test[Abstract Factory]Pattern —————————————-------------------------------------————");
    System.out.println("FarmProcessingFactory : execute() :  Use the template to generate some wheat.");
    System.out.println("PastureProcessingFactory : execute() :  Use the template to generate some egg.");
    System.out.println("Let's generate 2 factory.");
    FarmProcessingFactory farmProcessingFactory = new FarmProcessingFactory();
    PastureProcessingFactory pastureProcessingFactory = new PastureProcessingFactory();
    System.out.println("Let's get some plants.");
    farmProcessingFactory.execute();
    farmProcessingFactory.execute();
    farmProcessingFactory.execute();
    pastureProcessingFactory.execute();
    System.out.println("—————————————---------------------------------------------- End ————------—————————-------------------------------------————");
  }
}
