### 测试逻辑合理性

Null Object设计模式通过对缺失对象的封装，以提供默认无任何行为的对象替代品。这个设计模式的目的是为了减少了对对象是否为 Null 的判断。在该组同学的Order类的设计中，Order的构造函数需要参数orderType，如果给定的orderType不存在，则该Order会被创建为null object，而这个null object的成员函数与其他real object成员函数是不一样的。故该组的测试逻辑是合理的。

### 测试代码正确性

在该组成员的测试代码中，首先调用订单工厂orderFactory的getOrder函数，企图生成一个种类为'SAL'的订单，但是由于系统中并不存在这个种类的订单，故该订单将被创建为空对象。在调用这个空对象的createOrder方法时，在控制台会报错，故该测试代码正确性良好。

### 重写测试（逻辑说明+代码）

该测试模式较为简单，测试代码不需进行较大改动。

```java
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
```



### 测试结果（截图）

![NullObject.jpg](https://github.com/doubleZ0108/Test-For-HappyFarm/blob/master/doc/img/NullObject.jpg?raw=true)

### 评分

| 设计模式   | Class/Interface API | framework完成分（70） | Sample program完成度（30） | 备注说明 |
| ---------- | ------------------- | --------------------- | -------------------------- | -------- |
| NullObject | OrderFactory, Order | 70                    | 30                         |          |

