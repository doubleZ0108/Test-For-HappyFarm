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

        System.out.println("—————————————-------------------------------------———— Test[Adapter]Pattern —————————————-------------------------------------————");
        System.out.println("AnimalFactory : run(String type) :  Create an animal designated.");
        System.out.println("GrassEat : eat(String eatingType, Animal animal) :  Execute eat action in the designating way.");
        System.out.println("");

        System.out.println("=== Create an animal factory:");
        AnimalFactory  animalFactory=new AnimalFactory();
        System.out.println("=== Create a cat:");
        Animal cat = animalFactory.run("Cat");
        System.out.println("=== Create a sheep:");
        Animal sheep = animalFactory.run("Sheep");
        System.out.println("=== Create a chicken:");
        Animal chicken = animalFactory.run("Chicken");
        System.out.println("=== Create an action of eating grass:");
        GrassEat grassEat = new GrassEat();
        System.out.println("=== Sheep eats grass :");
        grassEat.eat("Grass", sheep);
        System.out.println("=== Cat eats normal food :");
        grassEat.eat("Normal", cat);
        System.out.println("=== Chicken eats normal food :");
        grassEat.eat("Normal", chicken);

        System.out.println("—————————————---------------------------------------------- End ————------—————————-------------------------------------————");

    }

}