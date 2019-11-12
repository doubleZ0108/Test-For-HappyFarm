package com.tester.DesignPatternTest;

import com.pasture.Cat;
import com.pasture.Chicken;
import com.pasture.Factory.AnimalFactory;
import com.pasture.Sheep;

/**
 * @program: Test-For-HappyFarm
 * @description: The test class for Factory Method
 * @author: saturn
 * @create: 2019/11/12
 **/
public class FactoryMethodTest {
    public static void main(String[] args){
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
    }
}
