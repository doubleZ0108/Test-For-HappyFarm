### 测试逻辑合理性

Decorator设计模式有以下两大特点：1.装饰器与被装饰者继承自同一个抽象类或实现同一个接口，调用者只知道该抽象类或接口的存在，而不知道有装饰类；2.装饰器之间呈链表状排列，且在构造该链表时被装饰者被当作参数传递给装饰器。在该组的类设计中，被装饰者是羊毛，装饰器是染料，而这二者同时实现了wool接口，故满足了第一点。而在连续三次染色过程中，将被染色的羊毛均被当作参数传给了染料，故这种设计满足第二点。综上，该小组的测试逻辑十分合理。

### 测试用例正确性

在该组的测试代码中，首先声明了一个wool实例，它是没有被染色的羊毛。而在接下来的三次染色过程中，被染色的羊毛均被当作参数传给了染料，接着打印出这个被染色后的羊毛的description，可以看到控制台上依次输出了这三次染色过程，故该组的测试用例正确性良好。

### 重写测试（逻辑说明+代码）

经系统初始化后，已生成了三个normal wool，这三个normal wool用一个normal wool表示。此时客户端有三次机会给这个normal wool染色，即需要在控制台中输入三次燃料的颜色。染色结束后，控制台会打印出染色的结果。

```java
public class DecoratorTest {
    static public void main(String[] args){
        System.out.println("\n\n-------------Decorator Test-------------");
        AnimalFactory animalFactory = new AnimalFactory();
        Animal sheep = animalFactory.run("Sheep");

        System.out.println("Start getting 3 normal wool from sheep (id: " + sheep.id + ").");
        Wool normalWool = ((Sheep) sheep).beSheared(3, "Normal");
        System.out.println("You have 3 chances to dye the wool.");
        int color;

        //The first time
        for(int i = 1;i<=3;i++){
            while(true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Choose No." + i + " color:[1]Green [2]Blue [3]Red");
                    color = scanner.nextInt();
                    if (color == 1){
                        normalWool = new GreenWoolDecorator(normalWool);
                        break;
                    }
                    else if(color == 2){
                        normalWool = new BlueWoolDecorator(normalWool);
                        break;
                    }
                    else if(color == 3){
                        normalWool = new RedWoolDecorator(normalWool);
                        break;
                    }
                    else{
                        System.out.println("Please enter '1', '2' or '3'");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter an integer!");
                }
            }
        }
        System.out.println(normalWool.getDescription());
        
    }
}
```



### 测试结果（截图）

![Decorator.png](https://github.com/doubleZ0108/Test-For-HappyFarm/blob/master/doc/img/Decorator.png?raw=true)

### 评分

| 设计模式  | Class/Interface API                                          | framework完成分（70） | Sample program完成度（30） | 备注说明 |
| --------- | ------------------------------------------------------------ | --------------------- | -------------------------- | -------- |
| Decorator | AnimalFactory, Animal, Wool, Sheep, GreenWoolDecorator, BlueWoolDecorator, RedWoolDecorator | 70                    | 30                         |          |

