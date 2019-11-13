package com.tester.DesignPatternTest;

import com.processing.*;
import com.shop.employee.Chicken;
import com.shop.employee.Egg;
import com.shop.employee.Flour;
import com.shop.employee.Wheat;
import com.shop.repository.RepositoryProxy;

import java.util.Scanner;

/**
 * @program: Test-For-HappyFarm
 * @description: Add another modified test of Chain of Responsibility pattern.
 * @author: Group for testing HappyFarm
 * @create: 2019/11/13
 **/
public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        System.out.println("—————————————-------------------------------------———— Test[Chain of Responsibility]Pattern —————————————-------------------------------------————");
        System.out.println("AbstractProcessingFactory : doProcess() :  Commit a request to the chain and waiting for the certain factory to answer.");
        System.out.println("FarmProcessingFactory : doProcess() :  FarmProcessingFactory handle a request.");
        System.out.println("PastureProcessingFactory : doProcess() :  PastureProcessingFactory handle a request.");
        System.out.println("Request : Request() :  Generate a request from the user which will be commit to the responsibility chain.");
        System.out.println("");


        System.out.println("Please first choice the stack of...");
        int stack = 0;
        RepositoryProxy.Instance();
        Scanner sc = new Scanner(System.in);

        System.out.println("Chicken: ");
        while(true) {
            if(sc.hasNextInt()) {
                stack = sc.nextInt();
                if(stack > 0) {
                    RepositoryProxy.Instance().add(Chicken.class, stack);
                    break;
                }
                else {
                    System.out.println("The stack must more than 0.");
                    continue;
                }
            }
            Scanner temp = new Scanner(System.in);
            temp.next();
            System.out.println("The stack must be a int number.");
        }
        System.out.println("Wheat: ");
        while(true) {
            if(sc.hasNextInt()) {
                stack = sc.nextInt();
                if(stack > 0) {
                    RepositoryProxy.Instance().add(Wheat.class, stack);
                    break;
                }
                else {
                    System.out.println("The stack must more than 0.");
                    continue;
                }
            }
            Scanner temp = new Scanner(System.in);
            temp.next();
            System.out.println("The stack must be a int number.");
        }
        System.out.println("Egg: ");
        while(true) {
            if(sc.hasNextInt()) {
                stack = sc.nextInt();
                if(stack > 0) {
                    RepositoryProxy.Instance().add(Egg.class, stack);
                    break;
                }
                else {
                    System.out.println("The stack must more than 0.");
                    continue;
                }
            }
            Scanner temp = new Scanner(System.in);
            temp.next();
            System.out.println("The stack must be a int number.");
        }
        System.out.println("Flour: ");
        while(true) {
            if(sc.hasNextInt()) {
                stack = sc.nextInt();
                if(stack > 0) {
                    RepositoryProxy.Instance().add(Flour.class, stack);
                    break;
                }
                else {
                    System.out.println("The stack must more than 0.");
                    continue;
                }
            }
            Scanner temp = new Scanner(System.in);
            temp.next();
            System.out.println("The stack must be a int number.");
        }


        System.out.println("Now add the FarmProcessingFactory and PastureProccessingFactory in the chain.");
        FactoryChain factoryChain = new FactoryChain();
        FarmProcessingFactory farmProcessingFactory = new FarmProcessingFactory();
        PastureProcessingFactory pastureProcessingFactory = new PastureProcessingFactory();
        factoryChain.addFactory(farmProcessingFactory);
        factoryChain.addFactory(pastureProcessingFactory);

        while(true) {
            System.out.println("Now make request of certain product and its number (\"q\" to quit).");
            System.out.println("The product name: [Eggcake | ChickenKebabs]");
            Scanner name = new Scanner(System.in);
            String requestName = name.next();
            if (requestName.equals("q")) {
                break;
            }
            if (requestName.equals("Eggcake") || requestName.equals("ChickenKebabs")) {
                Request request = new Request();
                request.setRequest(requestName);
                int amount = 0;
                while (true) {
                    Scanner temp = new Scanner(System.in);
                    System.out.println("The amount:");
                    if (temp.hasNextInt()) {
                        amount = temp.nextInt();
                        if (amount > 0) {
                            request.setNum(amount);
                            request.setRepositoryProxy(RepositoryProxy.Instance());
                            break;
                        } else {
                            System.out.println("The amount must more than 0.");
                        }
                    }
                }
                Response response = new Response();
                factoryChain.setIndex(0);
                factoryChain.doProcess(request, response, factoryChain);
            }
            else {
                System.out.println("We cannot make this.");
            }
        }
        System.out.println("—————————————---------------------------------------------- End ————------—————————-------------------------------------————");

    }
}
