package com.tester.DesignPatternTest;

import com.farm.FarmManager;
import com.shop.employee.*;
import com.shop.repository.RepositoryProxy;

import java.util.Scanner;

/**
 * @program: Test-For-HappyFarm
 * @description: Add modified test the flyweight pattern.
 * @author: Yimin Li
 * @create: 2019/11/12
 **/
public class FlyweightTest {
    public static void main(String[] args) {
        System.out.println("—————————————-------------------------------------———— Test[Flyweight Factory]Pattern —————————————-------------------------------------————");
        System.out.println("FarmManager : FarmManager() :  create a farm manager.");
        System.out.println("FarmManager : seeding(PotatoSeed.class) :  plant a potato in the field.");
        System.out.println("FarmManager : giveFertilizer(0, Fertilizer.class) :  put the fertilizer to the field");
        
        
        RepositoryProxy.Instance();
        RepositoryProxy.Instance();

        RepositoryProxy.Instance().add(CornSeed.class, 100);
        RepositoryProxy.Instance().add(CornSeed.class, 100);
        RepositoryProxy.Instance().add(PotatoSeed.class, 100);
        RepositoryProxy.Instance().add(WheatSeed.class, 100);
        RepositoryProxy.Instance().add(ChemicalFertilizer.class, 100);
        RepositoryProxy.Instance().add(OrganicFertilizer.class, 100);
        RepositoryProxy.Instance().ask(Corn.class, 150);
        RepositoryProxy.Instance().ask(Corn.class, 100);

        FarmManager fm=FarmManager.getInstance();

        fm.saveFieldStatus();
        fm.showAllFieldMementos();
        fm.seeding(PotatoSeed.class);
        fm.seeding(PotatoSeed.class, 0);
        fm.seeding(PotatoSeed.class);
        fm.seeding(CornSeed.class);
        fm.saveFieldStatus();
        fm.seeding(WheatSeed.class);
        fm.seeding(WheatSeed.class);
        fm.seeding(CornSeed.class);
        fm.saveFieldStatus();
        fm.showAllFieldMementos();
        fm.restore(1);
        fm.restore(0);


        fm.seeding(PotatoSeed.class);
        while(true){
            try {
                Scanner scanner = new Scanner(System.in);
                int option;
                System.out.println("Please enter and Integer to choose an option: [1]Give OrganicFertilizer; [2]Give ChemicalFertilizer; [3]Harvest; [else]exit");
                option = scanner.nextInt();
                if(option == 1)
                    fm.giveFertilizer(0, OrganicFertilizer.class);
                else if(option == 2)
                    fm.giveFertilizer(0, ChemicalFertilizer.class);
                else if(option == 3)
                    fm.harvest(0);
                else
                    break;
            } catch (Exception e) {
                System.out.println("Please enter an Integer");
            }
        }
        System.out.println("—————————————---------------------------------------------- End ————------—————————-------------------------------------————");

    }
}
