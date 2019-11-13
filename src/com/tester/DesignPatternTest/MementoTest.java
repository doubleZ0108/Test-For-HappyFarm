package com.tester.DesignPatternTest;

import com.farm.FarmManager;
import com.shop.employee.CornSeed;
import com.shop.employee.PotatoSeed;
import com.shop.employee.WheatSeed;
import com.shop.repository.RepositoryProxy;

/**
 * @program: Test-For-HappyFarm
 * @description: Add modified test memento pattern
 * @author: Xuefei Lv
 * @create: 2019/11/13
 **/

public class MementoTest {
    public static void main(String[] args) {
        System.out.println("—————————————-------------------------------------———— Test[Memento]Pattern —————————————-------------------------------------————");
        System.out.println("FarmManager : saveFieldStatus() : Saving the status of all plant in field as a memento");
        System.out.println("FarmManager : showAllFieldMementos() : Showing information of all memento");
        System.out.println("FarmManager : seeding() : Planting seeds");
        System.out.println("FarmManager : restore() : Restoring status to specified memento");
        System.out.println("");
        FarmManager fm=FarmManager.getInstance();
        System.out.println("\nSave the status at the beginning.");
        RepositoryProxy.Instance().add(CornSeed.class, 100);
        RepositoryProxy.Instance().add(PotatoSeed.class, 100);
        RepositoryProxy.Instance().add(WheatSeed.class, 100);

        fm.saveFieldStatus();
        fm.showAllFieldMementos();
        fm.seeding(PotatoSeed.class);
        fm.seeding(PotatoSeed.class, 0);
        fm.seeding(PotatoSeed.class,1);
        fm.seeding(CornSeed.class);
        System.out.println("Save the second status.");
        fm.saveFieldStatus();
        fm.seeding(WheatSeed.class,1);
        fm.seeding(WheatSeed.class);
        fm.seeding(CornSeed.class);
        fm.saveFieldStatus();
        fm.showAllFieldMementos();
        System.out.println("Restore the second status, by just destroying all the plants planted after that.");
        fm.restore(1);
        System.out.println("Restore the first status");
        fm.restore(0);
        System.out.println("—————————————---------------------------------------------- End ————------—————————-------------------------------------————");
    }
}
