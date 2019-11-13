### 测试逻辑合理性

在农场的设计中，我们调用Farm Manager的方法后，将指派StockManager和FieldManager进行代理工作，而FarmManager本身无需工作，此时FarmManager代理所有StockManager和FieldManager的操作，且这两个被代理类无法在farm包外访问。该测试符合代理模式的逻辑。

### 测试用例正确性

调用FarmManager的seeding()后，将由FieldManager代理执行种植操作。

### 重写测试（逻辑说明+代码）

通过调用一系列的seeding、harvest、giveFertilizer函数来通过代理对Repository进行操作

```java
public class ProxyTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

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
```



### 测试结果（截图）

![Proxy](img\Proxy.png)

### 评分

| 设计模式 | Class/Interface API         | framework完成分（70） | Sample program完成度（30） | 备注说明 |
| -------- | --------------------------- | --------------------- | -------------------------- | -------- |
| Proxy    | RepositoryProxy，Repository | 70                    | 30                         | 无       |

