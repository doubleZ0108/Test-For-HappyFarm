package com.tester.DesignPatternTest;

import com.processing.FarmProcessingFactory;
import com.processing.InitialEnvironment;
import com.processing.PastureProcessingFactory;
import com.shop.employee.Chicken;
import com.shop.employee.Corn;
import com.shop.employee.Egg;
import com.shop.employee.Wheat;
import com.shop.order.factory.Order;
import com.shop.order.factory.OrderFactory;
import com.shop.repository.RepositoryProxy;

import java.util.Random;

/**
 * @program: Test-For-HappyFarm
 * @description:
 * @author: Yimo Liu
 * @create: 2019/11/13
 **/
public class StateTest {
    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println("—————————————-------------------------------------———— Test[State]Pattern —————————————-------------------------------------————");
        System.out.println("FarmProcessingFactory : setEnvironment() :  Set an instance of environment for this farm processing factory.");
        System.out.println("FarmProcessingFactory : getMachinesState() :  Get the state information of machines of this farm.");
        System.out.println("OrderFactory : getOrder() :  Get an order from the order factory.");
        System.out.println("Order : createOrder() :  Create an instance of this order.");
        System.out.println("");

        FarmProcessingFactory farmProcessingFactory = new FarmProcessingFactory();
        PastureProcessingFactory pastureProcessingFactory = new PastureProcessingFactory();
        for (int i = 0; i < 15; i++) {
            farmProcessingFactory.addMachine();
            pastureProcessingFactory.addMachine();
        }
        farmProcessingFactory.setEnvironment(new InitialEnvironment(15, 15));
        farmProcessingFactory.handle();
        pastureProcessingFactory.setEnvironment(new InitialEnvironment(15, 15));
        pastureProcessingFactory.handle();


        System.out.println("Check the State of FarmProcessingFactory's Machines:");
        farmProcessingFactory.getMachinesState();
        System.out.println("Check the State of PastureProcessingFactory's Machines:");
        pastureProcessingFactory.getMachinesState();


        Random random = new Random();
        int temprature = random.nextInt(20) + 10;
        int humidity = random.nextInt(25) + 10;
        farmProcessingFactory.setEnvironment(new InitialEnvironment(temprature, humidity));
        System.out.println("Check FarmProcessingFactory's Environment:");
        farmProcessingFactory.handle();
        temprature = random.nextInt(20) + 10;
        humidity = random.nextInt(25) + 10;
        pastureProcessingFactory.setEnvironment(new InitialEnvironment(temprature, humidity));
        System.out.println("Check PastureProcessingFactory's Environment:");
        farmProcessingFactory.handle();
        random = null;

        System.out.println("\n\n---------- Order Status Test ----------");
        OrderFactory orderFactory = new OrderFactory();
        System.out.println("Buy two kilogram corn.");
        Order order1 = orderFactory.getOrder("BUY");
        order1.createOrder(Corn.class, 2, 5.00);
        System.out.println("\nSale two kilogram corn.");
        Order order3 = orderFactory.getOrder("SALE");
        order3.createOrder(Corn.class, 2, 5.00);

    }

}