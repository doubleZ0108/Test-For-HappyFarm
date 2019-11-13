package com.tester.DesignPatternTest;

import com.farm.FarmManager;
import com.shop.employee.*;
import com.shop.repository.RepositoryProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: Test-For-HappyFarm
 * @description: Add modified test this group's command pattern
 * @author: Zijian Zhang
 * @create: 2019/11/12
 **/
public class CommandTest {
  public static void main(String[] args) throws ClassNotFoundException {
     /**
       * @description: do some seeding first, then do some harvesting {corn, potato, wheat}
       *
       * @param args :
       *
       * @return : void
       **/
    System.out.println("—————————————-------------------------------------———— Test[Abstract Factory]Pattern —————————————-------------------------------------————");
    System.out.println("RepositoryProxy : Instance() :  Get an instance of the repositoryProxy.");
    System.out.println("RepositoryProxy : add() :  Add some seed into the repository.");
    System.out.println("FarmManager : getInstance() :  Get the farm manager as an singleton.");
    System.out.println("FarmManager : seeding() :  Let the farm manager to plan some seed into the farm.");
    System.out.println("FarmManager : giveFertilizer() :  Let the farm manager to give some fertilizer into the farm.");
    System.out.println("FarmManager : harvest() :  Let the farm manager harvest from the farm.");
    RepositoryProxy.Instance().add(CornSeed.class, 100);
    RepositoryProxy.Instance().add(PotatoSeed.class, 100);
    RepositoryProxy.Instance().add(WheatSeed.class, 100);
    RepositoryProxy.Instance().add(ChemicalFertilizer.class, 100);
    FarmManager farmManager = FarmManager.getInstance();
    String[] seedList = new String[]{"Corn", "Potato","Wheat"};
    Scanner scanner = new Scanner(System.in);
    int[] matureCount = {6,5,4};
    for (int i =0;i<seedList.length;i++) {
      System.out.println("Where do you want to plan " + seedList[i] +"?");
      String indexStr = scanner.nextLine();
      int index;
      try {
        index = Integer.parseInt(indexStr);
      }catch (NumberFormatException e){
        index = 0;
      }
      // This group is good at using Class object, we have to learn from them.
      farmManager.seeding(Class.forName("com.shop.employee."+seedList[i]+"Seed"),index);
      System.out.println("Now you have to give it some fertilizer. Press ENTER to do so!");
      int fertilizerCount = 0;
      do {
        System.out.println("There is " + fertilizerCount+" fertilizer currently. Add more by press enter!");
        scanner.nextLine();
        farmManager.giveFertilizer(index,ChemicalFertilizer.class);
        fertilizerCount++;
      }while (fertilizerCount<matureCount[i]);
      System.out.println("Now it is time to harvest!");
      farmManager.harvest(index);
    }
    System.out.println("—————————————---------------------------------------------- End ————------—————————-------------------------------------————");
  }
}
