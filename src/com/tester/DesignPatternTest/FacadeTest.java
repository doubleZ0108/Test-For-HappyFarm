package com.tester.DesignPatternTest;

import com.pasture.Facade.AnimalPooMaker;

import java.util.Scanner;

/**
 * @program: Test-For-HappyFarm
 * @description: Test the facade pattern.
 * @author: Yimin Li
 * @create: 2019/11/12
 **/
public class FacadeTest {
    public static void main(String[] args) {
        System.out.println("—————————————-------------------------------------———— Test[Facade Factory]Pattern —————————————-------------------------------------————");

        System.out.println("AnimalPooMaker : pooForCat() :  deal with the cat poo");
        System.out.println("AnimalPooMaker : pooForChicken() :  deal with the chicken poo");
        System.out.println("AnimalPooMaker : pooForSheep() :  deal with the sheep poo");


        AnimalPooMaker animalPooMaker = new AnimalPooMaker();
        int option;
        int quantity;
        while(true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("choose an option: [1]pooForCat [2]pooForChicken [3]pooForSheep [else]exit");
                option = scanner.nextInt();
                if(option<=3 && option>=1){
                    System.out.println("Please enter an integer representing the quantity:" );
                    quantity = scanner.nextInt();
                    if(option == 1)
                        animalPooMaker.pooForCat(quantity);
                    else if(option == 2)
                        animalPooMaker.pooForChicken(quantity);
                    else
                        animalPooMaker.pooForSheep(quantity);
                }
                else
                    break;
            } catch (Exception e) {
                System.out.println("Please input an integer!");
            }
        }
        
        System.out.println("—————————————---------------------------------------------- End ————------—————————-------------------------------------————");
    }
}
