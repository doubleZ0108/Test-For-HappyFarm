package com.tester.DesignPatternTest;

import com.pasture.Animal;
import com.pasture.Factory.AnimalFactory;
import com.pasture.Strategy.Fight;
import com.pasture.Strategy.Interaction;
import com.pasture.Strategy.Joke;
import com.pasture.Strategy.Sing;

/**
 * @program: Test-For-HappyFarm
 * @description: Add modified test for strategy test
 * @author: Group for testing HappyFarm
 * @create: 2019/11/13
 **/
public class StrategyTest {
    static public void main(String[] args){
        System.out.println("—————————————-------------------------------------———— Test[Strategy]Pattern —————————————-------------------------------------————");
        System.out.println("Interaction : executeInteraction() :  Do specific action for different animals.");

        AnimalFactory animalFactory = new AnimalFactory();
        Animal cat = animalFactory.run("Cat");
        Animal sheep = animalFactory.run("Sheep");
        Animal chicken = animalFactory.run("Chicken");

        Interaction sing = new Interaction(new Sing());
        sing.executeInteraction(cat, sheep);

        Interaction joke = new Interaction(new Joke());
        joke.executeInteraction(sheep, chicken);

        Interaction fight = new Interaction(new Fight());
        fight.executeInteraction(chicken, cat);

        System.out.println("—————————————---------------------------------------------- End ————------—————————-------------------------------------————");
    }
}