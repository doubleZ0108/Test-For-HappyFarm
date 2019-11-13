package com.tester.DesignPatternTest;

import com.pasture.Adapter.GrassEat;
import com.pasture.Animal;
import com.pasture.Factory.AnimalFactory;

/**
 * @program: Test-For-HappyFarm
 * @description: Add modified test for adapter pattern
 * @author: Group for testing HappyFarm
 * @create: 2019/11/13
 **/
public class AdapterTest {
    public static void main(String[] args) {

        System.out.println("----------  Adapter Test----------");
        AnimalFactory  animalFactory=new AnimalFactory();
        Animal cat = animalFactory.run("Cat");
        Animal sheep = animalFactory.run("Sheep");
        Animal chicken = animalFactory.run("Chicken");
        GrassEat grassEat = new GrassEat();
        grassEat.eat("Grass", sheep);
        grassEat.eat("Normal", cat);
        grassEat.eat("Normal", chicken);
    }

}