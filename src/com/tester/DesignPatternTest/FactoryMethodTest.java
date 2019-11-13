package com.tester.DesignPatternTest;

import com.pasture.Cat;
import com.pasture.Chicken;
import com.pasture.Factory.AnimalFactory;
import com.pasture.Sheep;

/**
 * @program: Test-For-HappyFarm
 * @description: Add modified the test class for Factory Method
 * @author: Group for testing HappyFarm
 * @create: 2019/11/12
 **/
public class FactoryMethodTest {
    public static void main(String[] args){
        System.out.println("—————————————------------------------------———— Test[Factory Method]Pattern —————————————------------------------------————");
        System.out.println("AnimalFactory : run() :  Create a animal object according to the parameter");
        System.out.println("");


        AnimalFactory animalFactory = new AnimalFactory();
        if(animalFactory.run("Cat") instanceof Cat){
            System.out.println("AnimalFactory object can create Cat object");
        }else {
            System.out.println("AnimalFactory object can't create Cat object");
        }
        if(animalFactory.run("Sheep") instanceof Sheep){
            System.out.println("AnimalFactory object can create Sheep object");
        }else {
            System.out.println("AnimalFactory object can't create Cat object");
        }
        if(animalFactory.run("Chicken") instanceof Chicken){
            System.out.println("AnimalFactory object can create Chicken object");
        }else {
            System.out.println("AnimalFactory object can't create Cat object");
        }

        System.out.println("—————————————---------------------------------------------- End ————------—————————-------------------------------------————");
    }
}
