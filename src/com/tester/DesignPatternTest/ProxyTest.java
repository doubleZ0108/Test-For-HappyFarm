package com.tester.DesignPatternTest;
import com.shop.employee.*;
import com.shop.repository.RepositoryProxy;
import com.shop.store.SingleStore;
import com.farm.*;


/**
 * @program: Test-For-HappyFarm
 * @description: Add modified test for proxy pattern
 * @author: Yimo Liu
 * @create: 2019/11/13
 **/
public class ProxyTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("—————————————-------------------------------------———— Test[{Proxy]Pattern —————————————-------------------------------------————");
        System.out.println("Employee : createBuyOrder() :  Create an order for an employee.");
        System.out.println("FarmManager : seeding() :  Sow some seeds.");
        System.out.println("FarmManager : saveFieldStatus() :  Save the current status of the field.");
        System.out.println("FarmManager : showAllFieldMementos() :  Show all field mementos.");
        System.out.println("FarmManager : giveFertilizer() :  Use fertilizer on some fields.");
        System.out.println("FarmManager : harvest() :  Harvest plants on this field.");
        System.out.println("");

        SingleStore store = SingleStore.getSingleStore();
        RepositoryProxy.Instance().attach(store);

        Employee.createBuyOrder(CornSeed.class, 1);
        Employee.createBuyOrder(PotatoSeed.class, 10);
        Employee.createBuyOrder(WheatSeed.class, 10);
        Employee.createBuyOrder(ChemicalFertilizer.class, 50);
        Employee.createBuyOrder(OrganicFertilizer.class, 2);

        RepositoryProxy.Instance().showAllItems();

        FarmManager fm=FarmManager.getInstance();

        fm.saveFieldStatus();
        fm.showAllFieldMementos();
        fm.seeding(PotatoSeed.class);
        fm.seeding(PotatoSeed.class, 0);
        fm.seeding(PotatoSeed.class);
        fm.seeding(CornSeed.class);
        fm.seeding(WheatSeed.class);
        fm.seeding(WheatSeed.class);
        fm.seeding(CornSeed.class);
        fm.saveFieldStatus();
        fm.showAllFieldMementos();
        fm.giveFertilizer(0, OrganicFertilizer.class);
        fm.giveFertilizer(0, OrganicFertilizer.class);
        fm.giveFertilizer(0, OrganicFertilizer.class);
        fm.showAllPlants();
        fm.harvest(0);
        fm.showAllPlants();
        fm.giveFertilizer(2, OrganicFertilizer.class);
        fm.giveFertilizer(2, ChemicalFertilizer.class);
        fm.giveFertilizer(2, ChemicalFertilizer.class);
        fm.harvest(2);
        fm.giveFertilizer(2, ChemicalFertilizer.class);
        fm.giveFertilizer(2, ChemicalFertilizer.class);
        fm.giveFertilizer(2, ChemicalFertilizer.class);
        fm.giveFertilizer(2, ChemicalFertilizer.class);
        fm.harvest(2);
        fm.harvest(2);

        fm.saveFieldStatus();
        fm.showAllFieldMementos();
        fm.seeding(PotatoSeed.class);
        fm.seeding(PotatoSeed.class, 51);
        fm.showAllPlants();
        fm.showAllFieldMementos();
        fm.restore(1);
        fm.restore(0);

    }

}