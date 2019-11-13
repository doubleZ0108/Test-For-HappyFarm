## Memento模式测试

### 测试逻辑合理性

Memento模式用来保存系统状态，并且可以在之后被恢复。

农场中的土地可以被视为一个系统，系统的状态信息包括土地的个数以及每块土地上植物的状态，在特定的时刻记录下这些信息就可以作为一个备忘录，为每次记录的备忘录设置编号，随后就可以根据备忘录的编号回退到之前的状态。

这里`FieldMemento`作为备忘录类来保存土地状态，`FieldManager`用来管理备忘录，`FarmManager`用来产生备忘录并且可以恢复到历史状态。

### 测试用例正确性

经过我们的测试，该小组所设置的`Memento`模式表现良好，能够在任意时刻对土地状态进行保存，并且提供了完善的恢复流程，各个类划分也较为明确，`Memento`模式得到了较为完善的实现，但是未将`FiledManager`独立出来进行管理`FieldMemento`，而是嵌入到了`FarmManager`中，虽然也得到了比较良好的实现，但是增加了耦合性，增大了扩展的难度。

### 重写测试（逻辑说明+代码）

首先，声明一个`FarmManager`类的`fm`对象，该对象中嵌入了`FieldMemento`类和`FieldManager`类，我们在进行了一系列种植操作后，对状态进行保存和恢复，都能够得到了实现。

```java
public class MementoTest {
    public static void main(String[] args) {
        System.out.println("\n\n-------------Memento Test-------------");
        FarmManager fm=FarmManager.getInstance();
        System.out.println("\nSave the status at the beginning.");
        RepositoryProxy.Instance().add(CornSeed.class, 100);
        RepositoryProxy.Instance().add(PotatoSeed.class, 100);
        RepositoryProxy.Instance().add(WheatSeed.class, 100);

        fm.saveFieldStatus();
        fm.showAllFieldMementos();
        fm.seeding(PotatoSeed.class);
        fm.seeding(PotatoSeed.class, 0);
        fm.seeding(PotatoSeed.class,1);
        fm.seeding(CornSeed.class);
        System.out.println("Save the second status.");
        fm.saveFieldStatus();
        fm.seeding(WheatSeed.class,1);
        fm.seeding(WheatSeed.class);
        fm.seeding(CornSeed.class);
        fm.saveFieldStatus();
        fm.showAllFieldMementos();
        System.out.println("Restore the second status, by just destroying all the plants planted after that.");
        fm.restore(1);
        System.out.println("Restore the first status");
        fm.restore(0);
    }
}
```

### 测试结果（截图）

```
-------------Memento Test-------------

Save the status at the beginning.
Single RepositoryProxy constructs.
RepositoryProxy: CornSeed in repository add: 100, now: 100
RepositoryProxy: PotatoSeed in repository add: 100, now: 100
RepositoryProxy: WheatSeed in repository add: 100, now: 100

Saving memento:

Our field:
Empty.

Succeed.



Start to show all mementos.

No.0 memento: 
Empty.


All showed.

Succeeded to  plant a new Potato Planton No.0.
RepositoryProxy: PotatoSeed in repository consume: 1, now: 99
Fail. There is already a plant.
Succeeded to  plant a new Potato Planton No.1.
RepositoryProxy: PotatoSeed in repository consume: 1, now: 98
Succeeded to  plant a new Corn Planton No.2.
RepositoryProxy: CornSeed in repository consume: 1, now: 99
Save the second status.

Saving memento:

Our field:
No.0 fieldPotato Plant, growth point:0/100.
No.1 fieldPotato Plant, growth point:0/100.
No.2 fieldCorn Plant, growth point:0/120.

Succeed.

Fail. There is already a plant.
Succeeded to  plant a new Wheat Planton No.3.
RepositoryProxy: WheatSeed in repository consume: 1, now: 99
Succeeded to  plant a new Corn Planton No.4.
RepositoryProxy: CornSeed in repository consume: 1, now: 98

Saving memento:

Our field:
No.0 fieldPotato Plant, growth point:0/100.
No.1 fieldPotato Plant, growth point:0/100.
No.2 fieldCorn Plant, growth point:0/120.
No.3 fieldWheat Plant, growth point:0/80.
No.4 fieldCorn Plant, growth point:0/120.

Succeed.



Start to show all mementos.

No.0 memento: 
Empty.


No.1 memento: 
No.0 field: Potato Plant. Growth point: 0/100.
No.1 field: Potato Plant. Growth point: 0/100.
No.2 field: Corn Plant. Growth point: 0/120.


No.2 memento: 
No.0 field: Potato Plant. Growth point: 0/100.
No.1 field: Potato Plant. Growth point: 0/100.
No.2 field: Corn Plant. Growth point: 0/120.
No.3 field: Wheat Plant. Growth point: 0/80.
No.4 field: Corn Plant. Growth point: 0/120.


All showed.

Restore the second status, by just destroying all the plants planted after that.
Restoring No.1 memento.

Our field:
No.0 fieldPotato Plant, growth point:0/100.
No.1 fieldPotato Plant, growth point:0/100.
No.2 fieldCorn Plant, growth point:0/120.

Succeed.
Restore the first status
Restoring No.0 memento.

Our field:
Empty.

Succeed.
```

### 评分

| 设计模式 | Class/Interface API                       | framework完成分（70） | Sample program完成度（30） | 备注说明                                                     |
| -------- | ----------------------------------------- | --------------------- | -------------------------- | ------------------------------------------------------------ |
| Memento  | FieldMemento,  FieldManager,  FarmManager | 70                    | 30                         | 用例情节合理，设计模式实现良好。但是未将`FiledManager`独立出来进行管理`FieldMemento`，而是嵌入到了`FarmManager`中，虽然也得到了比较良好的实现，但是增加了耦合性，增大了扩展的难度。 |

