package com.tester.DesignPatternTest;

import com.pasture.Animal;
import com.pasture.Factory.AnimalFactory;
import com.pasture.Observer.AnimalMonitor;
import com.pasture.Observer.Telegraph;
import com.pasture.Observer.Telephone;
import com.pasture.Observer.WarningLight;
import com.shop.repository.RepositoryProxy;

/**
 * @program: Test-For-HappyFarm
 * @description: Test the observer pattern.
 * @author: Yifan Ye
 * @create: 2019/11/11
 **/
public class ObserverTest
{
    public static void main(String[] args)
    {
        System.out.println("\n\n-------------Observer Test-------------");
        AnimalFactory animalFactory = new AnimalFactory();
        Animal chicken = animalFactory.run("Chicken");
        AnimalMonitor monitor = new AnimalMonitor();

        new WarningLight(monitor);
        new Telegraph(monitor);
        new Telephone(monitor);

        monitor.animalRunAway(chicken);
    }
}