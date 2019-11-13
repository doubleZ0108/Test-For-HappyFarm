package com.tester.DesignPatternTest;

import com.farm.FarmManager;
import com.shop.employee.CornSeed;
import com.shop.employee.PotatoSeed;

/**
 * @program: Test-For-HappyFarm
 * @description:
 * @author: Di
 * @create: 2019/11/13
 **/
public class MediatorTest {
    static public void main(String[] args){
        System.out.println("—————————————-------------------------------------———— Test[Mediator]Pattern —————————————-------------------------------------————");
        System.out.println("FarmManager : seeding() :  Add the seeds into the FiledManager.");

        FarmManager fm=FarmManager.getInstance();
        System.out.println("\nSeeding.");
        fm.saveFieldStatus();
        fm.seeding(PotatoSeed.class);
        fm.seeding(PotatoSeed.class, 0);
        fm.seeding(PotatoSeed.class);
        fm.seeding(CornSeed.class);
        System.out.println("—————————————---------------------------------------------- End ————------—————————-------------------------------------————");
    }
}