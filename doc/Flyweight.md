### 测试逻辑合理性

该小组用运用工厂模式的思想，对于每一种肥料至多创建一个实体，在农场主需要施肥时直接调用该种肥料的实体。该小组正确认识到了flyweight设计模式是对工厂模式的进一步升华，在测试中体现出了工厂模式的思想，但还需进一步体现出flyweight的思想。flyweight设计模式多用于具有组合关系的类中，当一个类是由大量的某几种类构成时，这几种类可以采用flyweight模式，将它们设置为单例，这样做的好处是只需调用这几个单例的函数便可以完成它们组合在一起的那个大类的复杂操作。但在该组的测试代码中，并未出现具有组合关系的类，也并未出现大量地重复调用多次成员函数的情况，故类设计代码需要完善。

### 测试用例正确性

本组在执行该组同学的测试代码时，发现控制台输出“Fail to give fertilizer. Plant is already mature."。本组同学猜想，出现该情况的原因时由于该组同学所有设计模式的测试代码都写在了一个main函数中，而当测试到flyweight设计模式时，植物已经成熟，不需要施肥。故该测试代码测试失败，需要改进。

### 重写测试（逻辑说明+代码）

本组同学没有时间再去帮该组同学重新设计类的实现，即没有时间去解决测试逻辑中的不合理性，故以下修改版代码仅为了解决测试用例的不正确性。

经系统初始化后，农田有一个编号为0的田地，种了马铃薯，成熟度为0。接着用户被循环地询问选择以下操作：[1]Give OrganicFertilizer; [2]Give ChemicalFertilizer; [3]Harvest; [else]exit。施有机肥可以提高50点成熟度，施化肥可以提高20点成熟度，成熟度到达100点后，马铃薯就成熟了。成熟后可以收获，未成熟时选择收获会报错，成熟后继续施肥也会报错。

```java
public class FlyweightTest {
    public static void main(String[] args) {
        
        //前面有很多初始化代码，就不在此展示了
        
        System.out.println("\n\n-------------Flyweight Test-----------");
        System.out.println("Fertilizers are using flyweight pattern which generate only one instance for each type of fertilizer.");
        while(true){
            try {
                Scanner scanner = new Scanner(System.in);
                int option;
                System.out.println("Please enter and Integer to choose an option: [1]Give OrganicFertilizer; [2]Give ChemicalFertilizer; [3]Harvest; [else]exit");
                option = scanner.nextInt();
                if(option == 1)
                    fm.giveFertilizer(0, OrganicFertilizer.class);
                else if(option == 2)
                    fm.giveFertilizer(0, ChemicalFertilizer.class);
                else if(option == 3)
                    fm.harvest(0);
                else
                    break;
            } catch (Exception e) {
                System.out.println("Please enter an Integer");
            }
        }
    }
}
```



### 测试结果（截图）

![Flyweight](C:\Users\stone\Desktop\软件架构\测试作业\Flyweight.png)



### 评分

| 设计模式  | Class/Interface API                                          | framework完成分（70） | Sample program完成度（30） | 备注说明                                             |
| --------- | ------------------------------------------------------------ | --------------------- | -------------------------- | ---------------------------------------------------- |
| Flyweight | RepositoryProxy, PotatoSeed,ChemicalFertilizer,OrganicFertilizer, FarmManager | 50                    | 20                         | 扣分点已在”测试逻辑合理性“和”测试用例正确性“中说明。 |

