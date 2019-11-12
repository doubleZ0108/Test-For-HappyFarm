package com.tester.DesignPatternTest;

import com.pasture.Animal;
import com.pasture.Decorator.BlueWoolDecorator;
import com.pasture.Decorator.GreenWoolDecorator;
import com.pasture.Decorator.RedWoolDecorator;
import com.pasture.Decorator.Wool;
import com.pasture.Factory.AnimalFactory;
import com.pasture.Sheep;

import java.util.Scanner;

/**
 * @program: Test-For-HappyFarm
 * @description: Test the decorator pattern.
 * @author: Yimin Li
 * @create: 2019/11/12
 **/
public class DecoratorTest {
    static public void main(String[] args){
        System.out.println("\n\n-------------Decorator Test-------------");
        AnimalFactory animalFactory = new AnimalFactory();
        Animal sheep = animalFactory.run("Sheep");

        System.out.println("Start getting 3 normal wool from sheep (id: " + sheep.id + ").");
        Wool normalWool = ((Sheep) sheep).beSheared(3, "Normal");
        System.out.println("You have 3 chances to dye the wool.");
        int color;

        //The first time
        for(int i = 1;i<=3;i++){
            while(true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Choose No." + i + " color:[1]Green [2]Blue [3]Red");
                    color = scanner.nextInt();
                    if (color == 1){
                        normalWool = new GreenWoolDecorator(normalWool);
                        break;
                    }
                    else if(color == 2){
                        normalWool = new BlueWoolDecorator(normalWool);
                        break;
                    }
                    else if(color == 3){
                        normalWool = new RedWoolDecorator(normalWool);
                        break;
                    }
                    else{
                        System.out.println("Please enter '1', '2' or '3'");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter an integer!");
                }
            }
        }
        System.out.println(normalWool.getDescription());

    }
}
