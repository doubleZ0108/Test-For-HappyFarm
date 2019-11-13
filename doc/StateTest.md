### 测试逻辑合理性

- Factory测试：

  State模式允许对象在内部状态发生改变时改变它自身的行为，提供了方便的解决复杂对象状态转换的方法、解决了不同状态下行为的封装问题。在我们的场景中，我们对订单的状态变化使用状态模式。

  在测试中，我们将通过创建订单来展示过程中的订单状态变化。从未支付阶段（UnpaidState）到已支付阶段（PaidState）到商品已交付阶段（DeliveredState）。通过状态模式的运用，减少订单错误的可能。

  三种状态的区别在于支付和商品交付动作 pay() 和 deliverGoods() 方法，同一订单在不同的阶段会有不同的方法，如在PaidState下该方法将会在收到商品交付命令后更新库存，并且重置当前订单的状态。

- Shop测试：

  State模式允许对象在内部状态发生改变时改变它自身的行为，提供了方便的解决复杂对象状态转换的方法、解决了不同状态下行为的封装问题。在我们的场景中，我们对订单的状态变化使用状态模式。

  在测试中，我们将通过创建订单来展示过程中的订单状态变化。从未支付阶段（UnpaidState）到已支付阶段（PaidState）到商品已交付阶段（DeliveredState）。通过状态模式的运用，减少订单错误的可能。

  三种状态的区别在于支付和商品交付动作 pay() 和 deliverGoods() 方法，同一订单在不同的阶段会有不同的方法，如在PaidState下该方法将会在收到商品交付命令后更新库存，并且重置当前订单的状态。

### 测试用例正确性

- Factory测试：
  1.	首先初始化农产品加工厂与牧产品加工厂
  2.	通过调用加工厂的setEnvironment()方法来初始化加工厂的环境
  3.	用户通过调用工厂中的setEnvironment()方法来模拟外界环境发生改变的情况，之后在调用加工厂类的handle()方法来根据环境调整加工厂中的环境。
- Shop测试：
  1. 新建购买订单
  2. 新建出售订单

### 重写测试（逻辑说明+代码）

```java
public class StateTest {
    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println("-------------State Test of factory-------------");

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
```



### 测试结果（截图）

![state(factory)](img\state(factory).png)

<img src="img\shop_state.png" alt="state(shop)" style="zoom:50%;" />

### 评分

| 设计模式 | Class/Interface API                            | framework完成分（70） | Sample program完成度（30） | 备注说明                                               |
| -------- | ---------------------------------------------- | --------------------- | -------------------------- | ------------------------------------------------------ |
| Mediator | Person, Dog, Factory(这个设计模式用到了哪些类) | 67                    | 27                         | （说明缺点、扣分原因，满分写无）例：XX中的XX它没有用到 |

