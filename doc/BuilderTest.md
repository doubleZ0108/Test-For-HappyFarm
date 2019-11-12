# Builder 模式测试

### 测试逻辑合理性

建造者模式是为了由多个简单的对象一步一步创建成一个复杂的对象，它很方便的提供了一些构造函数
所拥有的功能。在商店创建订单时会出现订单中包含不同种类和不同数量的商品的情况，这个时候我们
就需要采用建造者模式，将这些不同的类的商品，根据他们的单价以及数量来计算他们的总价格。

我们在测试的过程中，考虑到 Builder 模式能够简化用户初始化对象的时候所做的各种操作的性质，于是就在测试中添加了与用户互动的环节。我们通过允许用户输入各种 plant 的个数来为用户构造专门的订单。这样能够充分的检验该小组所实现的 Builder 模式的情况。

### 测试用例正确性

经过我们的测试，该小组所设置的 Builder 模式表现良好，能够充分的体现出 Builder 模式在构造对象这种操作上的优越性。

### 重写测试

我们首先邀请用户来输入每一种具体的商品要多少，然后根据用户的输入来构造响应的订单。

```java
public class BuilderTest {
  public static void main(String[] args){
     /**
       * @description: let the user to choose what to buy and how many of each type to buy
       *
       * @param args :
       *
       * @return : void
       **/
    System.out.println("----------  Builder Test----------");
    System.out.println("how many of the following type of plant do you want?");
    Map<String,Class> orderMap = new HashMap<>();
    orderMap.put("Egg",Egg.class);
    orderMap.put("Eggcake", EggCake.class);
    orderMap.put("Potato",Potato.class);
    orderMap.put("Corn",Corn.class);
    orderMap.put("Wheat",Wheat.class);
    Scanner scanner = new Scanner(System.in);
    Map<Class,Integer> orderDetailMap = new HashMap<>();
    for (Map.Entry<String,Class> entry:orderMap.entrySet()){
      // ask how many plant does the customer want one by one
      System.out.println(MessageFormat.format("How many {0} do you want? " +
        "(enter 0 if you don't want it, negative numbers are considered 0)",entry.getKey()));
      String number = scanner.nextLine();
      int orderNumber;
      try {
        orderNumber = Integer.parseInt(number);
      }catch (NumberFormatException error){
        orderNumber = 0;
      }
      if(orderNumber<0) orderNumber = 0;
      if(orderNumber>0){
        RepositoryProxy.Instance().add(entry.getValue(),orderNumber);
        orderDetailMap.put(entry.getValue(),orderNumber);
      }
    }
    Employee.createBuyOrder(orderDetailMap);
  }
}
```



### 测试结果

![image-20191112104346868](img/builder.png)



### 评分

| 设计模式 | Class/Interface API      | framework完成分（70） | Sample program完成度（30） | 备注说明                       |
| -------- | ------------------------ | --------------------- | -------------------------- | ------------------------------ |
| Builder  | MultipleItemOrderBuilder | 70                    | 30                         | 用例情节合理，设计模式实现良好 |

