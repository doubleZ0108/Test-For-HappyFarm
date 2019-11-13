package com.tester.DesignPatternTest;

import com.shop.employee.Corn;
import com.shop.order.factory.Order;
import com.shop.order.factory.OrderFactory;

public class NullObjectTest {
    static public void main(String[] args){
        System.out.println("—————————————-------------------------------------———— Test[NullObject]Pattern —————————————-------------------------------------————");
        System.out.println("OrderFactory : OrderFactory() : create an OrderFactory.");
        System.out.println("OrderFactory : getOrder(orderType) : create an order whose type is 'orderType'.");
        System.out.println("FarmManager : createOrder() : create an order.");
        OrderFactory orderFactory = new OrderFactory();
        System.out.println("create an order whose type is 'SAL'(This type is wrong).");
        Order order2 = orderFactory.getOrder("SAL");
        order2.createOrder(Corn.class, 2, 5.00);
        System.out.println("—————————————---------------------------------------------- End ————------—————————-------------------------------------————");
    }
}
