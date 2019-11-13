package com.tester.DesignPatternTest;

import com.shop.employee.*;
import com.shop.repository.RepositoryProxy;

import java.text.MessageFormat;
import java.util.*;

/**
 * @program: Test-For-HappyFarm
 * @description: Add modified test this group's builder pattern
 * @author: Group for testing HappyFarm
 * @create: 2019/11/12
 **/
public class BuilderTest {
  public static void main(String[] args){
     /**
       * @description: let the user to choose what to buy and how many of each type to buy
       *
       * @param args :
       *
       * @return : void
       **/
    System.out.println("—————————————-------------------------------------———— Test[Abstract Factory]Pattern —————————————-------------------------------------————");
    System.out.println("RepositoryProxy : Instance() :  Get a new instance of repositoryProxy.");
    System.out.println("RepositoryProxy : add() :  Add some plants into the repository.");
    System.out.println("Employee : createBuyOrder() :  Create the order for the user.");

    System.out.println("");
    System.out.println("how many of the following type of plant do you want?");
    Map<String,Class> orderMap = new HashMap<>();
    orderMap.put("Egg",Egg.class);
    orderMap.put("Eggcake", EggCake.class);
    orderMap.put("Potato",Potato.class);
    orderMap.put("Corn",Corn.class);
    orderMap.put("Wheat",Wheat.class);
    Scanner scanner = new Scanner(System.in);
    Map<Class,Integer> orderDetailMap = new HashMap<>();
    for (Map.Entry<String,Class> entry:orderMap.entrySet()){
      // ask how many plant does the customer want one by one
      System.out.println(MessageFormat.format("How many {0} do you want? " +
        "(enter 0 if you don't want it, negative numbers are considered 0)",entry.getKey()));
      String number = scanner.nextLine();
      int orderNumber;
      try {
        orderNumber = Integer.parseInt(number);
      }catch (NumberFormatException error){
        orderNumber = 0;
      }
      if(orderNumber<0) orderNumber = 0;
      if(orderNumber>0){
        RepositoryProxy.Instance().add(entry.getValue(),orderNumber);
        orderDetailMap.put(entry.getValue(),orderNumber);
      }
    }
    Employee.createBuyOrder(orderDetailMap);
    System.out.println("—————————————---------------------------------------------- End ————------—————————-------------------------------------————");
  }
}
