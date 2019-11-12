package com.tester.DesignPatternTest;

import com.farm.FarmManager;
import com.shop.store.SingleStore;

/**
 * @program: Test-For-HappyFarm
 * @description: To test this group's singleton pattern
 * @author: Zijian Zhang
 * @create: 2019/11/12
 **/
public class SingletonTest {
  public static void main(String[] args){
     /**
       * @description: Just call some constructor and see whether the object is constructed only once
       *
       * @param args :
       *
       * @return : void
       **/

    System.out.println("First we get 2 instances of farmManager");
    FarmManager farmManager = FarmManager.getInstance();
    FarmManager farmManager1 = FarmManager.getInstance();
    System.out.println("Now let's compare whether the address is identical");
    boolean farmTest = farmManager==farmManager1;
    System.out.println(farmTest);
    System.out.println("Second, let's test the singleton of singleStore");
    SingleStore singleStore = SingleStore.getSingleStore();
    SingleStore singleStore1 = SingleStore.getSingleStore();
    System.out.println("Now let's compare whether the address is identical");
    boolean storeTest = singleStore==singleStore1;
    System.out.println(storeTest);
    if(farmTest && storeTest){
      System.out.println("Singleton test passed!");
    }else {
      System.out.println("Singleton test failed!");
    }
  }
}
